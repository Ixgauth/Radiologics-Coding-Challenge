package com.restTest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restTest.model.Subject;
import com.restTest.repos.SubjectRepository;
import com.restTest.transfer.SubjectQueryTransferObject;

/**
 * Service for querying the database for subject data.
 * @author ian
 *
 */
@Service
public class SubjectQueryService implements ISubjectQueryService{
	
	@Autowired
	private SubjectRepository subjectRepo;
	

	/**
	 * Should find all of the currently available subjects and return them.
	 * @return A list of all of the Subjects in transfer object form.
	 */
	@Override
	public List<SubjectQueryTransferObject> findAll() {
		List<SubjectQueryTransferObject> subjList = new ArrayList<>();
        
		Iterable<Subject> subjects = subjectRepo.findAll();
		
		for (Subject s : subjects) 
		{
			subjList.add(new SubjectQueryTransferObject(s.getid(), s.getName(), s.getAge(), s.getSex(), s.getOccupation()));
		}
		
		if (subjList.size() > 0) 
		{
			return subjList;
		}
		else 
		{
			throw new EntityNotFoundException("There are currently no subjects within the database.");
		}
        
	}

	/**
	 * Should find the specific Subject being requested via its ID.
	 * @param the ID of the sought Subject.
	 * @return the transfer object for the Subject itself. If found.
	 */
	@Override
	public SubjectQueryTransferObject findById(UUID id) {
		if (subjectRepo.findById(id).isPresent()){
            Subject subj = subjectRepo.findById(id).get();
            return new SubjectQueryTransferObject(subj.getid(), subj.getName(), subj.getAge(), subj.getSex(), subj.getOccupation());
        }else{
            throw new EntityNotFoundException("A subject with the id: " + id + " does not exist within the database.");
        }
	}

}
