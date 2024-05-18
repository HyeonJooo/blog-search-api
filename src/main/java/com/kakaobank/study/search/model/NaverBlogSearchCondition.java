package com.kakaobank.study.search.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NaverBlogSearchCondition {
	private String query;
	private String sort;
	private int display;
	private int start;
}
