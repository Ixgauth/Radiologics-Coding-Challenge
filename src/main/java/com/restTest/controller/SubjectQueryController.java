package com.restTest.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.restTest.services.ISubjectQueryService;
import com.restTest.transfer.SubjectQueryTransferObject;

/** 
 * Controller used for querying the database. Should allow for REST calls for either the whole database or a single subject.
 * @author ian
 *
 */
@RestController
@RequestMapping(value = "/api/subjects")
public class SubjectQueryController {
	
	@Autowired
	private ISubjectQueryService queryService;
	
	/**
	 * Should query the database for all of the subjects currently input in the system.
	 * @return all of the subjects along with an OK response.
	 */
	@GetMapping
    @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<SubjectQueryTransferObject>> findAllSubjects() 
	{
		return new ResponseEntity<>(queryService.findAll(), HttpStatus.OK);
	}
	
	/**
	 * Should query the database for a single subject based on the input ID.
	 * @param id the ID of the subject to be queried
	 * @return The subject related to that ID.
	 */
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SubjectQueryTransferObject> getVehicle(@PathVariable(value = "id") UUID id){
        return new ResponseEntity<>(queryService.findById(id), HttpStatus.OK);
    }

}
