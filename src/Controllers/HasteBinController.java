package Controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HasteBinController {
	private static final ObjectMapper objectMapper = new ObjectMapper();
	private static URL url;
	private Logger logger;

	public HasteBinController() {
		logger = Logger.getInstance();
		try {
			HasteBinController.url = new URL("https://pastebin.donoso.mooo.com/documents");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public String uploadTextToHastebin(JsonNode creator) {
		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");

			connection.setDoOutput(true);

			objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
			String creatorText = objectMapper.writeValueAsString(creator);

			try (OutputStream os = connection.getOutputStream()) {
				byte[] input = creatorText.getBytes(StandardCharsets.UTF_8);
				os.write(input, 0, input.length);
			}

			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
				StringBuilder response = new StringBuilder();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				String responseString = response.toString();
				String hastebinKey = responseString.split(":")[1].replace("\"", "").replace("}", "");

				logger.success("Link generado correctamente: https://pastebin.donoso.mooo.com/" + hastebinKey);
				return "https://pastebin.donoso.mooo.com/" + hastebinKey;
			} else {
				System.out.println(responseCode);
				logger.warning("Error al enviar a Hastebin. Código: " + responseCode);
				return "Error al enviar a Hastebin. Código: " + responseCode;
			}
		} catch (Exception e) {
			logger.error(e);
			return "Error al conectar con Hastebin.";
		}
	}
}
