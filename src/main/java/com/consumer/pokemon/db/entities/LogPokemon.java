package com.consumer.pokemon.db.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity 
@Setter
@Getter
@Table(name = "logpokemon")
public class LogPokemon implements Serializable {

	/**
	 * serial.
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * id table.
	 */
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/**
	 * ip consumer.
	 */ 
	private String ip;
	

	/**
	 * date ejecution.
	 */ 
	private Date date;
	
	/**
	 * requet ejecution.
	 */ 
	private String request;
}
