package com.masai.service;

import com.masai.exception.FIRException;
import com.masai.model.FIR;

public interface FIRService {
	
	public FIR addFIR(FIR fir) throws FIRException;
	
}
