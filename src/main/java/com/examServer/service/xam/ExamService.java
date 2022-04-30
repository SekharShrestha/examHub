package com.examServer.service.xam;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.examServer.entity.xam.Category;
import com.examServer.entity.xam.Exam;

public interface ExamService {
	
	public Exam addExam(Exam exam);
	public Exam updateExam(Exam exam);
	public Exam getExam(Long examId);
	public void deleteExam(Long examId);
	public Set<Exam> getExams();
	public List<Exam> getExamsOfCategory(Category c);

}
