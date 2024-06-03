package com.kakaobank.study.search.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kakaobank.study.mock.FakeSearchKeywordRepository;
import com.kakaobank.study.search.model.SearchKeyword;
import com.kakaobank.study.search.service.port.SearchKeywordRepository;

public class PopularSearchServiceTest {

	private PopularSearchService popularSearchService;
	private SearchKeywordRepository fakeSearchKeywordRepository;

	@BeforeEach
	void init() {
		fakeSearchKeywordRepository = new FakeSearchKeywordRepository();
		this.popularSearchService = PopularSearchService.builder()
			.searchKeywordRepository(fakeSearchKeywordRepository)
			.build();
		fakeSearchKeywordRepository.save(SearchKeyword.builder()
				.id(1L)
				.count(5)
				.keyword("naver")
			.build());
		fakeSearchKeywordRepository.save(SearchKeyword.builder()
			.id(2L)
			.count(4)
			.keyword("kakao")
			.build());
	}

	@Test
	void keyword로_searchCount를_증가시킬_수_있다() {
		//given
		String keyword = "naver";

		//when
		popularSearchService.incrementSearchCount(keyword);

		//then
		Optional<SearchKeyword> searchKeyword = fakeSearchKeywordRepository.findByKeyword(keyword);
		assertThat(searchKeyword.isPresent()).isTrue();
		assertThat(searchKeyword.get().getKeyword()).isEqualTo("naver");
		assertThat(searchKeyword.get().getCount()).isEqualTo(6);
	}

	@Test
	void count가_높은순으로_정렬된_searchKeyword_list를_불러올_수_있다() {
		//given
		//when
		List<SearchKeyword> searchKeywordList = popularSearchService.getPopularSearches();

		//then
		assertThat(searchKeywordList.isEmpty()).isFalse();
		assertThat(searchKeywordList.get(0).getKeyword()).isEqualTo("naver");
		assertThat(searchKeywordList.get(1).getKeyword()).isEqualTo("kakao");
	}

}
