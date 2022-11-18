package com.consumer.pokemon.db.dao.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.consumer.pokemon.db.dao.LogPokemonDao;
import com.consumer.pokemon.db.dto.RegisterOperation;
import com.consumer.pokemon.db.entities.LogPokemon;
import com.consumer.pokemon.db.repository.LogPokemonRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@Transactional

public class LogPokemonDaoImp implements LogPokemonDao {
 
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Autowired
    private LogPokemonRepository repository;
	
	@Override
	public List<LogPokemon> getLogPokemon() {	
 		List<LogPokemon> lpokemon = repository.findAll();
		return lpokemon;
	}

	@Override
	public void saveLogPokemon(RegisterOperation regOperation) {
		LocalDateTime datetime = LocalDateTime.now();
		 
        System.out.println(datetime);
        
		String qry = "INSERT INTO logpokemon (ip, date, request) values (?, ?, ?)";
		int result = jdbcTemplate.update(qry
				, regOperation.getIp()
				, datetime
				, regOperation.getReq());
		if(result > 0) {
			log.info("Register sussefult.");
		} else {
			log.error("Error Register!!");
		}
		
	}
	
	
	

}
