package com.kakaobank.study.search.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SearchKeyword {
	private Long id;
	private String keyword;
	private int count;

	public static SearchKeyword create(String keyword) {
		return SearchKeyword.builder()
				.keyword(keyword)
				.count(1)
				.build();
	}

	public SearchKeyword increaseCount() {
		return SearchKeyword.builder()
				.id(id)
				.keyword(keyword)
				.count(this.count + 1)
				.build();
	}
}
