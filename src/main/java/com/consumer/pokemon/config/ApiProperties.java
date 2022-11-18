package com.consumer.pokemon.config;

import org.springframework.beans.factory.annotation.Value;  
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter  
public class ApiProperties {
	
	/**
	 * name uri.
	 */
	@Value("${pokemon.config.name}")
	private String urlName;
	
	/**
	 * name resource.
	 */
	@Value("${pokemon.config.url-retive}")
	private String resource;
	
	/**
	 * name resource.
	 */
	@Value("${extrac.field.name.abilities}")
	private String abilities;
	
	/**
	 * name resource.
	 */
	@Value("${extrac.field.name.base-experience}")
	private String baseExperience;
	
	/**
	 * name resource.
	 */
	@Value("${extrac.field.name.held_items}")
	private String heldItems;
	
	/**
	 * name resource.
	 */
	@Value("${extrac.field.name.id}")
	private String id;
	
	/**
	 * name resource.
	 */
	@Value("${extrac.field.name.name}")
	private String name;
	
	/**
	 * name resource.
	 */
	@Value("${extrac.field.name.location_area_encounters}")
	private String locationAreaEncounters;


	/**
	 * name resource.
	 */
	@Value("${header.config.agent.name}")
	private String agentName;
	
	/**
	 * name resource.
	 */
	@Value("${header.config.agent.value}")
	private String agentValue;
}


