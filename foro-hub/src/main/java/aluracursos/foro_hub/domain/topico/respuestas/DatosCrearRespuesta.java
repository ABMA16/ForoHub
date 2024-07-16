package aluracursos.foro_hub.domain.topico.respuestas;

public record DatosCrearRespuesta(
        String mensaje,
        Long idTopico,
        Long idAutor) {
}
