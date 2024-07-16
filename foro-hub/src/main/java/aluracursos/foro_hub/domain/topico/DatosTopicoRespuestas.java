package aluracursos.foro_hub.domain.topico;

import aluracursos.foro_hub.domain.topico.respuestas.DatosRespuesta;
import org.springframework.data.domain.Page;

public record DatosTopicoRespuestas(DatosTopico topico, Page<DatosRespuesta> respuestas) {
}
