package Controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ComentariosController {
	private static final ObjectMapper objectMapper = new ObjectMapper();
	private JsonNode comentarios;
	private static URL url;
	private Logger logger;

	public ComentariosController() {
		logger = Logger.getInstance();
		try {
			ComentariosController.url = new URL("https://jsonplaceholder.typicode.com/comments");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		this.comentarios = peticionApi();
	}

	private JsonNode peticionApi() {
		JsonNode comentarios = null;


		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {

				// Leer la respuesta
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuilder response = new StringBuilder();
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				ObjectMapper mapper = new ObjectMapper();
				comentarios = mapper.readTree(response.toString());

			} else {
				logger.warning("Error en la conexión. Código de respuesta: " + responseCode);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}


		return comentarios;
	}

	public JsonNode obtenerComentarios() {
		List<JsonNode> jsonComentarios = new ArrayList<>();
		Iterator<JsonNode> elements = comentarios.elements();
		while (elements.hasNext()) {
			jsonComentarios.add(elements.next());
		}

		// Reordenar aleatoriamente las entradas
		Collections.shuffle(jsonComentarios);

		JsonNode shuffledArrayNode = objectMapper.valueToTree(jsonComentarios);

		return shuffledArrayNode;
	}
} 
