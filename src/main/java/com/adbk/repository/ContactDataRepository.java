package com.adbk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adbk.model.Contact;

@Repository
public interface ContactDataRepository extends JpaRepository<Contact, Long> {

}
