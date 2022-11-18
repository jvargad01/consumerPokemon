package com.consumer.pokemon.db.dao;

import java.util.List;

import com.consumer.pokemon.db.dto.RegisterOperation;
import com.consumer.pokemon.db.entities.LogPokemon;

public interface LogPokemonDao {
	
	List<LogPokemon> getLogPokemon();
	
	void saveLogPokemon(RegisterOperation regOperation);
	
}
