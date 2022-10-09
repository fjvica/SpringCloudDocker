package org.springcloud.msvc.cursos.msvc.cursos.service;

import org.springcloud.msvc.cursos.msvc.cursos.entity.CursoEntity;

import java.util.List;
import java.util.Optional;

public interface CursoService {

    List<CursoEntity> listar();

    Optional<CursoEntity> porId(Long id);

    CursoEntity guardar(CursoEntity curso);

    void eliminar(Long id);
}
