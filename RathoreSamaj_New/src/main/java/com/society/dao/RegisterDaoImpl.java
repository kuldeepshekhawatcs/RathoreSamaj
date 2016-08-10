package com.society.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.society.domain.Candidate;

@Repository
public class RegisterDaoImpl implements RegisterDao {
	@Autowired
    private SessionFactory sessionFactory;
	
	
	public void addRegisterCandidateDao(Candidate candidate) {
		this.sessionFactory.getCurrentSession().save(candidate);
	}
	public List<Candidate> getAllRegisterCandidate() {
		return this.sessionFactory.getCurrentSession().createQuery("from Candidate").list();
	}

	public void deleteRegisterCandidate(Integer candidate) {
		Candidate candidate2 = (Candidate) sessionFactory.getCurrentSession().load(
				Candidate.class, candidate);
        if (candidate2 !=null) {
        	this.sessionFactory.getCurrentSession().delete(candidate2);
        }
	}
	@Override
	public Candidate findById(Integer candidateId) {
		String queryInString = "from Candidate u where u.id =:candidateId";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryInString);
		query.setParameter("candidateId", candidateId);
		return (Candidate) query.uniqueResult();
	}
	@Override
	public List<Candidate> searchCandidate(String gender, String fromAge,
			   String toAge, String annualIncome, String location) {
			  List<Candidate> response = null;
			  Criteria creteria = sessionFactory.getCurrentSession().createCriteria(Candidate.class);
			  
			  Criterion gendrCriteria = null;
			  
			  if(gender != null && !gender.isEmpty())
			  {
				  gendrCriteria =Restrictions.eq("gender",gender);
				  creteria.add(gendrCriteria);
			  }
			   if((fromAge != null && fromAge != null) && (!fromAge.isEmpty() && !toAge.isEmpty()))
			  {
				  Criterion ags=Restrictions.between("age", fromAge,toAge);
				  creteria.add(ags);
			  }
			   if(annualIncome != null && !annualIncome.isEmpty())
			  {
				  Criterion anIncome=Restrictions.eq("annualIncome", annualIncome);
				  creteria.add(anIncome);
			  }
			  if(location != null && !location.isEmpty())
			  {
				  Criterion loc=Restrictions.eq("location", location);
				  creteria.add(loc);
			  }
			  
			  response = creteria.list();
			  return response;
			  
			  
			/*  // for single combination search
			  if(gender != null && !gender.isEmpty() && (fromAge != null && fromAge != null) && (!fromAge.isEmpty() && !toAge.isEmpty()) &&  annualIncome != null && !annualIncome.isEmpty() && location != null && !location.isEmpty())
			  {
			   Criterion gendr =Restrictions.eq("gender",gender);
			   Criterion ags=Restrictions.between("age", fromAge,toAge);
			   Criterion anIncome=Restrictions.eq("annualIncome", annualIncome);
			   Criterion loc=Restrictions.eq("location", location);
			   Conjunction andExp =Restrictions.and(gendr, ags,anIncome,loc);
			   creteria.add(andExp);
			  }
			  
			  else if(gender == null && (fromAge != null && fromAge != null) && (!fromAge.isEmpty() && !toAge.isEmpty()) &&  annualIncome != null && !annualIncome.isEmpty() && location != null && !location.isEmpty())
			  {
			   Criterion ags=Restrictions.between("age", fromAge,toAge);
			   Criterion anIncome=Restrictions.eq("annualIncome", annualIncome);
			   Criterion loc=Restrictions.eq("location", location);
			   Conjunction andExp =Restrictions.and(ags,anIncome,loc);
			   creteria.add(andExp);
			  }
			  else if(gender != null && !gender.isEmpty() && (fromAge != null && fromAge != null) && (!fromAge.isEmpty() && !toAge.isEmpty()) &&  annualIncome != null && !annualIncome.isEmpty() && location == null )
			  {
			   Criterion gendr =Restrictions.eq("gender",gender);
			   Criterion ags=Restrictions.between("age", fromAge,toAge);
			   Criterion anIncome=Restrictions.eq("annualIncome", annualIncome);
			   Conjunction andExp =Restrictions.and(gendr, ags,anIncome);
			   creteria.add(andExp);
			  }
			    else if(gender == null &&   (fromAge == null && fromAge == null)  &&  annualIncome != null && !annualIncome.isEmpty() && location != null && !location.isEmpty())
			  {
			   Criterion anIncome=Restrictions.eq("annualIncome", annualIncome);
			   Criterion loc=Restrictions.eq("location", location);
			   LogicalExpression andExp =Restrictions.and(anIncome,loc);
			   creteria.add(andExp);
			  }
			  // for single search
			  else if(gender == null &&  (fromAge == null && fromAge == null)  &&  annualIncome == null  && location != null && !location.isEmpty())
			  {
			   Criterion loc=Restrictions.eq("location", location);
			   creteria.add(loc);
			  }
			  else if(gender != null && !gender.isEmpty() && (fromAge == null && fromAge == null)  &&  annualIncome == null  && location == null)
			  {
			   Criterion gendr =Restrictions.eq("gender",gender);
			   creteria.add(gendr);
			  }
			  else if(gender == null && (fromAge != null && fromAge != null) && (!fromAge.isEmpty() && !toAge.isEmpty()) &&  annualIncome == null  && location == null)
			   {
			     Criterion ags=Restrictions.between("age", fromAge,toAge);
			     creteria.add(ags);
			     }
			   else if(gender == null &&   (fromAge == null && fromAge == null)  &&  annualIncome != null && !annualIncome.isEmpty() && location == null )
			  {
			   Criterion anIncome=Restrictions.eq("annualIncome", annualIncome);
			   creteria.add(anIncome);
			  }
			  
			  // for two combination search
			  else if(gender != null && !gender.isEmpty() && (fromAge != null && fromAge != null) && (!fromAge.isEmpty() && !toAge.isEmpty()) &&  annualIncome == null &&  location == null )
			  {
			   Criterion gendr =Restrictions.eq("gender",gender);
			   Criterion ags=Restrictions.between("age", fromAge,toAge);
			   LogicalExpression andExp =Restrictions.and(gendr, ags);
			   creteria.add(andExp);
			  }
			  else if(gender != null && !gender.isEmpty() && (fromAge == null && fromAge == null)  &&  annualIncome == null  && location != null && !location.isEmpty())
			  {
			   Criterion gendr =Restrictions.eq("gender",gender);
			   Criterion loc=Restrictions.eq("location", location);
			   LogicalExpression andExp =Restrictions.and(gendr,loc);
			   creteria.add(andExp);
			  }
			  else if(gender != null && !gender.isEmpty() && (fromAge == null && fromAge == null) && annualIncome != null && !annualIncome.isEmpty() && location == null)
			  {
			   Criterion gendr =Restrictions.eq("gender",gender);
			   Criterion anIncome=Restrictions.eq("annualIncome", annualIncome);
			   LogicalExpression andExp =Restrictions.and(gendr,anIncome);
			   creteria.add(andExp);
			  }
			  else if(gender == null  && (fromAge == null && fromAge == null)  &&  annualIncome != null && !annualIncome.isEmpty() && location != null && !location.isEmpty())
			  {
			   Criterion loc=Restrictions.eq("location", location);
			   Criterion anIncome=Restrictions.eq("annualIncome", annualIncome);
			   LogicalExpression andExp =Restrictions.and(loc,anIncome);
			   creteria.add(andExp);
			  }*/
			
			  
			 }
}
