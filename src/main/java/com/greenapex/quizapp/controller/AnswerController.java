package com.greenapex.quizapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greenapex.quizapp.entity.AnswerModule;
import com.greenapex.quizapp.service.AnswerService;

@RestController
public class AnswerController {
	@Autowired
	AnswerService ansService;
	@PostMapping("/addanswer")
	public AnswerModule addAns(@RequestBody AnswerModule ans) {
		ansService.addAnswer(ans);
		return ans;
		}
	
		@PutMapping("/updateanswer")
		public AnswerModule update(@RequestBody AnswerModule ans) {
			ansService.updateAnswer(ans);
			return ans;
		}
		
		 @GetMapping("/getanswerbyansid/{answer_id}")
		 public AnswerModule getansById(@PathVariable Integer answer_id) {
				return ansService.getAnswerById(answer_id);
			}
		 
	    @GetMapping("/getanswerbyqnid/{question_id}")
	    public List<AnswerModule> getAns(@PathVariable Integer question_id) {
	    	List<AnswerModule> disp=ansService.getAnswer(question_id);
			return disp ;
		}
}