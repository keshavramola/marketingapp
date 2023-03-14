package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.dto.LeadDto;
import com.marketingapp.entities.Lead;
import com.marketingapp.services.LeadService;
import com.marketingapp.util.EmailService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailService emailService;
	
	// localhost:8080/viewCreateLead
	
	@RequestMapping("/viewCreateLead")
	public String viewCreateLeadForm() {
		return "create_registration";
	}
	
//	@RequestMapping("/saveLead")
//	public String saveOneLead(Lead lead , ModelMap model) {
//		leadService.saveLead(lead);
//		model.addAttribute("msg", "record is saved!!");
//		return "create_registration";
//	}
	
//	@RequestMapping("/saveLead")
//	public String saveOneLead(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email, @RequestParam("mobile") long mobile ) {
//        Lead l = new Lead();
//        l.setEmail(email);
//        l.setFirstName(firstName);
//        l.setLastName(lastName);
//        l.setMobile(mobile);
//        leadService.saveLead(l);
//		return "create_registration";
//	}
	
	@RequestMapping("/saveLead")
	public String saveOneLead(LeadDto leadDto , ModelMap model) {
        Lead l = new Lead();
        l.setEmail(leadDto.getEmail());
        l.setFirstName(leadDto.getFirstName());
        l.setLastName(leadDto.getLastName());
        l.setMobile(leadDto.getMobile());
        
        emailService.sendEmail(leadDto.getEmail(), "Test", "You Ok there!!");
        
        leadService.saveLead(l);
        
		model.addAttribute("msg", "record is saved!!");
		return "create_registration";
	}
	
	// localhost:8080/listleads
	
	@RequestMapping("/listleads")
	public String getAllLeads(Model model) {
		List<Lead> leads = leadService.findAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	
	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id") long id , Model model) {
		leadService.deleteLead(id);
		List<Lead> leads = leadService.findAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	
	@RequestMapping("/update")
	public String updateOneLead(@RequestParam("id") long id , Model model) {
		Lead lead = leadService.updateLead(id); 
		model.addAttribute("lead", lead);
		return "update_leads";
	}
	
	@RequestMapping("/updateLead")
	public String updateOneLead(Lead lead , ModelMap model) {
		leadService.saveLead(lead);
		
		List<Lead> leads = leadService.findAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}
}
