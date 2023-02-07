package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.FIRException;
import com.masai.model.FIR;
import com.masai.repository.FIRRepo;

@Service
public class FIRServiceImpl implements FIRService {
	
	@Autowired
	private FIRRepo fr;
	
	@Override
	public FIR addFIR(FIR fir) throws FIRException {
		FIR f=fr.save(fir);
		if(f!=null)
			return f;
		else 
			throw new FIRException("FIR cannot be saved");
	}

}
