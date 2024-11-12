package br.com.arq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.arq.model.Imoveis;

import java.util.List;

@Repository
public interface ImovelRepository extends JpaRepository<Imoveis, Integer> {

}
