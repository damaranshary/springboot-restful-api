package com.prodemy.springbootrestfulapi.repository;

import com.prodemy.springbootrestfulapi.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {

}
