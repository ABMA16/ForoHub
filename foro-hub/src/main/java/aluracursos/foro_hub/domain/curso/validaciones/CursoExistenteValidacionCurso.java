package aluracursos.foro_hub.domain.curso.validaciones;

import aluracursos.foro_hub.domain.curso.CursoRepository;
import aluracursos.foro_hub.domain.curso.DatosCrearCurso;
import aluracursos.foro_hub.infra.errores.ValidacionDeIntegridad;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CursoExistenteValidacionCurso implements ValidadorCurso{

    @Autowired
    CursoRepository repository;

    @Override
    public void validar(DatosCrearCurso datos) {
        if (repository.existsByNombre(datos.nombre())) {
            throw new ValidationException("Un curso con este nombre ya existe en la base de datos");
        }
        if (datos.nombre() == null) {
            throw new ValidacionDeIntegridad("El nombre del curso no puede quedar vacío");
        }
    }
}
