package com.amsidh.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amsidh.dto.PersonDto;
import com.amsidh.entity.PersonEntity;
import com.amsidh.jpa.repository.PersonRepository;

@Component
public class PersonService {

	private PersonRepository personRepository;

	@Autowired
	private ModelMapper mapper;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public PersonDto savePerson(PersonDto personDto) {
		PersonEntity personEntity = personRepository.save(getPersonEntity(personDto));
		return getPersonDto(personEntity);
	}

	public List<PersonEntity> saveAllPerson(List<PersonDto> personDtos) {
		return personRepository.saveAll(getPersonEntities(personDtos));
	}

	public List<PersonDto> getAllPersons() {
		return getPersonDtos(personRepository.findAll());
	}

	public PersonDto getPersonByPersonId(Integer personId) {
		return getPersonDto(personRepository.findById(personId).get());

	}

	private PersonEntity getPersonEntity(PersonDto personDto) {
		PersonEntity personEntity = mapper.map(personDto, PersonEntity.class);
		return personEntity;
	}

	private PersonDto getPersonDto(PersonEntity personEntity) {
		PersonDto personDto = mapper.map(personEntity, PersonDto.class);
		return personDto;
	}

	private List<PersonEntity> getPersonEntities(List<PersonDto> personDtos) {
		if (!personDtos.isEmpty())
			return personDtos.stream().map(personDto -> getPersonEntity(personDto)).collect(Collectors.toList());
		return null;
	}

	private List<PersonDto> getPersonDtos(List<PersonEntity> personEntities) {
		if (!personEntities.isEmpty())
			return personEntities.stream().map(personEntity -> getPersonDto(personEntity)).collect(Collectors.toList());
		return null;
	}

}
