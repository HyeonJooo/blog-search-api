package com.kakaobank.study.search.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class KakaoBlogSearchResponse {
	private KakaoBlogSearchMeta meta;
	private List<KakaoBlogSearchDocument> documents;
}
