package br.com.gdev.invoicemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gdev.invoicemanager.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
	
	 UserModel findByLogin(String login);
}
