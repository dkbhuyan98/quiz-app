package com.greenapex.quizapp.repository;

import java.util.ArrayList;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.greenapex.quizapp.entity.AssessmentModule;

@Repository
public interface AssessmentRepository extends JpaRepository<AssessmentModule, Integer> {
	@Query(value="select count(*) from assessment x where x.user_id=?1 and x.answer_id in (select answer_id from answer y where y.is_correct=1)",nativeQuery=true)
	public String correctAnswer(Integer user_id);
    
	@Query(value="select user.username,question.quiz_id,answer.answer,answer.is_correct,question.question from user join assessment join answer join question on user.user_id=assessment.user_id and assessment.answer_id=answer.answer_id and answer.question_id=question.question_id where user.user_id = ?1", nativeQuery=true)
	public ArrayList<Map<String, Object>> assessmentDetail(Integer user_id);
	
	@Query(value="select user.username,question.quiz_id,answer.answer,answer.is_correct,question.question from user join assessment join answer join question on user.user_id=assessment.user_id and assessment.answer_id=answer.answer_id and answer.question_id=question.question_id where user.user_id = ?1 and quiz_id=?2", nativeQuery=true)
	public ArrayList<Map<String, Object>> assessmentDetails(Integer user_id, Integer quiz_id);
	
	
	
}