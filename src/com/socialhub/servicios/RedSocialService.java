package com.socialhub.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.socialhub.dao.RedSocialDAO;

@Service
public class RedSocialService {
	@Autowired
	private RedSocialDAO redSocialDAO;
 
	@Transactional
    public boolean isConnectedTo(String r){
    	List<String> redes = redSocialDAO.listSocialNetworks();
    	for(String s: redes){
    		if(s.equals(r))
    			return true;
    	}
    	return false;
    }
}
