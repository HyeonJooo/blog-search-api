package com.kakaobank.study.search.repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.kakaobank.study.search.entity.SearchKeywordEntity;
import com.kakaobank.study.search.model.SearchKeyword;
import com.kakaobank.study.search.service.port.SearchKeywordRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SearchKeywordRepositoryImpl implements SearchKeywordRepository {

	private final SearchKeywordJpaRepository searchKeywordJpaRepository;

	@Override
	public Optional<SearchKeyword> findByKeyword(String keyword) {
		return searchKeywordJpaRepository.findByKeyword(keyword).map(SearchKeywordEntity::to);
	}

	@Override
	public void save(SearchKeyword searchKeyword) {
		searchKeywordJpaRepository.save(SearchKeywordEntity.from(searchKeyword));
	}

	@Override
	public List<SearchKeyword> findTop10ByOrderByCountDesc() {
		return searchKeywordJpaRepository.findTop10ByOrderByCountDesc()
				.orElse(Collections.emptyList())
				.stream()
				.map(SearchKeywordEntity::to)
				.toList();
	}
}
