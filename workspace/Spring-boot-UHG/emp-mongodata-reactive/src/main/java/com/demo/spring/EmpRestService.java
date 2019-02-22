package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmpRestService {

	@Autowired
	private EmpRepository repo;

	// @RequestMapping(path="/info",method=RequestMethod.GET,produces=MediaType.TEXT_PLAIN_VALUE)
	@GetMapping(path = "/info", produces = MediaType.TEXT_PLAIN_VALUE)
	public String info() {
		return "This is a demo Rest Service";
	}

	@GetMapping(path = "/emp/find/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Mono<ResponseEntity<Emp>> findEmpById(@PathVariable("id") int id) {

		
		
		return repo.findById(id).map(existingEmp->ResponseEntity.ok(existingEmp))
				.defaultIfEmpty(ResponseEntity.notFound().build());
		
	}

	@GetMapping(path = "/emp/list", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Flux<Emp> getAllEmps() {
		return repo.findAll();
	}

	@PostMapping(path = "/emp/saveForm", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public Mono<Emp> saveFormData(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("city") String city, @RequestParam("salary") double salary) {

		if (!repo.existsById(id).equals(null)) {
			throw new RuntimeException("Emp exists");
		} else {
			
			return repo.save(new Emp(id, name, city, salary));
		}

	}

	@PostMapping(path = "/emp/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public Mono<Emp> saveJSONData(@RequestBody Emp e) {

		if (!repo.existsById(e.getEmpid()).equals(null)) {
			throw new RuntimeException("Emp exists");
		} else {
			
			return repo.save(e);
		}

	}

	@PutMapping(path = "/emp/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public Mono<Emp> update(@RequestBody Emp e) {

		
		return repo.save(e);
	}

	@DeleteMapping(path = "/emp/delete", produces = MediaType.TEXT_PLAIN_VALUE)
	public Mono<ResponseEntity<Void>> delete(@RequestParam("id") int id) {

		return repo.findById(id).flatMap(oldEmp->repo.delete(oldEmp)).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
}
