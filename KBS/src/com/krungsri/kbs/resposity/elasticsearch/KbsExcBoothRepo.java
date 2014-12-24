package com.krungsri.kbs.resposity.elasticsearch;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.krungsri.kbs.model.elasticsearch.KbsExcBooth;

@Repository
public interface KbsExcBoothRepo  extends ElasticsearchRepository<KbsExcBooth, String>{
	@Query("{\"bool\" : {\"must\" : {\"term\" : {\"kbs_exc_booth_type.LOCATION\" : \"?\"}}}}")
	public List<KbsExcBooth> findByLocation(String location);
}
