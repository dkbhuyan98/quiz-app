package com.greenapex.quizapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.greenapex.quizapp.entity.UserQuiz;

@Repository
public interface UserQuizRepository extends JpaRepository<UserQuiz, Integer> {
	@Query(value= "select * from user_quiz x where x.user_id=?1",nativeQuery = true)
	public List<UserQuiz> findByUserId(Integer user_id);

}