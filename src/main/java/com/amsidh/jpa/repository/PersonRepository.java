package com.amsidh.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amsidh.entity.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

}
