package com.krungsri.kbs.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.krungsri.kbs.controllers.model.KbsExcBoothForm;
import com.krungsri.kbs.controllers.model.PageKbsExcBooth;
import com.krungsri.kbs.model.elasticsearch.KbsExcBooth;
import com.krungsri.kbs.services.KbsExcBoothService;
import com.krungsri.kbs.utils.CommonUtils;
import com.krungsri.kbs.utils.DateUtils;

@Controller
@RequestMapping(value="/kbsExcBooth")
public class KbsExcBoothController {
	private static final Logger log = LoggerFactory.getLogger(KbsExcBoothController.class);
	
	@Autowired
	private KbsExcBoothService kbsExcBoothService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView init(ModelMap model){
		return new ModelAndView("kbsExcBooth", "kbsExcBoothForm", new PageKbsExcBooth());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView search(ModelMap model, PageKbsExcBooth form){
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> form : {}",form);
		Page<KbsExcBooth> page = null;
		if(form != null){
			String location = form.getLocal();
			
			if(CommonUtils.isBlank(location)){
				page = kbsExcBoothService.listAll();	
			}else{
				page = kbsExcBoothService.findByLocation(location);
			}
		}
		
		PageKbsExcBooth pageKbsExcBooth = new PageKbsExcBooth();
		pageKbsExcBooth.setRows(convert2Form(page.getContent()));
		
		model.addAttribute("kbsExcBoothList", convert2Form(page.getContent()));
		
		log.info("page.getContent() : {}",convert2Form(page.getContent()));
			
		return new ModelAndView("kbsExcBooth", "kbsExcBoothForm",  pageKbsExcBooth);
	}
	
	private List<KbsExcBoothForm> convert2Form(List<KbsExcBooth> listInput){
		List<KbsExcBoothForm> list = new ArrayList<KbsExcBoothForm>();
		for(KbsExcBooth en : listInput){
			KbsExcBoothForm form = new KbsExcBoothForm();
			form.setId(en.getId());
			form.setLocation(en.getLocation());
			form.setTelephone(en.getTelephone());
			form.setUpdateTime(DateUtils.dateToString(en.getUpdateTime(), DateUtils.DEFAULT_DATETIME_FORMAT) );
			form.setHighlightedMessage(en.getHighlightedMessage());
			list.add(form);
		}	
		return list;				
	}
	
}
