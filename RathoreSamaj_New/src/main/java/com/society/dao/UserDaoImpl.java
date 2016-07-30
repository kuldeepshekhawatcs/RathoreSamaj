package com.society.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.society.domain.Candidate;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
    private SessionFactory sessionFactory;
	
	
	public void add(Candidate candidate) {
		this.sessionFactory.getCurrentSession().save(candidate);
	}
	public List<Candidate> findAll() {
		return this.sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public void delete(Integer candidate) {
		Candidate candidate2 = (Candidate) sessionFactory.getCurrentSession().load(
				Candidate.class, candidate);
        if (candidate2 !=null) {
        	this.sessionFactory.getCurrentSession().delete(candidate2);
        }
	}
	@Override
	public String validateUser(String username, String password) {
		String response = "failure";
		Query query = this.sessionFactory.getCurrentSession().createQuery("from User u where u.userName =:username and u.password =:password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		if(!query.list().isEmpty())
		{
			response =  "success";
		}
		return response;
	}
	
}
