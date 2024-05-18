package com.kakaobank.study.search.model;

import com.kakaobank.study.search.type.ServiceType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogSearchCondition {
	private String query;
	private String sort; //ENUM?
	private int page;
	private int size;
	private ServiceType serviceType;
}
