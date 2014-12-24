package com.krungsri.kbs.services;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.highlight.HighlightBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.FacetedPage;
import org.springframework.data.elasticsearch.core.FacetedPageImpl;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.krungsri.kbs.model.elasticsearch.KbsExcBooth;
import com.krungsri.kbs.resposity.elasticsearch.KbsExcBoothRepo;
import com.krungsri.kbs.utils.DateUtils;
import com.krungsri.kbs.utils.ElasticsearchUtils;

@Service
public class KbsExcBoothServiceImpl implements KbsExcBoothService {
	private static final Logger log = LoggerFactory.getLogger(KbsExcBoothServiceImpl.class);
	
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	@Autowired
	private KbsExcBoothRepo kbsExcBoothRepo;
	
	@SuppressWarnings("unused")
	private void init(){
		elasticsearchTemplate.deleteIndex(KbsExcBooth.class);
		elasticsearchTemplate.createIndex(KbsExcBooth.class);
		elasticsearchTemplate.putMapping(KbsExcBooth.class);
		elasticsearchTemplate.refresh(KbsExcBooth.class, true);
	}
			
	@Override
	public Page<KbsExcBooth> listAll() {			
		log.info("start list all");					
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchAllQuery())				
				.withIndices("kbs_exc_booth_index")
				.withTypes("kbs_exc_booth_type")
				.build();
		
		Page<KbsExcBooth> page = elasticsearchTemplate.queryForPage(searchQuery, KbsExcBooth.class, new SearchResultMapper() {
			
			@SuppressWarnings("unchecked")
			@Override
			public <T> FacetedPage<T> mapResults(SearchResponse response, Class<T> clazz,
					Pageable pageable) {
				log.info("SearchResponse : {}",response);	
				List<KbsExcBooth> values = new ArrayList<KbsExcBooth>();
				for (SearchHit searchHit : response.getHits()) {
					KbsExcBooth kbsExcBooth = new KbsExcBooth();					
					kbsExcBooth.setKbsId((Integer)searchHit.getSource().get("KBS_ID"));
					kbsExcBooth.setLocation((String) searchHit.getSource().get("LOCATION"));
					kbsExcBooth.setTelephone((String) searchHit.getSource().get("TELEPHONE"));
					kbsExcBooth.setUpdateTime(DateUtils.elasticsearchDateTime2utilsDate((String) searchHit.getSource().get("UPDATE_TIME")));														
					values.add(kbsExcBooth);
				}
				log.info("list : {}",values);
				return new FacetedPageImpl<T>((List<T>) values);
			}
		});
		
		log.info("booth size : {}",page.getNumberOfElements());
		log.info("booth contents : {}",page.getContent());		
		
		return page;						
	}
				
	@Override
	public Page<KbsExcBooth> findByLocation(String location) {
		log.info(">>>>>>>>>>>>>>>>>>>>>>>> start findByLocation : {}",location);
		location = ElasticsearchUtils.thaiToElasticsearch(location);
		log.info(">>>>>>>>>>>>>>>>>>>>>>>> start convert Location : {}",location);
		
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(termQuery("LOCATION", location))
				.withHighlightFields(new HighlightBuilder.Field("LOCATION"))
				.withIndices("kbs_exc_booth_index")
				.withTypes("kbs_exc_booth_type")
				.build();
		
		Page<KbsExcBooth> page = elasticsearchTemplate.queryForPage(searchQuery, KbsExcBooth.class, new SearchResultMapper() {
			
			@SuppressWarnings("unchecked")
			@Override
			public <T> FacetedPage<T> mapResults(SearchResponse response, Class<T> clazz,
					Pageable pageable) {
				log.info("SearchResponse : {}",response);	
				List<KbsExcBooth> values = new ArrayList<KbsExcBooth>();
				for (SearchHit searchHit : response.getHits()) {
					KbsExcBooth kbsExcBooth = new KbsExcBooth();
					kbsExcBooth.setId(searchHit.getId());
					kbsExcBooth.setKbsId((Integer)searchHit.getSource().get("KBS_ID"));
					kbsExcBooth.setLocation((String) searchHit.getSource().get("LOCATION"));
					kbsExcBooth.setTelephone((String) searchHit.getSource().get("TELEPHONE"));
					kbsExcBooth.setUpdateTime(DateUtils.elasticsearchDateTime2utilsDate((String) searchHit.getSource().get("UPDATE_TIME")));
					kbsExcBooth.setHighlightedMessage(searchHit.getHighlightFields().get("LOCATION").fragments()[0].toString());
					values.add(kbsExcBooth);
				}
				log.info("list : {}",values);
				return new FacetedPageImpl<T>((List<T>) values);
			}
		});
		
		log.info("booth size : {}",page.getNumberOfElements());
		log.info("booth contents : {}",page.getContent());
	
		return page;
	}
}
