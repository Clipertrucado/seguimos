package JSIA.WebMoteros.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


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
	        URL url = new URL(apiEndpoint);
	        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
	        conexion.setRequestMethod("POST");
	        conexion.setRequestProperty("Content-Type", "application/json");
	        conexion.setDoOutput(true);

	        // Crear cuerpo de la solicitud con Jackson
	        ObjectMapper mapper = new ObjectMapper();
	        String jsonInput = mapper.writeValueAsString(loginRequest);
	        
	        System.out.print(jsonInput);
	        
	        try (OutputStream os = conexion.getOutputStream()) {
	            os.write(jsonInput.getBytes());
	            os.flush();
	        }

	        int codigoRespuesta = conexion.getResponseCode();
	        if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
	        	System.out.print("credenciales validas");
	            BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
	            String inputLine;
	            StringBuilder response = new StringBuilder();
	            while ((inputLine = in.readLine()) != null) {
	                response.append(inputLine);
	            }
	            in.close();
	            return response.toString();
	        } else {
	            System.out.println("Error en la conexión: " + codigoRespuesta);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

}
