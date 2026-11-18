package com.Distrito.Perfumeria.config;

import com.Distrito.Perfumeria.model.Categoria;
import com.Distrito.Perfumeria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Bean
    public CommandLineRunner initData() {
        return args -> {
            // Definimos las 4 categorías principales de tu perfumería
            List<String> nombresCategorias = List.of("Hombre", "Damas", "Unisex", "Árabe");

            for (String nombre : nombresCategorias) {
                // Verificamos si la categoría ya existe para evitar duplicados al reiniciar la app
                boolean existe = categoriaRepository.findAll().stream()
                        .anyMatch(c -> c.getNombre().equalsIgnoreCase(nombre));

                if (!existe) {
                    Categoria categoria = new Categoria();
                    categoria.setNombre(nombre);
                    categoriaRepository.save(categoria);
                    System.out.println("Categoría creada automáticamente: " + nombre);
                }
            }
        };
    }
}