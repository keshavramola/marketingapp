package com.marketingapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp.entities.Lead;
import com.marketingapp.repository.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadRepo;
	
	@Override
	public void saveLead(Lead lead) {
       	leadRepo.save(lead);	
	}

	@Override
	public List<Lead> findAllLeads() {
        List<Lead> leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public void deleteLead(long id) {
        leadRepo.deleteById(id);		
	}

	@Override
	public Lead updateLead(long id) {
        Optional<Lead> findById = leadRepo.findById(id);
        Lead lead = findById.get();
		return lead;
	}

}
