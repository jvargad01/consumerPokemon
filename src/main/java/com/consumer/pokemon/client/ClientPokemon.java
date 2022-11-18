package com.consumer.pokemon.client;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;

public interface ClientPokemon {
	
	JSONObject getDataPokemon(String data);

	JsonNode getPokemon(String data);

	JsonNode getPokemonAbilities(String data);
	
	JsonNode getPokemonBaseExperience(String data);
	
	JsonNode getPokemonHeldItems(String data);
	
	JsonNode getPokemonId(String data);

	JsonNode getPokemonName(String data);
	

	JsonNode getPokemonLocationArea(String data);
	
}
