package co.com.techandsolve.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.techandsolve.model.RegistroUsuarioAcarreo;
import co.com.techandsolve.repository.RegistroUsuarioAcarreoRepository;

@Service
public class RegistroUsuarioAcarreoService {

	@Autowired
	private RegistroUsuarioAcarreoRepository usuarioRepository;

	public RegistroUsuarioAcarreo registrarTrabajador(RegistroUsuarioAcarreo registro) {

		return usuarioRepository.save(registro);

	}

	public RegistroUsuarioAcarreoRepository getUsuarioRepository() {
		return usuarioRepository;
	}


	public void setUsuarioRepository(RegistroUsuarioAcarreoRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

}
