package com.krungsri.kbs.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.krungsri.kbs.controllers.model.Group;
import com.krungsri.kbs.controllers.model.MarketingProgramForm;
import com.krungsri.kbs.controllers.model.Status;
import com.krungsri.kbs.services.MarketingProgramAdminService;
import com.krungsri.kbs.utils.PagingUtils;

@Controller
public class MarketingProgramAdminController {
	private static final Logger log = LoggerFactory.getLogger(MarketingProgramAdminController.class);
	
	@Autowired
	private MarketingProgramAdminService marketingProgramAdminService;
	
	@RequestMapping(value="/marketingProgramAdmin", method=RequestMethod.GET)
	public ModelAndView initPage(@RequestParam(value="state", required=false, defaultValue=PagingUtils.STATE_INIT) String state, 
			MarketingProgramForm form,Model model) throws Exception {
		
		String redirect = PagingUtils.MKT_PROGRAM_ADMIN_PAGE;
		
		log.info("-----------------------------> state = {}",state);
		log.info("-----------------------------> form = {}",form);
		log.info("-----------------------------> model = {}",model);
						
		if(PagingUtils.STATE_INIT.equalsIgnoreCase(state)){
			redirect = PagingUtils.MKT_PROGRAM_ADMIN_PAGE;
		}else if(PagingUtils.STATE_ADD.equalsIgnoreCase(state)){					
			model.addAttribute("title", "Add Marketing Program");
			
			initModelList(model);
			
			redirect = PagingUtils.MKT_PROGRAM_ADMIN_ADD_EDIT_PAGE;
		}else if(PagingUtils.STATE_EDIT.equalsIgnoreCase(state)){						
			model.addAttribute("title", "Edit Marketing Program");
			
			initModelList(model);
			
			redirect = PagingUtils.MKT_PROGRAM_ADMIN_ADD_EDIT_PAGE;
		}else if(PagingUtils.STATE_DELETE.equalsIgnoreCase(state)){
			redirect = PagingUtils.MKT_PROGRAM_ADMIN_PAGE;
		}
		
		//return redirect;
		return new ModelAndView(redirect, "mktAdminForm", new MarketingProgramForm());
	}	
	
	private void initModelList(Model model) throws Exception{
		List<Status> statusList = new ArrayList<Status>();
		statusList.add(new Status(1, "Draft"));
		statusList.add(new Status(2, "Awaiting Approval"));
		statusList.add(new Status(3, "Published"));
		statusList.add(new Status(4, "Archived"));
		
		model.addAttribute("statusList", statusList);
		
		List<Group> groupList = new ArrayList<Group>();
		groupList.add(new Group("A", "All   "));
		groupList.add(new Group("C", "Call Center   "));
		groupList.add(new Group("B", "Branch   "));
		
		model.addAttribute("groupList", groupList);
	}
	
	@RequestMapping(value="/marketingProgramAdminAddEdit", method=RequestMethod.POST)
	public String save(@ModelAttribute("mktAdminForm") MarketingProgramForm mktAdminForm)  throws Exception{
		
		//String redirect = PagingUtils.MKT_PROGRAM_ADMIN_PAGE;
				
		log.info("-----------------------------> mktAdminForm = {}",mktAdminForm);			
		
		//marketingProgramAdminService.save(form, state);
		
		return "redirect:marketingProgramAdmin";
	}

}
