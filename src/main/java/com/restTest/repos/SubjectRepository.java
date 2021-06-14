package com.restTest.repos;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.restTest.model.Subject;

/**
 * Repository for handling CRUD calls on database.
 * @author ian
 *
 */
@RepositoryRestResource(collectionResourceRel = "subjects", path = "subjects")
public interface SubjectRepository extends CrudRepository<Subject, UUID> {
	
}

