package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.domain.Utilisateur;
@Transactional
public interface UtilisateurDao extends JpaRepository<Utilisateur, Long>{

}