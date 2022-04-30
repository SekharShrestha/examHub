package com.examServer.repo.xam;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examServer.entity.xam.Category;
import com.examServer.entity.xam.Exam;

public interface ExamRepo extends JpaRepository<Exam, Long> {
	public List<Exam> findByCategory(Category c);

}
