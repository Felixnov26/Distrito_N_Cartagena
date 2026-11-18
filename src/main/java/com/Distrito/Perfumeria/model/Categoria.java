package com.Distrito.Perfumeria.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    @JsonManagedReference // <-- Controla el lado principal de la relación
    private List<Perfume> perfumes;

    // Constructores, Getters y Setters...
    public Categoria() {}
    public Categoria(String nombre) { this.nombre = nombre; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<Perfume> getPerfumes() { return perfumes; }
    public void setPerfumes(List<Perfume> perfumes) { this.perfumes = perfumes; }
}