package Controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class HasteBinController {
	private static URL url;
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	public HasteBinController() {
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
                byte[] input = creatorText.getBytes("utf-8");
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
                
                return "https://pastebin.donoso.mooo.com/" + hastebinKey;
            } else {
            	System.out.println(responseCode);
                return "Error al enviar a Hastebin. Código: " + responseCode;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al conectar con Hastebin.";
        }
    }
}
