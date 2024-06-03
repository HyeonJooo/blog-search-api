package com.kakaobank.study.search.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kakaobank.study.search.finder.BlogFinder;
import com.kakaobank.study.search.model.BlogSearchCondition;
import com.kakaobank.study.search.model.BlogSearchResponse;
import com.kakaobank.study.search.type.ServiceType;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Service
@Builder
@RequiredArgsConstructor
public class BlogSearchService {

	private final List<BlogFinder> blogFinderList;

	public BlogSearchResponse getBlogs(BlogSearchCondition blogSearchCondition) {
		BlogFinder blogFinder = getBlogFinder(blogSearchCondition.getServiceType());
		return blogFinder.findBlogs(blogSearchCondition);
	}

	private BlogFinder getBlogFinder(ServiceType serviceType) {
		return blogFinderList.stream()
				.filter(blogFinder -> blogFinder.support(serviceType))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
