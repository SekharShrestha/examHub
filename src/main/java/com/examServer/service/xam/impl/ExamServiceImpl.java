package com.examServer.service.xam.impl;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examServer.entity.xam.Category;
import com.examServer.entity.xam.Exam;
import com.examServer.repo.xam.ExamRepo;
import com.examServer.service.xam.ExamService;

@Service
public class ExamServiceImpl implements ExamService {
	
	@Autowired
	private ExamRepo examRepo;

	@Override
	public Exam addExam(Exam exam) {
		// TODO Auto-generated method stub
		return this.examRepo.save(exam);
	}

	@Override
	public Exam updateExam(Exam exam) {
		// TODO Auto-generated method stub
		return this.examRepo.save(exam);
	}

	@Override
	public Exam getExam(Long examId) {
		// TODO Auto-generated method stub
		return this.examRepo.findById(examId).get();
	}

	@Override
	public void deleteExam(Long examId) {
		// TODO Auto-generated method stub
		this.examRepo.deleteById(examId);
		
	}

	@Override
	public Set<Exam> getExams() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(this.examRepo.findAll());
	}

	@Override
	public List<Exam> getExamsOfCategory(Category c) {
		// TODO Auto-generated method stub
		return this.examRepo.findByCategory(c);
	}

	
	
	

}
