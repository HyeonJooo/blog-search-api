package com.kakaobank.study.search.finder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kakaobank.study.search.client.KakaoBlogClient;
import com.kakaobank.study.search.model.BlogSearchCondition;
import com.kakaobank.study.search.model.BlogSearchResponse;
import com.kakaobank.study.search.model.KakaoBlogSearchResponse;
import com.kakaobank.study.search.type.ServiceType;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class KakaoBlogFinder implements BlogFinder {

	private final KakaoBlogClient kakaoBlogClient;

	private static final int MAX_PAGE_COUNT = 50;

	@Value("${kakao.api.authorization}")
	private String authorization;

	@Override
	public boolean support(ServiceType serviceType) {
		return serviceType == ServiceType.KAKAO;
	}

	@Override
	public BlogSearchResponse findBlogs(BlogSearchCondition blogSearchCondition) {
		if (blogSearchCondition.getPage() > MAX_PAGE_COUNT) {
			throw new IllegalArgumentException("page count is invalid. page: " + blogSearchCondition.getPage());
		}

		KakaoBlogSearchResponse response = kakaoBlogClient.getKakaoBlogs(authorization, blogSearchCondition);
		return BlogSearchResponse.from(response);
	}

}
