package com.Distrito.Perfumeria.service;

import com.Distrito.Perfumeria.model.Perfume;
import com.Distrito.Perfumeria.repository.PerfumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfumeService {

    @Autowired
    private PerfumeRepository perfumeRepository;

    public List<Perfume> obtenerTodos() {
        return perfumeRepository.findAll();
    }

    public Optional<Perfume> obtenerPorId(Long id) {
        return perfumeRepository.findById(id);
    }

    public List<Perfume> obtenerPorCategoria(String nombreCategoria) {
        return perfumeRepository.findByCategoriaNombre(nombreCategoria);
    }

    public List<Perfume> obtenerPorDisponibilidad(boolean disponible) {
        return perfumeRepository.findByDisponible(disponible);
    }

    public Perfume guardarPerfume(Perfume perfume) {
        return perfumeRepository.save(perfume);
    }
}