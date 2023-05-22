package com.laptrinhweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptrinhweb.entity.ContactEntity;

@Repository
public interface IContactRepository extends JpaRepository<ContactEntity, Integer> {

}
