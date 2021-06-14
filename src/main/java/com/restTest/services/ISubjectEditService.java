package com.restTest.services;

import java.util.UUID;

import com.restTest.transfer.SubjectCreateTransferObject;
import com.restTest.transfer.SubjectEditTransferObject;
import com.restTest.transfer.SubjectQueryTransferObject;

/** 
 * Interface for editing subjects.
 * @author ian
 *
 */
public interface ISubjectEditService {
    public UUID createSubject(SubjectCreateTransferObject subjEditTransferObj);
    public SubjectQueryTransferObject updateSubject(UUID id, SubjectEditTransferObject subjEditTransferObj);
}
