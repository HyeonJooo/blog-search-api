package com.kakaobank.study.search.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.kakaobank.study.search.model.NaverBlogSearchCondition;
import com.kakaobank.study.search.model.NaverBlogSearchResponse;

@FeignClient(value = "naverBlogClient", url = "${naver.api.blog-search.url}")
public interface NaverBlogClient {
	@GetMapping("/v1/search/blog.json")
	NaverBlogSearchResponse getNaverBlogs(@RequestHeader("X-Naver-Client-Id") String clientId, @RequestHeader("X-Naver-Client-Secret") String clientSecret,
			@SpringQueryMap NaverBlogSearchCondition searchCondition);
}
