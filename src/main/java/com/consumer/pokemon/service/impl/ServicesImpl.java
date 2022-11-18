package com.consumer.pokemon.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumer.pokemon.client.ClientPokemon;
import com.consumer.pokemon.db.dao.LogPokemonDao;
import com.consumer.pokemon.db.dto.ListOperations;
import com.consumer.pokemon.db.dto.RegisterOperation;
import com.consumer.pokemon.db.entities.LogPokemon;
import com.consumer.pokemon.service.Services;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class ServicesImpl implements Services {


	@Autowired
	private ClientPokemon clientPokemon;
	
	@Autowired
	private LogPokemonDao clientDao;
	 
	@Override
	public JsonNode getPokemon(String data, RegisterOperation rOper) {
		 JsonNode json = clientPokemon.getPokemon(data);
		 clientDao.saveLogPokemon(rOper);
		 return json;
	}

	@Override
	public JsonNode getPokemonAbilities(String data, RegisterOperation rOper) {
		JsonNode json = clientPokemon.getPokemonAbilities(data);
		clientDao.saveLogPokemon(rOper);
		return json;
	}

	@Override
	public JsonNode getPokemonBaseExperience(String data, RegisterOperation rOper) {
		JsonNode json = clientPokemon.getPokemonBaseExperience(data);
		clientDao.saveLogPokemon(rOper);
		return json;
	}

	@Override
	public JsonNode getPokemonHeldItems(String data, RegisterOperation rOper) {
		JsonNode json = clientPokemon.getPokemonHeldItems(data);
		clientDao.saveLogPokemon(rOper);
		return json;
	}

	@Override
	public JsonNode getPokemonId(String data, RegisterOperation rOper) {
		JsonNode json = clientPokemon.getPokemonId(data);
		clientDao.saveLogPokemon(rOper);
		return json;
	}

	@Override
	public JsonNode getPokemonName(String data, RegisterOperation rOper) {
		JsonNode json = clientPokemon.getPokemonName(data);
		clientDao.saveLogPokemon(rOper);
		return json;
	}
 
	@Override
	public JsonNode getPokemonLocationArea(String data, RegisterOperation rOper) {
		JsonNode json = clientPokemon.getPokemonLocationArea(data);
		clientDao.saveLogPokemon(rOper);
		return json;
	}
 

	@Override
	public ListOperations getListBDPokemon() {
		List<RegisterOperation> listOpers = new ArrayList<>();
		ListOperations oper = new ListOperations();
		List<LogPokemon> listPokemon = clientDao.getLogPokemon();
	 
		listOpers.addAll(listPokemon.stream().map(this:: convertRegisterOperation).collect(Collectors.toList()));
		
		oper.setListOperations(listOpers); 
		
		return oper;
	}
	
	
	private RegisterOperation convertRegisterOperation(LogPokemon logPokemon) {
		return RegisterOperation.builder()
				.ip(logPokemon.getIp())
				.date(logPokemon.getDate())
				.req(logPokemon.getRequest())
				.build();  
	}
}
