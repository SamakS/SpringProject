package com.krungsri.kbs.services;

import org.springframework.data.domain.Page;

import com.krungsri.kbs.model.elasticsearch.KbsExcBooth;

public interface KbsExcBoothService {
	public Page<KbsExcBooth> listAll();
	
	public Page<KbsExcBooth> findByLocation(String location);
}
