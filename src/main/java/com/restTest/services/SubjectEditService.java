package com.restTest.services;

import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restTest.model.Subject;
import com.restTest.repos.SubjectRepository;
import com.restTest.transfer.SubjectCreateTransferObject;
import com.restTest.transfer.SubjectEditTransferObject;
import com.restTest.transfer.SubjectQueryTransferObject;

/**
 * Service for editing/creating subjects.
 * @author ian
 *
 */
@Service
public class SubjectEditService implements ISubjectEditService{
	
	 @Autowired
	 private SubjectRepository subjRepository;

	 /**
	  * Should create the a new subject based on the input information.
	  * @param subjCreateTransferObj the object holding information on the to-be created subject
	  * @return the ID of the newly created subject.
	  */
	@Override
	public UUID createSubject(SubjectCreateTransferObject subjCreateTransferObj) {
		Subject createdSubject = new Subject();
		
		createdSubject.setId(UUID.randomUUID());
		createdSubject.setName(subjCreateTransferObj.getName());
		createdSubject.setAge(subjCreateTransferObj.getAge());
		createdSubject.setSex(subjCreateTransferObj.getSex());
		createdSubject.setOccupation(subjCreateTransferObj.getOccupation());

        return subjRepository.save(createdSubject).getid();
	}

	/**
	 * Should edit the subject based on the information sent in through the edit transfer object.
	 * @param id the ID of the to-be edited Subject.
	 * @param subjEditTransferObj the transfer object which houses all of the information on the changes to be made to the Subject.
	 * @return information on the Subject after the changes
	 */
	@Override
	public SubjectQueryTransferObject updateSubject(UUID id, SubjectEditTransferObject subjEditTransferObj) {
		if (subjRepository.findById(id).isPresent())
		{
			Subject foundSubj = subjRepository.findById(id).get();

			foundSubj.setAge(subjEditTransferObj.getAge());
			foundSubj.setSex(subjEditTransferObj.getSex());
			foundSubj.setOccupation(subjEditTransferObj.getOccupation());

			Subject updatedSubject = subjRepository.save(foundSubj);

            return new SubjectQueryTransferObject(updatedSubject.getid(), updatedSubject.getName(),
            		updatedSubject.getAge(), updatedSubject.getSex(), updatedSubject.getOccupation());
        }
		else
		{
            throw new EntityNotFoundException("A subject with the id: " + id + " does not exist within the database.");
        }
	}

}
