package com.demo.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ResponseEntity findEmpById(@PathVariable("id") int id) {

		Optional<Emp> o = repo.findById(id);
		if (o.isPresent()) {
			return ResponseEntity.ok(o.get());
		} else {
			return ResponseEntity.ok("Emp Not Found..");
		}
	}

	@GetMapping(path = "/emp/list", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Emp>> getAllEmps() {
		return ResponseEntity.ok(repo.findAll());
	}

	@PostMapping(path = "/emp/saveForm", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity saveFormData(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("city") String city, @RequestParam("salary") double salary) {

		if (repo.existsById(id)) {
			return ResponseEntity.ok("Emp Already Exists");
		} else {
			repo.save(new Emp(id, name, city, salary));
			return ResponseEntity.ok("Emp Saved Successfully");
		}

	}

	@PostMapping(path = "/emp/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity saveJSONData(@RequestBody Emp e) {

		if (repo.existsById(e.getEmpid())) {
			return ResponseEntity.ok("Emp Already Exists");
		} else {
			repo.save(e);
			return ResponseEntity.ok("Emp Saved Successfully");
		}

	}

	@PutMapping(path = "/emp/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity update(@RequestBody Emp e) {

		repo.save(e);
		return ResponseEntity.ok("Emp updated Successfully");
	}

	@DeleteMapping(path = "/emp/delete", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity delete(@RequestParam("id") int id) {

		if (repo.existsById(id)) {
			repo.deleteById(id);
			return ResponseEntity.ok("Emp deleted Successfully");
		} else {

			return ResponseEntity.ok("Emp not found ");
		}
	}
}
