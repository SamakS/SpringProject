package com.krungsri.kbs.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.krungsri.kbs.model.Branch;

public class BranchDAOImpl implements BranchDAO {
	
	private SessionFactory sessionFactory;
	
	public BranchDAOImpl(SessionFactory sessionFactory) {	
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Branch> list() {
		
		@SuppressWarnings("unchecked")
		List<Branch> listBranch = (List<Branch>)sessionFactory.getCurrentSession().createCriteria(Branch.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return listBranch;
	}

}
