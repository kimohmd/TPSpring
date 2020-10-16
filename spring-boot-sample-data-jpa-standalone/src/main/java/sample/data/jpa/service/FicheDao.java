package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.domain.Fiche;
@Transactional
public interface FicheDao extends JpaRepository<Fiche, Long>{

}