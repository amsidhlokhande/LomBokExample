package com.amsidh.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amsidh.dto.AddressDto;
import com.amsidh.dto.PersonDto;
import com.amsidh.service.PersonService;

@RestController
@RequestMapping("person")
public class PersonController {

	private static final List<PersonDto> persons = new ArrayList<>();

	static {
		PersonDto p = new PersonDto();
		p.setName("Amisdh");
		p.setDateOfBirth(new Date());
		AddressDto address1 = new AddressDto("Pune", "MH", 412105L);
		AddressDto address2 = new AddressDto("Karad", "MH", 416412L);
		AddressDto address3 = new AddressDto("Shirnal", "KA", 586119L);
		p.getAddress().add(address1);
		p.getAddress().add(address2);
		p.getAddress().add(address3);

		persons.add(p);
	}

	private PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
		personService.saveAllPerson(persons);
		//personService.savePerson(persons.get(0));
	}

	@RequestMapping(value = { "/savePerson" }, method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<String> savePerson(@RequestBody PersonDto personDto) {

		PersonDto savedPerson = personService.savePerson(personDto);
		return new ResponseEntity<String>("personId :" + savedPerson.getPersonId(), HttpStatus.OK);
	}

	@RequestMapping(value = { "/persons" }, method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<List<PersonDto>> getAllPerson() {

		return new ResponseEntity<List<PersonDto>>(personService.getAllPersons(), HttpStatus.OK);
	}

}
