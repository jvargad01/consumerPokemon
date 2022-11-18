package com.consumer.pokemon.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.consumer.pokemon.config.ApiProperties;
import com.consumer.pokemon.utils.LogUtils;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.extern.slf4j.Slf4j; 
 
@Slf4j
@Service
public class ClientPokemonImpl implements ClientPokemon {

	@Autowired
	private ApiProperties apiProperties;
	   
	
	@Override
	public JSONObject getDataPokemon(String data) {
		JSONObject myResponseSlot = null;
		try {
			String endpoint = apiProperties.getUrlName() + "" + apiProperties.getResource() + "" + data;
			log.info(endpoint);
			
			URL url = new URL(endpoint);
            HttpURLConnection conn;  
              conn = (HttpURLConnection) url.openConnection();
              conn.setRequestMethod("GET");
              conn.setRequestProperty("ContentType", "text/plain");
		      //conn.setRequestProperty("Content-Type", "application/json");

              log.error("code : {}", conn.getContentType());
              if (conn.getResponseCode() != 200) {
            	  log.error("Failed : HTTP error code : {}", conn.getResponseCode());
              } else {
                  
                  BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                  StringBuffer output = new StringBuffer();
                  String inputLine; 
                       
                  while ((inputLine = br.readLine()) != null) {
                	  output.append(inputLine); 
                  }
                       
                  myResponseSlot = new JSONObject(output.toString());
                      
              }  
              conn.disconnect();               
		} catch (MalformedURLException ex) {
          log.error("Error in consumer Api pokemon {}", ex.getMessage());
        } catch (IOException e) { 
			e.printStackTrace();
		}
		
		return myResponseSlot;
	}

	@Override
	public JsonNode getPokemon(String data) {
	
		String endpoint = apiProperties.getUrlName() + "" + apiProperties.getResource() + "" + data;
		log.info(endpoint);
		 
		ResponseEntity<String> rest = getConsumer(endpoint);
		
		JsonNode node = LogUtils.converStringToJson(rest.getBody().toString());

		return node;
	}

	@Override
	public JsonNode getPokemonAbilities(String data) {

		String endpoint = apiProperties.getUrlName() + "" + apiProperties.getResource() + "" + data;
		log.info(endpoint);
		 
		ResponseEntity<String> rest = getConsumer(endpoint);
		
		JsonNode node = LogUtils.converStringToJson(rest.getBody().toString());
		
		return node.get(apiProperties.getAbilities());
	}

	@Override
	public JsonNode getPokemonBaseExperience(String data) {

		String endpoint = apiProperties.getUrlName() + "" + apiProperties.getResource() + "" + data;
		log.info(endpoint);
		 
		ResponseEntity<String> rest = getConsumer(endpoint);
		
		JsonNode node = LogUtils.converStringToJson(rest.getBody().toString());
		
		return node.get(apiProperties.getBaseExperience());
	}

	@Override
	public JsonNode getPokemonHeldItems(String data) {

		String endpoint = apiProperties.getUrlName() + "" + apiProperties.getResource() + "" + data;
		log.info(endpoint);
		 
		ResponseEntity<String> rest = getConsumer(endpoint);
		
		JsonNode node = LogUtils.converStringToJson(rest.getBody().toString());

		return node.get(apiProperties.getHeldItems());
	}

	@Override
	public JsonNode getPokemonId(String data) {

		String endpoint = apiProperties.getUrlName() + "" + apiProperties.getResource() + "" + data;
		log.info(endpoint);
		 
		ResponseEntity<String> rest = getConsumer(endpoint);
		
		JsonNode node = LogUtils.converStringToJson(rest.getBody().toString());
		
		return node.get(apiProperties.getId());
	}

	@Override
	public JsonNode getPokemonName(String data) {

		String endpoint = apiProperties.getUrlName() + "" + apiProperties.getResource() + "" + data;
		log.info(endpoint);
		 
		ResponseEntity<String> rest = getConsumer(endpoint);
		
		JsonNode node = LogUtils.converStringToJson(rest.getBody().toString());
		
		return node.get(apiProperties.getName());
	}

	@Override
	public JsonNode getPokemonLocationArea(String data) {

		String endpoint = apiProperties.getUrlName() + "" + apiProperties.getResource() + "" + data;
		log.info(endpoint);
		 
		ResponseEntity<String> rest = getConsumer(endpoint);
		
		JsonNode node = LogUtils.converStringToJson(rest.getBody().toString());
		
		return node.get(apiProperties.getLocationAreaEncounters());
	}


	private ResponseEntity<String> getConsumer(String endpoint){
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add(apiProperties.getAgentName(), apiProperties.getAgentValue());
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> rest = restTemplate.exchange(endpoint,
				HttpMethod.GET, entity, String.class);
		
		return rest;
	}
	
}
