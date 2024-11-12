package br.com.arq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.arq.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	public Users findByEmail(String email);
}
