package com.kakaobank.study.search.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class KakaoBlogSearchDocument {
	private String title;
	private String contents;
	private String url;
	private String blogname;
	private String thumbnail;
	private String datetime;
}
