package com.greenapex.quizapp.controller;

import java.util.ArrayList;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.greenapex.quizapp.entity.AssessmentModule;
import com.greenapex.quizapp.service.AssessmentService;

@RestController
public class AssessmentController {
	@Autowired	
    AssessmentService assService;
	
	@PostMapping("/addassessment")
	public AssessmentModule addAssessments(@RequestBody AssessmentModule ass) {
		 assService.addAssessment(ass);
		return ass;
		}
	
	 @GetMapping("/finalassresult/{user_id}")
	 public String getAssById(@PathVariable Integer user_id) {
			return assService.assessmentResult(user_id) + " answers are correct";
	    }
	 
	 @GetMapping("/assessmentresult/{user_id}")
	 public ArrayList<Map<String, Object>> assById(@PathVariable Integer user_id){
			return assService.assessmentRes(user_id);
		 } 
	 
	  @GetMapping("/allassessmentbyid/{user_id}/{quiz_id}")
	   public ArrayList<Map<String,Object>> getAssessment(@PathVariable Integer user_id,@PathVariable Integer quiz_id) {
		    return assService.displayAllAss(user_id,quiz_id);		
		}
	  
}
