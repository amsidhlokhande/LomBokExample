package com.amsidh.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.amsidh.entity.PersonEntity;

@ComponentScan(basePackages = { "com.amsidh" })
@EnableJpaRepositories(basePackages = { "com.amsidh.jpa.repository" })
@EntityScan(basePackageClasses= {PersonEntity.class})
@Configuration
public class PersonConfig {

}
