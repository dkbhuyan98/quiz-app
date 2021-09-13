package com.greenapex.quizapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quiz")
public class QuizModule {
	@Id
	@Column(name = "quiz_id")
	private int quiz_id;
	@Column(name = "quiz_name")
	private String quiz_name;
	
	public int getQuiz_id() {
		return quiz_id;
	}
	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}
	public String getQuiz_name() {
		return quiz_name;
	}
	public void setQuiz_name(String quiz_name) {
		this.quiz_name = quiz_name;
	}
	
	
	public QuizModule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuizModule(int quiz_id, String quiz_name) {
		super();
		this.quiz_id = quiz_id;
		this.quiz_name = quiz_name;
	}
	@Override
	public String toString() {
		return "QuizModule [quiz_id=" + quiz_id + ", quiz_name=" + quiz_name + "]";
	}

	
}
