package com.kakaobank.study.search.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KakaoBlogSearchMeta {
	private int total_count;
	private int pageable_count;
	private boolean is_end;
}
