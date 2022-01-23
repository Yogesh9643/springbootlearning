package com.firstproject.learningms.repository;

import com.firstproject.learningms.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRepo extends JpaRepository<Books,Integer> {

}
