package com.kakaobank.study.search.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KakaoBlogSearchResponse {
	private KakaoBlogSearchMeta meta;
	private List<KakaoBlogSearchDocument> documents;
}
