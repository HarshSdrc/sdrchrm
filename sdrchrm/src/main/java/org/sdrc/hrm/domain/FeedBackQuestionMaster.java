package org.sdrc.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Subham Ashish (subham@sdrc.co.in)
 *	16-May-2017
 * 
 */

@Entity
@Table(name = "feedback_question")
public class FeedBackQuestionMaster {

	@Id
	@Column(name = "feedback_qstn_id_pk")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer questionId;

	private String questions;

	@Column(name="question_order",nullable=false)
	private Integer questionOrder;

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


	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getOrderid() {
		return questionOrder;
	}

	public void setOrderid(Integer orderid) {
		this.questionOrder = orderid;
	}

}
