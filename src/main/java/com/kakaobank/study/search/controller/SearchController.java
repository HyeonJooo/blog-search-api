package com.kakaobank.study.search.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kakaobank.study.search.entity.SearchKeywordEntity;
import com.kakaobank.study.search.model.BlogSearchCondition;
import com.kakaobank.study.search.model.BlogSearchResponse;
import com.kakaobank.study.search.service.BlogSearchService;
import com.kakaobank.study.search.service.PopularSearchService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/blogs")
@RequiredArgsConstructor
public class SearchController {

	private final BlogSearchService blogSearchService;
	private final PopularSearchService popularSearchService;

	@GetMapping("/search")
	public ResponseEntity<BlogSearchResponse> getBlogs(BlogSearchCondition blogSearchCondition) {
		popularSearchService.incrementSearchCount(blogSearchCondition.getQuery());
		return ResponseEntity.ok(blogSearchService.getBlogs(blogSearchCondition));
	}

	@GetMapping("/popular-searches")
	public ResponseEntity<List<SearchKeywordEntity>> getPopularSearches() {
		return ResponseEntity.ok(popularSearchService.getPopularSearches());
	}
}
