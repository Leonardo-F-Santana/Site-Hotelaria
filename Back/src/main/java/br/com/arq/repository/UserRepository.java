// Source code is decompiled from a .class file using FernFlower decompiler.
package br.com.arq.repository;

import br.com.arq.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
   Users findByEmail(String email);
}
