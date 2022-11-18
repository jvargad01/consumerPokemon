package com.consumer.pokemon.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consumer.pokemon.db.entities.LogPokemon;

public interface LogPokemonRepository extends JpaRepository<LogPokemon, Long> {

}
