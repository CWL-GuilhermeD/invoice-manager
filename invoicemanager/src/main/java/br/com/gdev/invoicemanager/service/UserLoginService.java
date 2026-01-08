package br.com.gdev.invoicemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gdev.invoicemanager.model.UserModel;
import br.com.gdev.invoicemanager.repository.UserRepository;

@Service
public class UserLoginService implements UserDetailsService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = repository.findByLogin(username);
		
		if (user != null) {
			return user;
		}
		
		throw new UsernameNotFoundException("Usuario não encontrado");
	}
	
	
}
