package com.greenapex.quizapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.greenapex.quizapp.entity.QuestionModule;
import com.greenapex.quizapp.service.QuestionService;

@RestController
public class QuestionController {
	@Autowired	
	QuestionService qnService;
	
	@PostMapping("/addquestion")
	public QuestionModule addQues(@RequestBody QuestionModule ques) {
		qnService.addQuestion(ques);
		return ques;
		}
	
		@PutMapping("/updatequestion")
		public QuestionModule update(@RequestBody QuestionModule ques) {
			qnService.updateQuestion(ques);
			return ques;
		}
		
		 @GetMapping("/getquestionbyid/{question_id}")
			public QuestionModule getqnById(@PathVariable Integer question_id) {
				return qnService.getQuestionById(question_id);
			}
		 
	    @GetMapping("/getquestionbyquizid/{quiz_id}")
	    public List<QuestionModule> getAllQues(@PathVariable Integer quiz_id) {
			List<QuestionModule> disp=qnService.getAllQuestion(quiz_id);
			return disp ;
		}
	    
}
