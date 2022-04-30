package com.examServer.repo.xam;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examServer.entity.xam.Exam;
import com.examServer.entity.xam.Question;

public interface QuestionRepo extends JpaRepository<Question, Long> {

	Set<Question> findByExam(Exam exam);

}
