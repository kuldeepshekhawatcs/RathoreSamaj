package com.society.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
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
}
