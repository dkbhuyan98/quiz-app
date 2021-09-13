package com.greenapex.quizapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.greenapex.quizapp.entity.QuizModule;
import com.greenapex.quizapp.service.QuizService;

@RestController
public class QuizController {
	    @Autowired	
	    QuizService quizService;
		@PostMapping("/createquiz")
		public QuizModule create(@RequestBody QuizModule quiz) {
			quizService.createQuiz(quiz);
			return quiz;
			}
		
			@PutMapping("/updatequiz")
			public QuizModule update(@RequestBody QuizModule quiz) {
				quizService.updateQuiz(quiz);
				return quiz;
			}
			
			@GetMapping("/getquizbyid/{quiz_id}")
				public QuizModule getqzById(@PathVariable Integer quiz_id) {
					return quizService.getQuizById(quiz_id);
			}
			
		    @GetMapping("/getallquiz")
			public List<QuizModule> getQuiz() {
				List<QuizModule> result=quizService.getAllQuiz();
				return result;
			}
		   
}
