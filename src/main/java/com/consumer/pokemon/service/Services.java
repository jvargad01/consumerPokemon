package com.consumer.pokemon.service;

import com.consumer.pokemon.db.dto.ListOperations;
import com.consumer.pokemon.db.dto.RegisterOperation;
import com.fasterxml.jackson.databind.JsonNode;

public interface Services {
 

	JsonNode getPokemon(String data, RegisterOperation rOper);

	JsonNode getPokemonAbilities(String data, RegisterOperation rOper);
	
	JsonNode getPokemonBaseExperience(String data, RegisterOperation rOper);
	
	JsonNode getPokemonHeldItems(String data, RegisterOperation rOper);
	
	JsonNode getPokemonId(String data, RegisterOperation rOper);

	JsonNode getPokemonName(String data, RegisterOperation rOper);
	
	JsonNode getPokemonLocationArea(String data, RegisterOperation rOper);
	
	ListOperations getListBDPokemon();
}
