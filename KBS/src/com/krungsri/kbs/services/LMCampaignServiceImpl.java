package com.krungsri.kbs.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import com.krungsri.kbs.model.elasticsearch.Campaign;
import com.krungsri.kbs.model.elasticsearch.Person;
import com.krungsri.kbs.resposity.elasticsearch.LmCampaignRepo;
@Service
public class LMCampaignServiceImpl implements LMCampaignService {
	
	private static final Logger log = LoggerFactory.getLogger(LMCampaignServiceImpl.class);
	
	@Autowired
	LmCampaignRepo lmCampaignRepo;
	
	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;

	
	private void init(){
		elasticsearchTemplate.deleteIndex(Person.class);
		elasticsearchTemplate.createIndex(Person.class);
		elasticsearchTemplate.putMapping(Person.class);
		elasticsearchTemplate.refresh(Person.class, true);
	}
	
	@Override
	public Iterable<Campaign> listAll() {
		Iterable<Campaign> list = lmCampaignRepo.findAll();
		
		log.info("list : {}",list);
		
		return list;
	}

	@Override
	public Page<Campaign> findByOfferDescription(String offerDescription,
			Pageable page) {
				
		return lmCampaignRepo.findByOfferDescription(offerDescription, page);
	}

	@Override
	public boolean createIndex(String indexName) {
		init();
		return false;
	}
	
	
}
