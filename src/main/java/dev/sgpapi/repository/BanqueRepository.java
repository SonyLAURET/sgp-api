package dev.sgpapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sgpapi.entite.Banque;

public interface BanqueRepository extends JpaRepository<Banque, Integer> {

}
