package com.greenapex.quizapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.greenapex.quizapp.entity.QuestionModule;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionModule, Integer> {
	
	@Query(value= "select * from question x where x.quiz_id=?1",nativeQuery = true)
	public List<QuestionModule> findQuestionByQuiz_id(Integer quiz_id);

}
