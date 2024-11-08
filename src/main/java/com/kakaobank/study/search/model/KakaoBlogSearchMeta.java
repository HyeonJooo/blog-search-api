package com.kakaobank.study.search.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class KakaoBlogSearchMeta {
	private int total_count;
	private int pageable_count;
	private boolean is_end;
}
