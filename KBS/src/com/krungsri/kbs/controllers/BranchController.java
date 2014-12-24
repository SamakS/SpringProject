package com.krungsri.kbs.controllers;


//@Controller
@Deprecated
public class BranchController {
	
	
	
	//@RequestMapping(value="/branch")
	public String branch(){
		//List<Branch> listBranch = branchDao.list();
//		ModelAndView model = new ModelAndView("branch");
//		model.addObject("branchList",listBranch);
		return "branch";
	}
}
