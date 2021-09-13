package com.greenapex.quizapp.service;

import java.util.ArrayList;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.greenapex.quizapp.entity.AssessmentModule;
import com.greenapex.quizapp.repository.AssessmentRepository;

@Service
public class AssessmentService {
	@Autowired
	AssessmentRepository assessmentRepo;
	
	public AssessmentModule addAssessment(AssessmentModule ass) {
		assessmentRepo.save(ass);
		return ass;
	}
	
	public String assessmentResult(Integer user_id) {
		String result = assessmentRepo.correctAnswer(user_id);
		return result;
	}
	
	public ArrayList<Map<String,Object>> assessmentRes(Integer user_id) {
		   return assessmentRepo.assessmentDetail(user_id);
	}
	
	public ArrayList<Map<String,Object>> displayAllAss(Integer user_id, Integer quiz_id) {
		 return assessmentRepo.assessmentDetails(user_id,quiz_id);
	}	
}