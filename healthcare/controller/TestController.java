package com.springboot.healthcare.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.healthcare.exception.ResourceNotFoundException;
import com.springboot.healthcare.model.Test;
import com.springboot.healthcare.repository.TestRepository;


@RestController
@RequestMapping("api/k1")
public class TestController {
	
	@Autowired
	private TestRepository testrepository;
	
	//Get all tests
	@GetMapping("tests")
	public List<Test> getAllTests(){
		return testrepository.findAll();
	}
	//Crud operations
		//Create
		@PostMapping("/tests")
		public Test createTest(@RequestBody Test test) {
			return testrepository.save(test);
		}
	
		//get test by Id rest API
		@GetMapping("/tests/{testId}")
		public ResponseEntity<Test> getTestById(@PathVariable Long testId) {
			Test test = testrepository.findById(testId)
					.orElseThrow(() -> 
					new ResourceNotFoundException("Test not exists with id: " + testId));
			return ResponseEntity.ok(test);
		}
		//update test rest API
		@PutMapping("/tests/{testId}")
		public ResponseEntity<Test> updateTest(@PathVariable Long testId,  
				@RequestBody Test testDetails){
			Test test = testrepository.findById(testId)
					.orElseThrow( ()-> 
					new ResourceNotFoundException("Test not exist with id;" +testId));
//			test.setTestId(testDetails.getTestId());
			test.setTestName(testDetails.getTestName());
			
			
			Test updateTest=testrepository.save(test);
			return ResponseEntity.ok(updateTest);
			
		}
		@DeleteMapping("/tests/{testId}")
	    public Map<String, Boolean> deleteTest(@PathVariable(value = "testId") Long testId)
	         throws ResourceNotFoundException {
			Test test = testrepository.findById(testId)
	       .orElseThrow(() -> new ResourceNotFoundException("Test not found for this id : " + testId));

			testrepository.delete(test);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	}
