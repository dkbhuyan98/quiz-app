package com.greenapex.quizapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_quiz")
public class UserQuiz {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "user_id")
	private int user_id;
	@Column(name = "quiz_id")
	private int quiz_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getQuiz_id() {
		return quiz_id;
	}
	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}
	public UserQuiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserQuiz(int id, int user_id, int quiz_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.quiz_id = quiz_id;
	}
	@Override
	public String toString() {
		return "UserQuiz [id=" + id + ", user_id=" + user_id + ", quiz_id=" + quiz_id + "]";
	}
	

}
