package com.kakaobank.study.search.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kakaobank.study.search.entity.SearchKeywordEntity;
import com.kakaobank.study.search.repository.SearchKeywordRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PopularSearchService {

	private final SearchKeywordRepository searchKeywordRepository;

	public void incrementSearchCount(String keyword) {
		SearchKeywordEntity searchKeyword = searchKeywordRepository.findByKeyword(keyword);

		if (searchKeyword == null) {
			searchKeyword = new SearchKeywordEntity();
			searchKeyword.setKeyword(keyword);
			searchKeyword.setCount(1);
		} else {
			searchKeyword.increaseCount();
		}

		searchKeywordRepository.save(searchKeyword);
	}

	public List<SearchKeywordEntity> getPopularSearches() {
		return searchKeywordRepository.findTop10ByOrderByCountDesc();
	}
}
