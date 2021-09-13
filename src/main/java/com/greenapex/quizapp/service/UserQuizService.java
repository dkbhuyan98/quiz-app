package com.greenapex.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenapex.quizapp.entity.UserQuiz;
import com.greenapex.quizapp.repository.UserQuizRepository;

@Service
public class UserQuizService {
	@Autowired
	UserQuizRepository userquizrepo;
	public UserQuiz insertUserquiz(UserQuiz userquiz) {
		userquizrepo.save(userquiz);
		return userquiz;
	}

	public UserQuiz updateUserquiz(UserQuiz userquiz) {
		userquizrepo.save(userquiz);
		return userquiz;
	}
	
	public List<UserQuiz> displayById(Integer user_id) {
		return userquizrepo.findByUserId(user_id);
	}
	
	public List<UserQuiz> displayAll() {
		List<UserQuiz> disp=userquizrepo.findAll();
		return disp ;
	}	
}
