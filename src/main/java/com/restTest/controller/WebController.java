package com.restTest.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.restTest.model.Subject;
import com.restTest.repos.SubjectRepository;
import com.restTest.services.ISubjectEditService;
import com.restTest.transfer.SubjectCreateTransferObject;

/**
 * Controller which connects to html web front end. Should handle users when the home page is loaded and should update the page when a new user is called for.
 * @author ian
 *
 */
@Controller
public class WebController {
	
	@Autowired
	SubjectRepository repo;
	
	@Autowired
	private ISubjectEditService editService;
	
	/**
	 * Method for opening the home page of the model and loading the index.html file.
	 * @param model Will hold the subject information to be sent to html front end.
	 * @return String to call for the opening of index.html
	 */
	@GetMapping("/")
	public String loginPage(Model model)
	{
		return "index";  
	}
	
	@GetMapping("/loginSuccess")
	public String homePage(Model model) {
		List<Subject> subj=(List<Subject>) repo.findAll();
		model.addAttribute("subjlist", subj); 
		return "loginSuccess";
	}
	
	/**
	 * Method for opening the form for creating a new user.
	 * @param model Will hold information on the subject transfer object.
	 * @return String to call for the opening of addSubject.html
	 */
	@GetMapping("/open_new")
	public String openNewSubjectPage(Model model)
	{
		SubjectCreateTransferObject subj= new SubjectCreateTransferObject();
		model.addAttribute("subject", subj);
		return "addSubject";
	}
	
	/**
	 * Method for returning the information entered for a new Subject.
	 * @param subjTO the transfer object for the new subject.
	 * @return Should redirect to index.html
	 */
	@PostMapping(value="add_subj")
	public String addemployee(SubjectCreateTransferObject subjTO)
	{
		editService.createSubject(subjTO);
		return "redirect:/";
	}
}
