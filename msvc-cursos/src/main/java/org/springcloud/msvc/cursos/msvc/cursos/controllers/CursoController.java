package org.springcloud.msvc.cursos.msvc.cursos.controllers;

import org.springcloud.msvc.cursos.msvc.cursos.entity.CursoEntity;
import org.springcloud.msvc.cursos.msvc.cursos.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CursoController {

    @Autowired
    private CursoService service;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<CursoEntity> cursoEntity = service.porId(id);

        if(cursoEntity.isPresent()){
            return ResponseEntity.ok(cursoEntity.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody CursoEntity curso){

        CursoEntity cursoDb = service.guardar(curso);

        return ResponseEntity.status(HttpStatus.CREATED).body(cursoDb);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody CursoEntity curso, @PathVariable Long id){
        Optional<CursoEntity> o = service.porId(id);

        if(o.isPresent()){
            CursoEntity cursoDB = o.get();
            cursoDB.setNombre(curso.getNombre());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(cursoDB));
        }
        return ResponseEntity.notFound().build();

     }


     @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<CursoEntity> o = service.porId(id);
        if(o.isPresent()){
            service.eliminar(id);
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
     }
}
