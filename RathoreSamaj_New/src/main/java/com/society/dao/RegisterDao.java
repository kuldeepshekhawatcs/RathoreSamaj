package com.society.dao;

import java.util.List;

import com.society.domain.Candidate;


public interface RegisterDao {
	   public List<Candidate> getAllRegisterCandidate();
	    public void deleteRegisterCandidate(Integer employeeId);
		public void addRegisterCandidateDao(Candidate candidate);
}
