package com.kakaobank.study.search.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kakaobank.study.mock.FakeKakaoBlogFinder;
import com.kakaobank.study.mock.FakeNaverBlogFinder;
import com.kakaobank.study.search.finder.BlogFinder;
import com.kakaobank.study.search.model.BlogSearchCondition;
import com.kakaobank.study.search.model.BlogSearchResponse;
import com.kakaobank.study.search.type.ServiceType;

public class BlogSearchServiceTest {

	private BlogSearchService blogSearchService;

	@BeforeEach
	void init() {
		BlogFinder fakeNaverBlogFinder = new FakeNaverBlogFinder();
		BlogFinder fakeKakaoBlogFinder = new FakeKakaoBlogFinder();
		this.blogSearchService = BlogSearchService.builder()
			.blogFinderList(List.of(fakeNaverBlogFinder, fakeKakaoBlogFinder))
			.build();
	}

	@Test
	void blogSearchCondition으로_네이버_블로그_검색결과를_가져올_수_있다() {
		//given
		BlogSearchCondition blogSearchCondition = BlogSearchCondition.builder()
			.query("naver")
			.page(1)
			.size(1)
			.serviceType(ServiceType.NAVER)
			.build();

		//when
		BlogSearchResponse blogSearchResponse = blogSearchService.getBlogs(blogSearchCondition);

		//then
		assertThat(blogSearchResponse).isNotNull();
		assertThat(blogSearchResponse.getTotalCount()).isEqualTo(2);
		assertThat(blogSearchResponse.getDocuments().get(0).getTitle()).isEqualTo("naver title1");
		assertThat(blogSearchResponse.getDocuments().get(1).getTitle()).isEqualTo("naver title2");
	}

	@Test
	void blogSearchCondition으로_카카오_블로그_검색결과를_가져올_수_있다() {
		//given
		BlogSearchCondition blogSearchCondition = BlogSearchCondition.builder()
			.query("kakao")
			.page(1)
			.size(1)
			.serviceType(ServiceType.KAKAO)
			.build();

		//when
		BlogSearchResponse blogSearchResponse = blogSearchService.getBlogs(blogSearchCondition);

		//then
		assertThat(blogSearchResponse).isNotNull();
		assertThat(blogSearchResponse.getTotalCount()).isEqualTo(2);
		assertThat(blogSearchResponse.getDocuments().get(0).getTitle()).isEqualTo("kakao title1");
		assertThat(blogSearchResponse.getDocuments().get(1).getTitle()).isEqualTo("kakao title2");
	}
}
