package com.krungsri.kbs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.krungsri.kbs.services.LMCampaignService;

@Controller
public class LmCampaignController {

	@Autowired
	LMCampaignService lmCampaignService;
	
	@RequestMapping(value="/lmCampaign",method=RequestMethod.GET)
	public String getLmCampaignList(ModelMap model){
		
		//model.addAttribute("lmCampaingList", lmCampaignService.findByOfferDescription("SME", new PageRequest(0, 10)));
		model.addAttribute("lmCampaingList", lmCampaignService.listAll());
		
		return "lmCampaign";
	}
}
