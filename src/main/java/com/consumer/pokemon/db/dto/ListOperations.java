package com.consumer.pokemon.db.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@JsonPropertyOrder({"listOperations"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(include = As.WRAPPER_OBJECT, property = "ListOperations", use = Id.NAME)
public class ListOperations {

	@JsonProperty("listOperations")	
	List<RegisterOperation> listOperations;
}
