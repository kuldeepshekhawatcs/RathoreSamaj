package com.society.helper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.society.domain.Candidate;
import com.society.dto.CandidateDTO;

public class CandidateHelper {

	public List<CandidateDTO> convertCandidateEntitytoDTO(List<Candidate> candidateList) throws SQLException {
		List<CandidateDTO> candidateDTOList = new ArrayList<CandidateDTO>();
		if(candidateList!=null && candidateList.size()>0){
			for(Candidate candidate: candidateList){
				CandidateDTO candidateDTO = new CandidateDTO();
				candidateDTO.setId(candidate.getId());
				if(candidate.getFirstName()!=null){
					candidateDTO.setFirstName(candidate.getFirstName());
				}
				if(candidate.getLastName()!=null){
					candidateDTO.setLastName(candidate.getLastName());
				}
				if(candidate.getAge()!=null){
					candidateDTO.setAge(candidate.getAge());
				}
				if(candidate.getGender()!=null){
					candidateDTO.setGender(candidate.getGender());
				}
				if(candidate.getEducation()!=null){
					candidateDTO.setEducation(candidate.getEducation());
				}
				if(candidate.getOccupation()!=null){
					candidateDTO.setOccupation(candidate.getOccupation());
				}
				if(candidate.getAddress()!=null){
					candidateDTO.setAddress(candidate.getAddress());
				}
				if(candidate.getCandidateMobileNumber()!=null){
					candidateDTO.setCandidateMobileNumber(candidate.getCandidateMobileNumber());
				}
				if(candidate.getReligion()!=null){
					candidateDTO.setReligion(candidate.getReligion());
				}
				if(candidate.getLocation()!=null){
					candidateDTO.setLocation(candidate.getLocation());
				}
				if(candidate.getAnnualIncome()!=null){
					candidateDTO.setAnnualIncome(candidate.getAnnualIncome());
				}
				int blobLength = (int) candidate.getImage().length();  
				byte[] blobAsBytes = candidate.getImage().getBytes(1, blobLength);
				candidateDTO.setImage(blobAsBytes);
				candidateDTOList.add(candidateDTO);
			}
		}
		return candidateDTOList;
	}

}
