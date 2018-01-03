package org.sdrc.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback_question")
public class FeedBackQuestionMaster {

	@Id
	@Column(name = "feedback_qstn_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer questionId;

	private String questions;

	@Column(nullable=false)
	private Integer order;

	private String remarks;

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
