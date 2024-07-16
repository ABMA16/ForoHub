package aluracursos.foro_hub.domain.topico.respuestas.validaciones;

import aluracursos.foro_hub.domain.topico.respuestas.DatosCrearRespuesta;
import aluracursos.foro_hub.domain.usuario.UsuarioRepository;
import aluracursos.foro_hub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutorValido implements ValidadorRespuesta {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void validar(DatosCrearRespuesta datos) {
        if (datos.idAutor() == null || !usuarioRepository.existsById(datos.idAutor())) {
            throw new ValidacionDeIntegridad("Autor no encontrado");
        }
    }
}
