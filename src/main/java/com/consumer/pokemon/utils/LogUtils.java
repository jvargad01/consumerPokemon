package com.consumer.pokemon.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogUtils {

	private static final ObjectMapper mapper = new ObjectMapper();
	
	public static <T> String getJsonFormat (T object, boolean beautified) {
		String result = null;
		try {
			if(beautified) {
				result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);	
			} else {
				result = mapper.writeValueAsString(object);
			}
		} catch (JsonProcessingException ex) {
			log.error("Error format Json {}", ex.getMessage());
		}
		return result;
	}
	
	
	public static JsonNode converStringToJson(String jsonStr) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = null;
		try {
			node = mapper.readTree(jsonStr);
		} catch (JsonMappingException ex) {
			log.error("Error format JsonMappingException {}", ex.getMessage());
		} catch (JsonProcessingException ex) {
			log.error("Error format JsonProcessingException {}", ex.getMessage());
		}
		return node;
	}
	
}
