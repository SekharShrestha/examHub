package com.examServer.controller.xam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examServer.entity.xam.Category;
import com.examServer.entity.xam.Exam;
import com.examServer.service.xam.ExamService;

@RestController
@RequestMapping("/exam")
@CrossOrigin("*")
public class ExamController {
	
	@Autowired
	private ExamService examService;
	
	@PostMapping("/add-exams")
	public ResponseEntity<Exam> add(@RequestBody Exam exam){
		return ResponseEntity.ok(this.examService.addExam(exam));
	}
	
	@PutMapping
	public ResponseEntity<Exam> update(@RequestBody Exam exam){
		return ResponseEntity.ok(this.examService.updateExam(exam));
	}
	
	@GetMapping
	public ResponseEntity<?> getExams(){
		return ResponseEntity.ok(this.examService.getExams());
	}
	
	@GetMapping("/{qid}")
	public ResponseEntity<Exam> getExam(@PathVariable("qid") Long qid){
		return ResponseEntity.ok(this.examService.getExam(qid));
	}
	
	@DeleteMapping("/{qid}")
	public void deleteExam(@PathVariable("qid") Long qid) {
		this.examService.deleteExam(qid);
	}
	
	
	@GetMapping("/category/{cid}")
	public List<Exam> getExamsOfCategory(@PathVariable("cid") Long cid){
		Category c = new Category();
		c.setCid(cid);
		return this.examService.getExamsOfCategory(c);
	}
	
	

}
