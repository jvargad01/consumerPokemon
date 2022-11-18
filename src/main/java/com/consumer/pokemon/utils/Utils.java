package com.consumer.pokemon.utils;

import com.consumer.pokemon.model.RequestPokemon;

public class Utils {

	public static String validData(RequestPokemon req) {
		return req.getId().trim().isEmpty() ? req.getName() : req.getId();
	}
}
