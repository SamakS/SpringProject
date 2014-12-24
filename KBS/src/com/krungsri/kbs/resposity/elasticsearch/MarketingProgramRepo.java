package com.krungsri.kbs.resposity.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.krungsri.kbs.model.elasticsearch.MarketingProgram;
@Repository
public interface MarketingProgramRepo extends ElasticsearchRepository<MarketingProgram, String>{

}
