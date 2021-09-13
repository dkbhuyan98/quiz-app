package com.greenapex.quizapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.greenapex.quizapp.entity.UserQuiz;
import com.greenapex.quizapp.service.UserQuizService;

@RestController
public class UserQuizController {
	@Autowired	
    UserQuizService userquizService;
	
	   @PostMapping("/adduserquiz")
	   public UserQuiz addUserQuiz(@RequestBody UserQuiz uq) {
		userquizService.insertUserquiz(uq);
		return uq;
		}
	
		@PutMapping("/updateuserquiz")
		public UserQuiz updateUserQuiz(@RequestBody UserQuiz uq) {
			userquizService.updateUserquiz(uq);
			return uq;
		}
		
	    @GetMapping("/getuserquizbyid/{user_id}")
			public List<UserQuiz> getUserQuizById(@PathVariable Integer user_id) {
				return userquizService.displayById(user_id);
			}
		 
	    @GetMapping("/alluserquiz")
			public List<UserQuiz> getallUserQuiz() {
				List<UserQuiz> result=userquizService.displayAll();
				return result;

		}
}