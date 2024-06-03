package com.kakaobank.study.search.service.port;

import java.util.List;
import java.util.Optional;

import com.kakaobank.study.search.model.SearchKeyword;

public interface SearchKeywordRepository {
	Optional<SearchKeyword> findByKeyword(String keyword);

	void save(SearchKeyword searchKeyword);

	List<SearchKeyword> findTop10ByOrderByCountDesc();
}
