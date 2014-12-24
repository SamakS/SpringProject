package com.krungsri.kbs.services;

import java.util.Iterator;

import com.krungsri.kbs.controllers.model.MarketingProgramForm;

public interface MarketingProgramAdminService {
		
	public boolean save(MarketingProgramForm input, String state) throws Exception;
	
	public boolean delete(MarketingProgramForm input) throws Exception;
	
	public Iterator<MarketingProgramForm> listAll(MarketingProgramForm input) throws Exception;
}
