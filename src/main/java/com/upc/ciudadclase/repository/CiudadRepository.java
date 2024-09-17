package com.upc.ciudadclase.repository;

import com.upc.ciudadclase.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
    List<Ciudad> findAllByDepartamento(String dpto);

    @Query(value = "SELECT departamento, SUM(habitantes) as habitantes FROM ciudad GROUP BY departamento", nativeQuery = true)
    List<Object[]> getHabitantesByDepartamento();
}

