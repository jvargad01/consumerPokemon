package com.consumer.pokemon.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.consumer.pokemon.db.dto.ListOperations;
import com.consumer.pokemon.db.dto.RegisterOperation;
import com.consumer.pokemon.model.RequestPokemon;
import com.consumer.pokemon.service.Services;
import com.consumer.pokemon.utils.LogUtils;
import com.consumer.pokemon.utils.Utils;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/domain/services/pokemon")
public class Controller {
	
	@Autowired
	private Services clientPokemon;
  
	
	@RequestMapping(value = "/retrive", method=RequestMethod.POST)
	public ResponseEntity<?> retrivePokemon(HttpServletRequest req, 
			@RequestHeader HttpHeaders header,
			@RequestBody RequestPokemon retriveRequest) {
		RegisterOperation rOper = RegisterOperation.builder()
				.ip(req.getRequestURI())
				.req(LogUtils.getJsonFormat(retriveRequest, false))
				.build();
		
		log.info("inicio {}, {}", rOper.getIp() ,LogUtils.getJsonFormat(retriveRequest, false));
		JsonNode json = clientPokemon.getPokemon(Utils.validData(retriveRequest), rOper); 
		log.info("Mesagge {}", LogUtils.getJsonFormat(json, false)); 
		return new ResponseEntity<>(json, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/retive/abilities", method=RequestMethod.POST)
	public ResponseEntity<?> retrivePokemonAbilities(HttpServletRequest req, 
			@RequestHeader HttpHeaders header,
			@RequestBody RequestPokemon retriveRequest) {
		
		RegisterOperation rOper = RegisterOperation.builder()
				.ip(req.getRequestURI())
				.req(LogUtils.getJsonFormat(retriveRequest, false))
				.build();
		
		log.info("inicio {}, {}", rOper.getIp(), LogUtils.getJsonFormat(retriveRequest, false));
		JsonNode json = clientPokemon.getPokemonAbilities(Utils.validData(retriveRequest), rOper); 
		log.info("Mesagge {}", LogUtils.getJsonFormat(json, false)); 
		return new ResponseEntity<>(json, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/retive/experiences", method=RequestMethod.POST)
	public ResponseEntity<?> retrivePokemonBaseExperience(HttpServletRequest req, 
			@RequestHeader HttpHeaders header,
			@RequestBody RequestPokemon retriveRequest) {

		RegisterOperation rOper = RegisterOperation.builder()
				.ip(req.getRequestURI())
				.req(LogUtils.getJsonFormat(retriveRequest, false))
				.build();
		
		log.info("inicio {}, {}", rOper.getIp(), LogUtils.getJsonFormat(retriveRequest, false));
		JsonNode json = clientPokemon.getPokemonBaseExperience(Utils.validData(retriveRequest), rOper); 
		log.info("Mesagge {}", LogUtils.getJsonFormat(json, false)); 
		return new ResponseEntity<>(json, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/retive/helpitems", method=RequestMethod.POST)
	public ResponseEntity<?> retrivePokemonHeldItems(HttpServletRequest req, 
			@RequestHeader HttpHeaders header,
			@RequestBody RequestPokemon retriveRequest) {
		
		RegisterOperation rOper = RegisterOperation.builder()
				.ip(req.getRequestURI())
				.req(LogUtils.getJsonFormat(retriveRequest, false))
				.build();
		
		log.info("inicio {}, {}", rOper.getIp(), LogUtils.getJsonFormat(retriveRequest, false));
		JsonNode json = clientPokemon.getPokemonHeldItems(Utils.validData(retriveRequest), rOper); 
		log.info("Mesagge {}", LogUtils.getJsonFormat(json, false)); 
		return new ResponseEntity<>(json, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/retive/id", method=RequestMethod.POST)
	public ResponseEntity<?> retrivePokemonId(HttpServletRequest req, 
			@RequestHeader HttpHeaders header,
			@RequestBody RequestPokemon retriveRequest) {

		RegisterOperation rOper = RegisterOperation.builder()
				.ip(req.getRequestURI())
				.req(LogUtils.getJsonFormat(retriveRequest, false))
				.build();
		
		log.info("inicio {}, {}", rOper.getIp(), LogUtils.getJsonFormat(retriveRequest, false));
		JsonNode json = clientPokemon.getPokemonId(Utils.validData(retriveRequest), rOper); 
		log.info("Mesagge {}", LogUtils.getJsonFormat(json, false)); 
		return new ResponseEntity<>(json, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/retive/name", method=RequestMethod.POST)
	public ResponseEntity<?> retrivePokemonName(HttpServletRequest req,
			@RequestHeader HttpHeaders header,
			@RequestBody RequestPokemon retriveRequest) {
		
		RegisterOperation rOper = RegisterOperation.builder()
				.ip(req.getRequestURI())
				.req(LogUtils.getJsonFormat(retriveRequest, false))
				.build();
		
		log.info("inicio {}, {}", rOper.getIp(), LogUtils.getJsonFormat(retriveRequest, false));
		JsonNode json = clientPokemon.getPokemonName(Utils.validData(retriveRequest), rOper); 
		log.info("Mesagge {}", LogUtils.getJsonFormat(json, false)); 
		return new ResponseEntity<>(json, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/retive/location", method=RequestMethod.POST)
	public ResponseEntity<?> retrivePokemonLocation(HttpServletRequest req, 
			@RequestHeader HttpHeaders header,
			@RequestBody RequestPokemon retriveRequest) {
		RegisterOperation rOper = RegisterOperation.builder()
				.ip(req.getRequestURI())
				.req(LogUtils.getJsonFormat(retriveRequest, false))
				.build();
		
		log.info("inicio {}, {}", rOper.getIp(), LogUtils.getJsonFormat(retriveRequest, false));
		JsonNode json = clientPokemon.getPokemonLocationArea(Utils.validData(retriveRequest), rOper); 
		log.info("Mesagge {}", LogUtils.getJsonFormat(json, false)); 
		return new ResponseEntity<>(json, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/retive/bd", method=RequestMethod.GET)
	public ResponseEntity<?> retrivePokemonbd(HttpServletRequest req, 
			@RequestHeader HttpHeaders header) {
		 
		RegisterOperation rOper = RegisterOperation.builder().ip(req.getRequestURI()).build();
		
		log.info("inicio {}", rOper.getIp());
		ListOperations json = clientPokemon.getListBDPokemon();
				
		return new ResponseEntity<>(json, HttpStatus.OK);
	}
	
}
