package com.bbc.api.cucumbertests.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Offset{
	@JsonProperty(value="now_playing")
	private boolean nowPlaying;

	private int start;
	private int end;
	private Object label;
}