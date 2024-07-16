package aluracursos.foro_hub.domain.curso;

import aluracursos.foro_hub.domain.topico.DatosTopico;
import org.springframework.data.domain.Page;

public record DatosCursoTopicos(DatosCurso curso, Page<DatosTopico> topicos) {

}
