package aluracursos.foro_hub.domain.topico.respuestas.validaciones;

import aluracursos.foro_hub.domain.topico.TopicoRepository;
import aluracursos.foro_hub.domain.topico.respuestas.DatosCrearRespuesta;
import aluracursos.foro_hub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoValido implements ValidadorRespuesta {

    @Autowired
    TopicoRepository topicoRepository;

    @Override
    public void validar(DatosCrearRespuesta datos) {
        if (datos.idTopico() == null || !topicoRepository.existsById(datos.idTopico())) {
            throw new ValidacionDeIntegridad("Topico no encontrado");
        }
    }
}
