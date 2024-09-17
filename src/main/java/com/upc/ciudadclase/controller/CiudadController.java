package com.upc.ciudadclase.controller;

import com.upc.ciudadclase.dto.Cantidad;
import com.upc.ciudadclase.dto.CiudadDTO;
import com.upc.ciudadclase.model.Ciudad;
import com.upc.ciudadclase.service.CiudadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class  CiudadController {
    final CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @GetMapping()
    public ResponseEntity<List<Ciudad>> findAll() {
        return new ResponseEntity<List<Ciudad>>(ciudadService.findAll(), HttpStatus.OK);

    }
    //Lista por Dpto
    @GetMapping("/dpto")
    public ResponseEntity<List<Ciudad>> listaPorDpto (String dpto){
        return new ResponseEntity<List<Ciudad>>(ciudadService.ListaPorDepto(dpto), HttpStatus.OK);
    }

    //Lista Habitantes por Dpto
    @GetMapping("/habitantes")
    public ResponseEntity<List<Cantidad>> listaHabitantes(){
        return new ResponseEntity<>(ciudadService.listaHabitantes(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Ciudad> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ciudadService.findById(id));
    }
    @PostMapping()
    public ResponseEntity<Ciudad> save(@RequestBody CiudadDTO ciudadDto) {  //<Ciudad>
        return new ResponseEntity<>(ciudadService.save(ciudadDto), HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<Ciudad> update(@PathVariable Long id, @RequestBody CiudadDTO ciudadDto) {
        Ciudad ciudad = ciudadService.findById(id);
        if (ciudad != null) {
            return ResponseEntity.ok(ciudadService.update(id, ciudadDto));
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Ciudad> delete(@PathVariable Long id) {
        Ciudad ciudad = ciudadService.findById(id);
        if (ciudad != null) {
            ciudadService.delete(id);
            return ResponseEntity.ok(ciudad);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
