package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmpReactiveRestService {

	@Autowired
	EmpReactiveMongoRepository repo;

	@GetMapping(path = "/emp2/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<Emp>> findEmpById(@PathVariable("id")int id) {
		
		return repo.findById(id).map(e->ResponseEntity.ok(e)).defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@GetMapping(path = "/emp2/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<Emp> getAllEmps() {
		return repo.findAll();
	}

	@PostMapping(path = "/emp2/save", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Emp> saveEmp(@RequestBody Emp e) {
		return repo.save(e);
	}

}
