package com.kakaobank.study.mock;

import java.util.List;

import com.kakaobank.study.search.finder.BlogFinder;
import com.kakaobank.study.search.model.BlogSearchCondition;
import com.kakaobank.study.search.model.BlogSearchResponse;
import com.kakaobank.study.search.model.KakaoBlogSearchDocument;
import com.kakaobank.study.search.model.KakaoBlogSearchMeta;
import com.kakaobank.study.search.model.KakaoBlogSearchResponse;
import com.kakaobank.study.search.type.ServiceType;

public class FakeKakaoBlogFinder implements BlogFinder {
	@Override
	public boolean support(ServiceType serviceType) {
		return serviceType == ServiceType.KAKAO;
	}

	@Override
	public BlogSearchResponse findBlogs(BlogSearchCondition blogSearchCondition) {
		KakaoBlogSearchMeta meta = KakaoBlogSearchMeta.builder()
			.total_count(2)
			.is_end(false)
			.pageable_count(10)
			.build();
		KakaoBlogSearchDocument document1 = KakaoBlogSearchDocument.builder()
			.title("kakao title1")
			.contents("kakao blog 1")
			.url("www.kakao.com/1")
			.blogname("kakaoblog1")
			.build();
		KakaoBlogSearchDocument document2 = KakaoBlogSearchDocument.builder()
			.title("kakao title2")
			.contents("kakao blog 2")
			.url("www.kakao.com/2")
			.blogname("kakaoblog2")
			.build();
		KakaoBlogSearchResponse response = KakaoBlogSearchResponse.builder()
			.meta(meta)
			.documents(List.of(document1, document2))
			.build();

		return BlogSearchResponse.from(response);
	}
}
