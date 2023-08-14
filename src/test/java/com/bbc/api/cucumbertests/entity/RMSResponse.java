package com.bbc.api.cucumbertests.entity;

import java.util.List;
import lombok.Data;

@Data
public class RMSResponse{
	private List<DataItem> data;
}