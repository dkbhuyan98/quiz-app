package com.greenapex.quizapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.greenapex.quizapp.entity.QuestionModule;
import com.greenapex.quizapp.repository.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	QuestionRepository questionRepo;
	public QuestionModule addQuestion(QuestionModule ques) {
		questionRepo.save(ques);
		return ques;
	}

	public QuestionModule updateQuestion(QuestionModule ques) {
		questionRepo.save(ques);
		return ques;
	}
	
	public QuestionModule getQuestionById(Integer question_id) {
		return questionRepo.findById(question_id).get();
	}
	
	public List<QuestionModule> getAllQuestion(Integer quiz_id) {
		   List<QuestionModule> disp=questionRepo.findQuestionByQuiz_id(quiz_id);
		return disp;
	}

}