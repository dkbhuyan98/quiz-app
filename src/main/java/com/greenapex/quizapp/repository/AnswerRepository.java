package com.greenapex.quizapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.greenapex.quizapp.entity.AnswerModule;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerModule, Integer> {
	
	@Query(value= "select * from answer where question_id= ?1",nativeQuery = true)
	public List<AnswerModule> findAnswerByQuestion_id(Integer question_id);
}
