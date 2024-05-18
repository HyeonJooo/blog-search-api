package com.kakaobank.study.search.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BlogSearchResponse {
	private int totalCount;
	private int pageableCount;
	private boolean isEnd;
	private List<BlogSearchDocument> documents;

	public static BlogSearchResponse from(KakaoBlogSearchResponse response) {
		return BlogSearchResponse.builder()
				.totalCount(response.getMeta().getTotal_count())
				.pageableCount(response.getMeta().getPageable_count())
				.isEnd(response.getMeta().is_end())
				.documents(
						response.getDocuments().stream()
								.map(doc -> BlogSearchDocument.builder()
										.title(doc.getTitle())
										.contents(doc.getContents())
										.url(doc.getUrl())
										.blogName(doc.getBlogname())
										.thumbnail(doc.getThumbnail())
										.dateTime(doc.getDatetime())
										.build()
								).toList()
				)
				.build();
	}

	public static BlogSearchResponse from(NaverBlogSearchResponse response) {
		return BlogSearchResponse.builder()
				.totalCount(response.getTotal())
				.pageableCount(response.getDisplay())
				.isEnd(response.getStart() + response.getDisplay() >= response.getTotal())
				.documents(
						response.getItems().stream()
								.map(item -> BlogSearchDocument.builder()
										.title(item.getTitle())
										.contents(item.getDescription())
										.url(item.getLink())
										.bloggerName(item.getBloggername())
										.bloggerLink(item.getBloggerlink())
										.thumbnail(null) // 네이버 API에 해당 필드 없음
										.dateTime(item.getPostdate())
										.build()
								).toList()
				)
				.build();

	}
}
