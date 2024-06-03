package com.kakaobank.study.search.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NaverBlogSearchItem {
	private String title;
	private String link;
	private String description;
	private String bloggername;
	private String bloggerlink;
	private String postdate;
}
