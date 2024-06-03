package com.kakaobank.study.search.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kakaobank.study.search.model.SearchKeyword;
import com.kakaobank.study.search.service.port.SearchKeywordRepository;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Service
@Builder
@RequiredArgsConstructor
public class PopularSearchService {

	private final SearchKeywordRepository searchKeywordRepository;

	@Transactional
	public void incrementSearchCount(String keyword) {
		SearchKeyword searchKeyword = searchKeywordRepository.findByKeyword(keyword).orElse(null);

		if (searchKeyword == null) {
			searchKeyword = SearchKeyword.create(keyword);
		} else {
			searchKeyword = searchKeyword.increaseCount();
		}

		searchKeywordRepository.save(searchKeyword);
	}

	public List<SearchKeyword> getPopularSearches() {
		return searchKeywordRepository.findTop10ByOrderByCountDesc();
	}
}
