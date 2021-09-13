package com.greenapex.quizapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "assessment")
public class AssessmentModule {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "user_id")
	private int user_id;
	@Column(name = "answer_id")
	private int answer_id;
	
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
	public int getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}
	public AssessmentModule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AssessmentModule(int id, int user_id, int answer_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.answer_id = answer_id;
	}
	@Override
	public String toString() {
		return "Assessment [id=" + id + ", user_id=" + user_id + ", answer_id=" + answer_id + "]";
	}

}
