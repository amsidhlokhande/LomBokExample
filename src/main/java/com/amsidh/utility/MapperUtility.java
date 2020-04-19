package com.amsidh.utility;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.amsidh.dto.AddressDto;
import com.amsidh.dto.PersonDto;
import com.amsidh.entity.AddressEntity;
import com.amsidh.entity.PersonEntity;

public class MapperUtility {

	public static PersonEntity getPersonEntity(PersonDto personDto) {

		PersonEntity personEntity = null;

		if (personDto != null) {
			personEntity = new PersonEntity();
			personEntity.setName(personDto.getName());
			personEntity.setDateOfBirth(personDto.getDateOfBirth());
			List<AddressEntity> collect = personDto.getAddress().stream()
					.map(new Function<AddressDto, AddressEntity>() {

						@Override
						public AddressEntity apply(AddressDto addressDto) {

							return new AddressEntity(addressDto.getCity(), addressDto.getState(),
									addressDto.getPinCode());
						}
					}).collect(Collectors.toList());
			personEntity.setAddress(collect);
		}
		return personEntity;
	}
}
