package com.greenapex.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.greenapex.quizapp.entity.AnswerModule;
import com.greenapex.quizapp.repository.AnswerRepository;

@Service
public class AnswerService {
	 @Autowired
	 AnswerRepository answerRepo;
	    public AnswerModule addAnswer(AnswerModule answer) {
		   answerRepo.save(answer);
			return answer;
			}

		public AnswerModule updateAnswer(AnswerModule answer) {
			answerRepo.save(answer);
			return answer;
			}
			
		public AnswerModule getAnswerById(Integer answer_id) {
			return answerRepo.findById(answer_id).get();
			}
			
		public List<AnswerModule> getAnswer(Integer question_id) {
			   List<AnswerModule> disp=answerRepo.findAnswerByQuestion_id(question_id);
				return disp;
			}	

}
