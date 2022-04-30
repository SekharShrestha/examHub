package com.examServer.controller.xam;

import java.util.List;
import java.util.Map;

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

import com.examServer.entity.xam.Exam;
import com.examServer.entity.xam.Question;
import com.examServer.service.xam.QuestionService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@PostMapping
	public ResponseEntity<Question> add(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
	
	@PutMapping
	public ResponseEntity<Question> update(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.updateQuestion(question));
	}
	
	@GetMapping("/exam/{eid}")
	public ResponseEntity<?> getQuestions(@PathVariable("eid") Long eid){
		Exam exam = new Exam();
		exam.setQid(eid);
		return ResponseEntity.ok(this.questionService.getQuestions(exam));
	}
	
	@GetMapping("/{qid}")
	public ResponseEntity<?> getQuestion(@PathVariable("qid") Long qid){
		return ResponseEntity.ok(this.questionService.getQuestion(qid));
	}
	
	@DeleteMapping("/{qid}")
	public void deleteQuestion(@PathVariable("qid") Long qid) {
		this.questionService.deleteQuestion(qid);
	}
	
	@PostMapping("/eval")
	public ResponseEntity<?> eval(@RequestBody List<Question> questions){
		
		int marksGot = 0;
		int correct = 0;
		int attempted = 0;
		for(Question q : questions) {
			
			Question question = this.questionService.get(q.getQid());
			if(question.getAns().equals(q.getGivenAnswer())) {
				correct++;
				double marksSingle = questions.get(0).getExam().getMaxMarks()/questions.size();
	            marksGot += marksSingle;
			}
			if(!q.getGivenAnswer().equals("") || q.getGivenAnswer() != null) {
				attempted++;				
			}
		}
		
		Map<String, Object> map = Map.of("marksGot", marksGot, "correct", correct, "attempted", attempted) ;
		return ResponseEntity.ok(map);
		
	}
	
	
}
