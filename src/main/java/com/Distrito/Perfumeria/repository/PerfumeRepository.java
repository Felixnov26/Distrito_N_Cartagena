package com.Distrito.Perfumeria.repository;

import com.Distrito.Perfumeria.model.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerfumeRepository extends JpaRepository<Perfume, Long> {
    List<Perfume> findByCategoriaNombre(String nombreCategoria);
    List<Perfume> findByDisponible(boolean disponible);
}