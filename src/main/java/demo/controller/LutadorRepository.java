package demo.controller;

import demo.model.Lutador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LutadorRepository extends JpaRepository<Lutador, Integer> {
}