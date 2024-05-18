package com.kakaobank.study.search.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.kakaobank.study.search.model.BlogSearchCondition;
import com.kakaobank.study.search.model.KakaoBlogSearchResponse;

@FeignClient(value = "kakaoBlogClient", url = "${kakao.api.blog-search.url}")
public interface KakaoBlogClient {
	@GetMapping("/v2/search/blog")
	KakaoBlogSearchResponse getKakaoBlogs(@RequestHeader("Authorization") String authorization, @SpringQueryMap BlogSearchCondition blogSearchCondition);
}
