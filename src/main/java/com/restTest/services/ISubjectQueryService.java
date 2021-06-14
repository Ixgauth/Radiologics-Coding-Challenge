package com.restTest.services;

import java.util.List;
import java.util.UUID;

import com.restTest.transfer.SubjectQueryTransferObject;

/** 
 * Interface for querying subjects already created and stored.
 * @author ian
 *
 */
public interface ISubjectQueryService {
	List<SubjectQueryTransferObject> findAll();
    SubjectQueryTransferObject findById(UUID id);
}
