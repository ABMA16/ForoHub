package aluracursos.foro_hub.domain.topico.validaciones;

import aluracursos.foro_hub.domain.curso.CursoRepository;
import aluracursos.foro_hub.domain.topico.DatosCrearTopico;
import aluracursos.foro_hub.infra.errores.ValidacionDeIntegridad;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CursoExistente implements ValidadorTopico{

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void validar(DatosCrearTopico datos) {
        if (datos.idCurso() == null) {
            throw new ValidacionDeIntegridad("El topico debe tener un curso asignado");
        }

        var curso = cursoRepository.findById(datos.idCurso());

        if (!curso.isPresent()) {
            throw new ValidationException("El curso no existe.");
        }
    }
}
