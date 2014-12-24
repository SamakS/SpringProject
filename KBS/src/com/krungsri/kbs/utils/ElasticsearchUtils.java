package com.krungsri.kbs.utils;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElasticsearchUtils {

	private static final Logger LOG = LoggerFactory
			.getLogger(ElasticsearchUtils.class);
	
	public static String thaiToElasticsearch(String s) {
		String out = null;
		try {
			out = new String(s.getBytes("ISO8859_9"), "UTF-8");
		} catch (java.io.UnsupportedEncodingException e) {
			return null;
		}
		return out;
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		LOG.info("Connectting Elasticsearch Server");
		System.out.println("Connectting Elasticsearch Server");
		Settings settings = ImmutableSettings.settingsBuilder()
				.put("client.transport.sniff", true)
				.put("cluster.name", "elasticsearch").build();
		
		Client client = new TransportClient(settings)
				.addTransportAddress(new InetSocketTransportAddress(
						"localhost", 9300));
		LOG.info("Connected Elasticsearch Server");
		System.out.println("Connected Elasticsearch Server");
		try {
			LOG.info("creating Index");
			createIndex(client);
			LOG.info("created Index");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			client.close();
			client = null;
			LOG.info("Close connect Elasticsearch Server");
			System.out.println("Close connect Elasticsearch Server");
		}						
	}

	@SuppressWarnings("unused")
	private String createJSONNative() {
		StringBuffer json = new StringBuffer();

		json.append("{");
		json.append("\"user\":\"kimchy\",");
		json.append("\"postDate\":\"2013-01-30\",");
		json.append("\"message\":\"trying out Elasticsearch\"");
		json.append("}");

		return json.toString();
	}

	@SuppressWarnings("unused")
	private Map<String, Object> createJSONMap() {
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("user", "kimchy");
		json.put("postDate", new Date());
		json.put("message", "trying out Elasticsearch");
		return json;
	}

	@SuppressWarnings("unused")
	private String createJSONBean() {
		String json = "";

//		// instance a json mapper
//		ObjectMapper mapper = new ObjectMapper(); // create once, reuse
//
//		Marketing marketing = new Marketing();
//		marketing.setPathMenu("/test/test1");
//		marketing.setTitle("test");
//		marketing.setLastUpdated(new Date());
//		// generate json
//		try {
//			json = mapper.writeValueAsString(marketing);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}

		return json;
	}

	@SuppressWarnings("unused")
	private XContentBuilder createJSONElasticsearchHelper() {
		XContentBuilder builder = null;
		try {
			builder = XContentFactory.jsonBuilder();
			builder.startObject().field("user", "kimchy")
			.field("postDate", new Date())
			.field("message", "trying out Elasticsearch").endObject();		
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return builder;
	}

	private static void createIndex(Client client){
		try {
			IndexResponse response = client.prepareIndex("test", "test1", "1")
			        .setSource(XContentFactory.jsonBuilder()
			                    .startObject()
			                        .field("user", "kimchy")
			                        .field("postDate", new Date())
			                        .field("message", "trying out Elasticsearch")
			                    .endObject()
			                  )
			        .execute()
			        .actionGet();
			
			// Index name
			String _index = response.getIndex();
			// Type name
			String _type = response.getType();
			// Document ID (generated or not)
			String _id = response.getId();
			// Version (if it's the first time you index this document, you will get: 1)
			long _version = response.getVersion();
			
			LOG.info("_index : {}, _type : {}, _id : {}, _version : {}",_index,_type,_id,_version);
		} catch (ElasticsearchException | IOException e) { 
			e.printStackTrace();
		}
	} 
}
