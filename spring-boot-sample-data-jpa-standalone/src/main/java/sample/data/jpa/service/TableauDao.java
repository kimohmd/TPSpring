package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.domain.Tableau;

@Transactional
public interface TableauDao extends JpaRepository<Tableau, Long> {

}
