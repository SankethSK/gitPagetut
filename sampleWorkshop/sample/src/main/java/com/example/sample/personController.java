package com.example.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/people")
public class personController {
	@Autowired
	private personRepo personRepo;
	
	@GetMapping
	public List<Person> getAllPeople(){
		return personRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Person getPersonById(@PathVariable String id) {
	    return (Person) personRepo.findById(id).orElse(null);
	}

	
	@PostMapping
	public Person addPerson(@RequestBody Person person) {
		return (Person) personRepo.save(person);
	}
	

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable String id, @RequestBody Person updatedPerson) {
        updatedPerson.setId(id);
        return (Person) personRepo.save(updatedPerson);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable String id) {
        personRepo.deleteById(id);
    }
}