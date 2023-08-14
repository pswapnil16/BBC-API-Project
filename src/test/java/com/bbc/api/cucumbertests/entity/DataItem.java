package com.bbc.api.cucumbertests.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DataItem{
	private List<UrisItem> uris;
	private Offset offset;

	@JsonProperty(value="image_url")
	private Object imageUrl;
	private Object synopses;

	@JsonProperty(value="segment_type")
	private String segmentType;

	private String id;
	private String type;

	@JsonProperty(value="title_list")
	private TitleList titleList;
}