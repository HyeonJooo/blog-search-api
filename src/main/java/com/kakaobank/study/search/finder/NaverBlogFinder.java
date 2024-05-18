package com.kakaobank.study.search.finder;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kakaobank.study.search.client.NaverBlogClient;
import com.kakaobank.study.search.model.BlogSearchCondition;
import com.kakaobank.study.search.model.BlogSearchResponse;
import com.kakaobank.study.search.model.KakaoBlogSearchResponse;
import com.kakaobank.study.search.model.NaverBlogSearchCondition;
import com.kakaobank.study.search.model.NaverBlogSearchItem;
import com.kakaobank.study.search.model.NaverBlogSearchResponse;
import com.kakaobank.study.search.type.ServiceType;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class NaverBlogFinder implements BlogFinder {

	private final NaverBlogClient naverBlogClient;

	@Value("${naver.api.client-id}")
	private String clientId;

	@Value("${naver.api.client-secret}")
	private String clientSecret;


	@Override
	public boolean support(ServiceType serviceType) {
		return serviceType == ServiceType.NAVER;
	}

	@Override
	public BlogSearchResponse findBlogs(BlogSearchCondition blogSearchCondition) {
		NaverBlogSearchCondition searchCondition = NaverBlogSearchCondition.builder()
				.query(blogSearchCondition.getQuery())
				.sort(blogSearchCondition.getSort())
				.display(blogSearchCondition.getSize())
				.start(blogSearchCondition.getPage())
				.build();

		NaverBlogSearchResponse response = naverBlogClient.getNaverBlogs(clientId, clientSecret, searchCondition);
		return BlogSearchResponse.from(response);
	}
}
