package com.greenapex.quizapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.greenapex.quizapp.entity.QuizModule;
import com.greenapex.quizapp.repository.QuizRepository;

@Service
public class QuizService {
	@Autowired
	QuizRepository quizRepo;
	public QuizModule createQuiz(QuizModule quiz) {
		quizRepo.save(quiz);
		return quiz;
	}

	public QuizModule updateQuiz(QuizModule quiz) {
		quizRepo.save(quiz);
		return quiz;
	}
	
	public QuizModule getQuizById(Integer quiz_id) {
		//return quizRepo.findById(quiz_id).get();
		Optional<QuizModule> result = quizRepo.findById(quiz_id);
        QuizModule quiz = null;
        if(result.isPresent())
            quiz = result.get();
        else
            throw new RuntimeException("Didn't find Quiz with Id "+quiz_id);
       
        return quiz;
	}
	
	public List<QuizModule> getAllQuiz() {
		List<QuizModule> disp=quizRepo.findAll();
		return disp ;
	}	
}
