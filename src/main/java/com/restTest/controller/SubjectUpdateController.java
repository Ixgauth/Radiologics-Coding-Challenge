package com.restTest.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.restTest.services.ISubjectEditService;
import com.restTest.transfer.SubjectCreateTransferObject;
import com.restTest.transfer.SubjectEditTransferObject;
import com.restTest.transfer.SubjectQueryTransferObject;

/**
 * Controller used to handle creating or updating of subjects.
 * @author ian
 *
 */
@RestController
@RequestMapping(value = "api/subjects")
public class SubjectUpdateController {

	@Autowired
	private ISubjectEditService editService;
	
	/**
	 * Should be called to add a new subject into the system.
	 * @param subjectCreateTransferObj transfer object housing the information on the to-be created Subject.
	 * @return the subject UUID and HTTP status that the object has been created
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UUID> createSubject(@Valid @RequestBody SubjectCreateTransferObject subjectCreateTransferObj)
	{
	    return new ResponseEntity<>(editService.createSubject(subjectCreateTransferObj), HttpStatus.CREATED);
	}
	
	/**
	 * Called in order to edit one of the subjects currently in the system.
	 * @param id the id of the subject to be edited
	 * @param subjectEditTransferObj transfer object housing information on how to change the current subject
	 * @return the subjects information as well as an HTTP ok.
	 */
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<SubjectQueryTransferObject> updateSubject(@PathVariable(value = "id") UUID id, @Valid @RequestBody SubjectEditTransferObject subjectEditTransferObj)
	{
	    return new ResponseEntity<>(editService.updateSubject(id, subjectEditTransferObj), HttpStatus.OK);
	}
}
