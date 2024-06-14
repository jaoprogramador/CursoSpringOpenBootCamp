package com.jao.spring.security.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jao.spring.domain.Alumno;
import com.jao.spring.repository.AlumnoRepository;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Transactional(readOnly = true)
    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Alumno getAlumnoById(Long id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    @Transactional
    public Alumno createAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Transactional
    public Alumno updateAlumno(Long id, Alumno alumno) {
        if (alumnoRepository.existsById(id)) {
            alumno.setId(id);
            return alumnoRepository.save(alumno);
        }
        return null;
    }

    @Transactional
    public void deleteAlumno(Long id) {
        alumnoRepository.deleteById(id);
    }
}
