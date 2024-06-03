package com.kakaobank.study.search.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.kakaobank.study.search.entity.SearchKeywordEntity;

import jakarta.persistence.LockModeType;

@Repository
public interface SearchKeywordJpaRepository extends JpaRepository<SearchKeywordEntity, Long> {
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<SearchKeywordEntity> findByKeyword(String keyword);

	Optional<List<SearchKeywordEntity>> findTop10ByOrderByCountDesc();
}
