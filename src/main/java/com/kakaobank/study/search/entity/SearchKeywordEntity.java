package com.kakaobank.study.search.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kakaobank.study.search.model.SearchKeyword;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "search_keyword")
public class SearchKeywordEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;

	@Column(name = "keyword")
	private String keyword;

	@Column(name = "count")
	private int count;

	public static SearchKeywordEntity from(SearchKeyword searchKeyword) {
		SearchKeywordEntity searchKeywordEntity = new SearchKeywordEntity();
		searchKeywordEntity.setId(searchKeyword.getId());
		searchKeywordEntity.setKeyword(searchKeyword.getKeyword());
		searchKeywordEntity.setCount(searchKeyword.getCount());

		return searchKeywordEntity;
	}

	public SearchKeyword to() {
		return SearchKeyword.builder()
				.id(id)
				.keyword(keyword)
				.count(count)
				.build();
	}
}
