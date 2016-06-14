package com.society.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.society.dao.RegisterDao;
import com.society.domain.Candidate;
import com.society.dto.CandidateDTO;
import com.society.helper.CandidateHelper;

@Service
public class RegisterServiceImpl implements RegisterService{
	@Autowired
    private RegisterDao registerDao;
	@Transactional
	public void addRegisterCandidate(Candidate candidate) {
		registerDao.addRegisterCandidateDao(candidate);
	}

	
	@Transactional
	public List<CandidateDTO> getAllRegisterCandidate() throws SQLException {
		List<Candidate> candidateList = registerDao.getAllRegisterCandidate();
		CandidateHelper candidateHelper = new CandidateHelper();
		List<CandidateDTO> candidateDTOList = candidateHelper.convertCandidateEntitytoDTO(candidateList);
		return candidateDTOList;
	}

	
	@Transactional
	public void deleteRegisterCandidate(Integer candidate) {
		registerDao.deleteRegisterCandidate(candidate);
	}
}
