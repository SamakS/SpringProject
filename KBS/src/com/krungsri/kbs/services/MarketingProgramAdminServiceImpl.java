package com.krungsri.kbs.services;

import static org.apache.commons.lang.RandomStringUtils.randomNumeric;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import com.krungsri.kbs.controllers.model.MarketingProgramForm;
import com.krungsri.kbs.model.elasticsearch.MarketingProgram;
import com.krungsri.kbs.resposity.elasticsearch.MarketingProgramRepo;
import com.krungsri.kbs.utils.CommonUtils;
import com.krungsri.kbs.utils.PagingUtils;

@Service
public class MarketingProgramAdminServiceImpl implements
		MarketingProgramAdminService {
	private static final Logger log = LoggerFactory.getLogger(MarketingProgramAdminServiceImpl.class);
	
	@Autowired
	private MarketingProgramRepo marketingProgramRepo;
	
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
		
	private MarketingProgram convertForm2Document(MarketingProgramForm input,String state){
		MarketingProgram doc = new MarketingProgram();
		
		String documentId = input.getId();
		
		if(CommonUtils.isBlank(documentId) && PagingUtils.STATE_ADD.equalsIgnoreCase(state)){
			documentId = randomNumeric(5);			
		}
		
		log.info("document id = {}",documentId);
		log.info("MarketingProgramForm = {}",input);
		
		doc.setId(documentId);
		doc.setPath(input.getPath());
		doc.setName(input.getName());
		doc.setOverview(input.getOverview());
		doc.setKeyword(input.getKeyword());
		
		return doc;
	}
	
	private void init(){
		elasticsearchTemplate.deleteIndex(MarketingProgram.class);
		elasticsearchTemplate.createIndex(MarketingProgram.class);
		elasticsearchTemplate.putMapping(MarketingProgram.class);
		elasticsearchTemplate.refresh(MarketingProgram.class, true);
	}
	
	@Override
	public boolean save(MarketingProgramForm input, String state) throws Exception {
		log.info("state={}, MarketingProgramForm={}",state,input);
		if(PagingUtils.STATE_ADD.equalsIgnoreCase(state)){
			init();
		}
		
		marketingProgramRepo.save(convertForm2Document(input,state));
		
		return false;
	}

	@Override
	public boolean delete(MarketingProgramForm input) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<MarketingProgramForm> listAll(MarketingProgramForm input)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
