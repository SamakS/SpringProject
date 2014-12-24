package com.krungsri.kbs.resposity.elasticsearch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.krungsri.kbs.model.elasticsearch.Campaign;
@Repository
public interface LmCampaignRepo extends ElasticsearchRepository<Campaign, String>{
		
	public Page<Campaign> findByOfferDescription(String offerDescription, Pageable page);
}
