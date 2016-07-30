package com.society.controller;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanPropertyValueEqualsPredicate;
import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.society.domain.Candidate;
import com.society.dto.CandidateDTO;
import com.society.dto.CandidateDTOList;
import com.society.dto.CustomerDTO;
import com.society.helper.CandidateHelper;
import com.society.service.RegisterService;
import com.society.service.UserService;

@RestController
@RequestMapping(value = "/register")
public class RegisterController {


	@Autowired  
	RegisterService registerService;
	

	
	@RequestMapping(value = "/addcandidate", method = RequestMethod.POST)
	public String addCandidate(MultipartHttpServletRequest request,	@RequestHeader HttpHeaders requestHeader) throws Exception {
		String candidateData = request.getParameter("register");
		Candidate candidate = new Candidate();
		ObjectMapper mapper = new ObjectMapper();
		candidate = mapper.readValue(candidateData, Candidate.class);
		Iterator<String> itr = request.getFileNames();
	    while (itr.hasNext()) {
	      String key = itr.next();
	      MultipartFile mpf = request.getFile(key);
	      byte[] bytes = mpf.getBytes();
	      Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
	      candidate.setImage(blob);
	    }
	    registerService.addRegisterCandidate(candidate);
		return "success";
	}
	
	
	@RequestMapping(value = "/getcandidate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public CandidateDTOList getCandidates() throws Exception {
		CandidateDTOList candidateDTOList = new CandidateDTOList();
		List<CandidateDTO> candidates =  registerService.getAllRegisterCandidate();
		Collections.reverse(candidates);
		candidateDTOList.setCandidateDTOList(candidates);
			return candidateDTOList;
		
	}
	
	@RequestMapping(value = "/getimage", method = RequestMethod.GET)
	public byte[] getImage(@RequestParam("candidateId") int candidateId) throws Exception {
	List<CandidateDTO> candidates =  registerService.getAllRegisterCandidate();
	BeanPropertyValueEqualsPredicate genderPredicate = new BeanPropertyValueEqualsPredicate("id", candidateId);
	CandidateDTO candidateDTO = (CandidateDTO) CollectionUtils.find(candidates, genderPredicate);
	return candidateDTO.getImage();
}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	  @ResponseBody
		public CandidateDTOList searchCandidate(@RequestParam(value = "gender",required =false) String gender,@RequestParam(value= "fromAge",required =false) String fromAge,@RequestParam(value = "toAge",required =false) String toAge,@RequestParam(value = "annualIncome",required =false) String annualIncome,@RequestParam(value ="location",required =false) String location) throws Exception {
		CandidateDTOList response = new CandidateDTOList();
			List<CandidateDTO> candidates = registerService.getAllRegisterCandidate();
	        List<CandidateDTO> responseList = new ArrayList<CandidateDTO>();
			List<BeanPropertyValueEqualsPredicate> predicateList = null;
		if(gender != null && !gender.isEmpty())
		{
			BeanPropertyValueEqualsPredicate genderPredicate = new BeanPropertyValueEqualsPredicate("gender", gender);
			responseList = (List<CandidateDTO>) CollectionUtils.select(candidates, genderPredicate);
		}
		if((fromAge != null && fromAge != null) && (!fromAge.isEmpty() && !toAge.isEmpty()) )
		{
			Integer fromage = Integer.valueOf(fromAge);
			Integer toage = Integer.valueOf(toAge);
			
			for(CandidateDTO candidate : candidates)
			{
				Integer age = Integer.valueOf(candidate.getAge());
				if(age >= fromage &&  age <= toage)
				{
					responseList.add(candidate);
				}
			}
	   }
			if(annualIncome != null && !annualIncome.isEmpty())
			{
				BeanPropertyValueEqualsPredicate annulPredicate = new BeanPropertyValueEqualsPredicate("annualIncome", annualIncome);
				responseList.addAll((List<CandidateDTO>) CollectionUtils.select(candidates, annulPredicate));
			}
			if(location != null && !location.isEmpty())
			{
				BeanPropertyValueEqualsPredicate annulPredicate = new BeanPropertyValueEqualsPredicate("location", location);
				responseList.addAll((List<CandidateDTO>) CollectionUtils.select(candidates, annulPredicate));
			}
			
		
		 response.setCandidateDTOList(responseList);
		 return response;
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String removeCandidate(@RequestParam("candidateId") int candidateId) throws Exception {
	  registerService.deleteRegisterCandidate(candidateId);
	  return "success";
	}
	
	
	@RequestMapping(value = "/getcandiatedetailbyid", method = RequestMethod.GET)
	public CandidateDTO getCandiateDetailById(@RequestParam("candidateId") int candidateId) throws Exception {
		Candidate candidate = registerService.findById(candidateId);
		CandidateDTO candidateData = new CandidateDTO();
		BeanUtils.copyProperties(candidateData, candidate);
		return candidateData;
}
}
