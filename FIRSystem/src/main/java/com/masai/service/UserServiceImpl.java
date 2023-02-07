package com.masai.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.FIRException;
import com.masai.exception.UserException;
import com.masai.model.FIR;
import com.masai.model.User;
import com.masai.repository.FIRRepo;
import com.masai.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo ur;
	
	@Autowired
	private FIRRepo fr;
	
	@Override
	public User addUser(User user) throws UserException {
		User u=ur.save(user);
		if(u!=null)
			return u;
		else 
			throw new UserException("User cannot be saved");
	}

	@Override
	public List<FIR> getAllFIR(Integer userid) throws FIRException, UserException {
		
		User u=ur.findById(userid).get();
		
		List<FIR> li=u.getLiFIR();
		
		if(li.size() != 0) return li;
		
		throw new FIRException("No fir registerd yet");
		
	}

	@Override
	public FIR deleteFIR(Integer firId,Integer userid) throws FIRException, UserException {
		User user = ur.findById(userid).get();
		
		List<FIR> FirList = user.getLiFIR();
		
		FIR newFir = fr.findById(firId).get();
		
		for(int i=0; i<FirList.size(); i++) {
			
			if(FirList.get(i).getFirId() == firId) {
				
				long time = Duration.between(FirList.get(i).getTimeStamp(),LocalDateTime.now()).toHours();
				
				int val = (int) time;
				
				if(val <= 24) {
					
					fr.delete(newFir);
					return newFir;
				}
				
			}

		}
		
		
		throw new FIRException("No FIR found with this id");
	}

}
