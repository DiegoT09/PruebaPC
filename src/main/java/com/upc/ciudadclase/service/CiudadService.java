package com.upc.ciudadclase.service;

import com.upc.ciudadclase.dto.Cantidad;
import com.upc.ciudadclase.dto.CiudadDTO;
import com.upc.ciudadclase.model.Ciudad;
import com.upc.ciudadclase.repository.CiudadRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CiudadService {
    final CiudadRepository ciudadRepository;

    public CiudadService(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }
    public List<Ciudad> findAll() {
        return ciudadRepository.findAll();
    }

    public Ciudad findById(Long id) {
        Optional<Ciudad> ciudad = ciudadRepository.findById(id);
        if(ciudad.isPresent()) {
            return ciudad.get();
        }
        return null;
    }

    //lista por Departamento
    public List<Ciudad> ListaPorDepto(String dpto) {
        return ciudadRepository.findAllByDepartamento(dpto);
    }

    //Lista Habitantes por Departamento
    public List<Cantidad> listaHabitantes(){
        List<Object[]> arreglo = ciudadRepository.getHabitantesByDepartamento();
        List<Cantidad> listaCantidad = new ArrayList<>();
        Cantidad canti = new Cantidad();
        for (var i=0; i<arreglo.size(); i++) {
            canti = new Cantidad(arreglo.get(i)[0].toString(), (long) arreglo.get(i)[1]);
            listaCantidad.add(canti);
        }
        return listaCantidad;
    }

    public Ciudad save(CiudadDTO ciudadDto) {
        Ciudad ciudad = new Ciudad(
                ciudadDto.getNombre(),
                ciudadDto.getDepartamento(),
                ciudadDto.getHabitantes());
        return ciudadRepository.save(ciudad);

    }

    public Ciudad update(Long id, CiudadDTO ciudadDto) { // revisar el Object enves de Ciudad
        Optional<Ciudad> ciudad = ciudadRepository.findById(id);
        if(ciudad.isPresent()) {
            ciudad.get().setNombre(ciudadDto.getNombre());
            ciudad.get().setDepartamento(ciudadDto.getDepartamento());
            ciudad.get().setHabitantes(ciudadDto.getHabitantes());
            return ciudadRepository.save(ciudad.get());
        }return null;
    }

    public void delete(Long id) {
        ciudadRepository.deleteById(id);
    }

}
