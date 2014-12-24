package com.krungsri.kbs.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.krungsri.kbs.model.elasticsearch.Campaign;

public interface LMCampaignService {
	
	public boolean createIndex(String indexName);
	
	public Iterable<Campaign> listAll();
	
	public Page<Campaign> findByOfferDescription(String offerDescription, Pageable page);
}
