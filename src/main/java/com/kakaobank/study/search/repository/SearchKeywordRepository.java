package com.kakaobank.study.search.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.kakaobank.study.search.entity.SearchKeywordEntity;

import jakarta.persistence.LockModeType;

@Repository
public interface SearchKeywordRepository extends JpaRepository<SearchKeywordEntity, Long> {
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	SearchKeywordEntity findByKeyword(String keyword);

	List<SearchKeywordEntity> findTop10ByOrderByCountDesc();
}
