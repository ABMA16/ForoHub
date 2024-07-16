package aluracursos.foro_hub.domain.topico.respuestas;

import aluracursos.foro_hub.domain.topico.DatosTopico;
import aluracursos.foro_hub.domain.topico.EstadoTopicoRespuesta;
import aluracursos.foro_hub.domain.topico.TopicoRepository;
import aluracursos.foro_hub.domain.topico.respuestas.validaciones.ValidadorRespuesta;
import aluracursos.foro_hub.domain.usuario.UsuarioRepository;
import aluracursos.foro_hub.infra.errores.ValidacionDeIntegridad;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository repository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private List<ValidadorRespuesta> validarRespuesta;

    public DatosRespuesta crearRespuesta(DatosCrearRespuesta datos) {
        validarRespuesta.forEach(v -> v.validar(datos));
        var mensaje = datos.mensaje();
        var autor = usuarioRepository.getReferenceById(datos.idAutor());
        var topico = topicoRepository.getReferenceById(datos.idTopico());
        var respuesta = new Respuesta(mensaje, autor, topico);
        repository.save(respuesta);
        return new DatosRespuesta(respuesta);
    }

    public DatosRespuesta editarRespuesta(DatosEditarRespuesta datos) {
        if (datos.mensaje() == null) {
            throw new ValidationException("La respuesta no fue encontrada.");
        }

        if (!repository.existsById(datos.idAutor())) {
            throw new ValidacionDeIntegridad("El ID de la respuesta no es válido.");
        }

        var respuesta = repository.getReferenceById(datos.idAutor());
        respuesta.actualizarMensaje(datos.mensaje());
        return new DatosRespuesta(respuesta);
    }

    public EstadoTopicoRespuesta marcarDesmarcarComoSolucion(Long id) {
        idValido(id);
        var respuesta = repository.getReferenceById(id);
        var topico = topicoRepository.getReferenceById(respuesta.getTopico().getId());
        respuesta.setSolucion();
        var resuelto = repository.existsByTopicoAndSolucion(topico, true);
        System.out.println(resuelto);
        if ((resuelto && topico.getStatus() == false) || (!resuelto && topico.getStatus() == true)) {
            topico.setStatus();
        }

        var resultado = new EstadoTopicoRespuesta(new DatosTopico(topico), new DatosRespuesta(respuesta));
        return resultado;
    }

    public void eliminarRespuesta(Long id) {
        idValido(id);
        var idTopicoRespuesta = repository.getReferenceById(id).getTopico().getId();
        var topico = topicoRepository.getReferenceById(idTopicoRespuesta);

        repository.deleteById(id);

        var topicoResuelto = repository.existsByTopicoAndSolucion(topico, true);
        var estadoTopico = topico.getStatus();
        if (estadoTopico && !topicoResuelto) {
            topico.setStatus();
        }
    }

    private void idValido(Long id) {
        if(id == null) {
            throw new ValidationException("ID de respuesta faltante.");
        }

        if(!repository.existsById(id)) {
            throw new ValidacionDeIntegridad("No existe respuesta con id: " + id);
        }
    }
}
