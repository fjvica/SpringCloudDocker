package org.springcloud.msvc.cursos.msvc.cursos.serviceImpl;

import org.springcloud.msvc.cursos.msvc.cursos.entity.CursoEntity;
import org.springcloud.msvc.cursos.msvc.cursos.repositories.CursoRepository;
import org.springcloud.msvc.cursos.msvc.cursos.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<CursoEntity> listar() {
        return (List<CursoEntity>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CursoEntity> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public CursoEntity guardar(CursoEntity curso) {
        return repository.save(curso);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
