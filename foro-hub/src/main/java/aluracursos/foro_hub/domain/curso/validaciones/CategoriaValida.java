package aluracursos.foro_hub.domain.curso.validaciones;

import aluracursos.foro_hub.domain.curso.DatosCrearCurso;
import aluracursos.foro_hub.infra.errores.ValidacionDeIntegridad;
import org.springframework.stereotype.Component;

@Component
public class CategoriaValida implements ValidadorCurso{

    @Override
    public void validar(DatosCrearCurso datos) {
        if (datos.categoria() == null) {
            throw new ValidacionDeIntegridad("El curso debe tener una categoría.");
        }
    }
}
