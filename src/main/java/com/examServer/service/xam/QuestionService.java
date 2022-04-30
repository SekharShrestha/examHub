package com.examServer.service.xam;

import java.util.Set;

import com.examServer.entity.xam.Exam;
import com.examServer.entity.xam.Question;

public interface QuestionService {
	
	public Question addQuestion(Question question);
	public Question updateQuestion(Question question);
	public Question getQuestion(Long qid);
	public Set<Question> getQuestions(Exam exam);
	public void deleteQuestion(Long qid);
	public Question get(Long qid);

}
