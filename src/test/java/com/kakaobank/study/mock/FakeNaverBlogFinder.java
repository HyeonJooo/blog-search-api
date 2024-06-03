package com.kakaobank.study.mock;

import java.util.List;

import com.kakaobank.study.search.finder.BlogFinder;
import com.kakaobank.study.search.model.BlogSearchCondition;
import com.kakaobank.study.search.model.BlogSearchResponse;
import com.kakaobank.study.search.model.NaverBlogSearchItem;
import com.kakaobank.study.search.model.NaverBlogSearchResponse;
import com.kakaobank.study.search.type.ServiceType;

public class FakeNaverBlogFinder implements BlogFinder {
	@Override
	public boolean support(ServiceType serviceType) {
		return serviceType == ServiceType.NAVER;
	}

	@Override
	public BlogSearchResponse findBlogs(BlogSearchCondition blogSearchCondition) {
		NaverBlogSearchItem item1 = NaverBlogSearchItem.builder()
			.title("naver title1")
			.bloggerlink("www.naver.com/1")
			.bloggername("naverbloger1")
			.description("naver blog 1")
			.build();
		NaverBlogSearchItem item2 = NaverBlogSearchItem.builder()
			.title("naver title2")
			.bloggerlink("www.naver.com/2")
			.bloggername("naverbloger2")
			.description("naver blog 2")
			.build();

		NaverBlogSearchResponse response = NaverBlogSearchResponse.builder()
			.total(2)
			.start(1)
			.display(1)
			.items(List.of(item1, item2))
			.build();

		return BlogSearchResponse.from(response);
	}
}
