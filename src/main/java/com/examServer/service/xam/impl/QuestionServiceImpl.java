package com.examServer.service.xam.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examServer.entity.xam.Exam;
import com.examServer.entity.xam.Question;
import com.examServer.repo.xam.QuestionRepo;
import com.examServer.service.xam.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepo questionRepo;

	@Override
	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		return this.questionRepo.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return this.questionRepo.save(question);
	}

	@Override
	public Question getQuestion(Long qid) {
		// TODO Auto-generated method stub
		return this.questionRepo.findById(qid).get();
	}

	@Override
	public Set<Question> getQuestions(Exam exam) {
		// TODO Auto-generated method stub
		return this.questionRepo.findByExam(exam);
	}

	@Override
	public void deleteQuestion(Long qid) {
		// TODO Auto-generated method stub
		this.questionRepo.deleteById(qid);
		
	}

	@Override
	public Question get(Long qid) {
		// TODO Auto-generated method stub
		return this.questionRepo.getOne(qid);
	}

}
