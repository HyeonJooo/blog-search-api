package com.kakaobank.study.search.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kakaobank.study.search.model.BlogSearchCondition;
import com.kakaobank.study.search.model.BlogSearchResponse;
import com.kakaobank.study.search.service.SearchService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/blogs")
@RequiredArgsConstructor
public class SearchController {

	private final SearchService searchService;

	@GetMapping("/search")
	public ResponseEntity<BlogSearchResponse> getBlogs(BlogSearchCondition blogSearchCondition) {
		return ResponseEntity.ok(searchService.getBlogs(blogSearchCondition));
	}
}
