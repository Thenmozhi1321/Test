package com.springboot.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.healthcare.model.Test;

@Repository
public interface TestRepository extends JpaRepository<Test,Long>{

}