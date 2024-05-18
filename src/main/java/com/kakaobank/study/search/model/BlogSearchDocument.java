package com.kakaobank.study.search.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BlogSearchDocument {
	private String title;
	private String contents;
	private String url;
	private String blogName;
	private String bloggerName;
	private String bloggerLink;
	private String thumbnail;
	private String dateTime;

}
