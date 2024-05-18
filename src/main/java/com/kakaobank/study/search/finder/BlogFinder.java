package com.kakaobank.study.search.finder;

import com.kakaobank.study.search.model.BlogSearchCondition;
import com.kakaobank.study.search.model.BlogSearchResponse;
import com.kakaobank.study.search.type.ServiceType;

public interface BlogFinder {
	boolean support(ServiceType serviceType);

	BlogSearchResponse findBlogs(BlogSearchCondition blogSearchCondition);
}
