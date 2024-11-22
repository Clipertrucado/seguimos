package JSIA.WebMoteros.services;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import JSIA.WebMoteros.models.LoginRequest;

@Service
public class ApiService {

    @Value("${api.endpoint}")
    private String apiEndpoint;

    public String sendLoginData(LoginRequest loginRequest) {
        // Crear una instancia de RestTemplate
    	try {
            // Crear un mapa con los pares clave-valor
            Map<String, String> data = new HashMap<>();
            data.put("mail", loginRequest.getEmail() );
            data.put("contrasenya", loginRequest.getPassword());

            // Crear un objeto ObjectMapper para convertir el mapa a JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // Convertir el mapa a JSON
            String jsonString = objectMapper.writeValueAsString(data);
            
            // Mostrar el JSON resultante
            System.out.println(jsonString);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    	
    	 try {           
             // Crear un objeto URL
             URL url = new URL();

             // Abrir una conexión HTTP
             HttpURLConnection conn = (HttpURLConnection) url.openConnection();

             // Configurar el método HTTP y los encabezados
             conn.setRequestMethod("POST");
             conn.setRequestProperty("Content-Type", "application/json");
             conn.setDoOutput(true);

             // JSON que queremos enviar
             String jsonInput = "{\"name\": \"John\", \"email\": \"john@example.com\", \"password\": \"password123\"}";

             // Escribir el JSON en el cuerpo de la solicitud
             try (OutputStream os = conn.getOutputStream()) {
                 byte[] input = jsonInput.getBytes("utf-8");
                 os.write(input, 0, input.length);
             }

             // Leer la respuesta de la API
             int responseCode = conn.getResponseCode();
             System.out.println("Response Code: " + responseCode);

             try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                 StringBuilder response = new StringBuilder();
                 String responseLine;
                 while ((responseLine = br.readLine()) != null) {
                     response.append(responseLine.trim());
                 }
                 System.out.println("Response: " + response.toString());
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
    	
    	
    	
		return apiEndpoint;
    }
    
}

