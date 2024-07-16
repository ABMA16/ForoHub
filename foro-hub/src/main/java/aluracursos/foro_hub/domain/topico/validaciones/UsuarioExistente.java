package aluracursos.foro_hub.domain.topico.validaciones;

import aluracursos.foro_hub.domain.topico.DatosCrearTopico;
import aluracursos.foro_hub.domain.usuario.UsuarioRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioExistente implements ValidadorTopico{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void validar(DatosCrearTopico datos) {
        var usuario = usuarioRepository.existsById(datos.idAutor());

        if (!usuario) {
            new ValidationException("El autor no ha sido registrado.");
        }

    }
}
