package com.kakaobank.study.search.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class NaverBlogSearchResponse {
	private int total;
	private int start;
	private int display;
	private List<NaverBlogSearchItem> items;
}
