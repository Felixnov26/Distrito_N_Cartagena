package com.Distrito.Perfumeria.controller;

import com.Distrito.Perfumeria.model.Perfume;
import com.Distrito.Perfumeria.service.PerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfumes")
@CrossOrigin(origins = "*")
public class PerfumeController {

    @Autowired
    private PerfumeService perfumeService;

    // 1. Listar todos los perfumes (Público)
    @GetMapping
    public List<Perfume> listarTodos() {
        return perfumeService.obtenerTodos();
    }

    // 2. Buscar perfume por ID (Público)
    @GetMapping("/{id}")
    public ResponseEntity<Perfume> obtenerPorId(@PathVariable Long id) {
        return perfumeService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. Filtrar perfumes por categoría (Ej: /api/perfumes/categoria/Hombre) (Público)
    @GetMapping("/categoria/{nombreCategoria}")
    public List<Perfume> listarPorCategoria(@PathVariable String nombreCategoria) {
        return perfumeService.obtenerPorCategoria(nombreCategoria);
    }

    // 4. Filtrar por disponibilidad true/false (Público)
    @GetMapping("/disponibilidad/{disponible}")
    public List<Perfume> listarPorDisponibilidad(@PathVariable boolean disponible) {
        return perfumeService.obtenerPorDisponibilidad(disponible);
    }

    // 5. Crear un nuevo perfume (Protegido - Requiere Admin)
    @PostMapping
    public Perfume crearPerfume(@RequestBody Perfume perfume) {
        return perfumeService.guardarPerfume(perfume);
    }
}