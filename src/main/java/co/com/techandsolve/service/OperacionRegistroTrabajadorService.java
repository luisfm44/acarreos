package co.com.techandsolve.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import co.com.techandsolve.dao.ArchivoElementosDAO;
import co.com.techandsolve.model.RegistroUsuarioAcarreo;

@Service
public class OperacionRegistroTrabajadorService {

	@Autowired
	private RegistroUsuarioAcarreoService registroUsuarioAcarreoService;

	@Autowired
	private AcarreoService acarreoService;
	
	@Autowired
	private ArchivoElementosDAO archivoElementos;
	
	public String realizarOperacionRegistro(MultipartFile archivoAcarreos, Integer cedula) throws IOException {
		List<String> valores = archivoElementos.obtenerElementosArchivo(archivoAcarreos);
		List<String> validacion = archivoElementos.validarArchivo(valores);
		String mensaje = "";
		if(validacion.isEmpty()) {
			List<String> listaViajesPorDia = acarreoService.procesarViajesPorDia(valores);
			if(!listaViajesPorDia.isEmpty()) {
				archivoElementos.escribirArchivoFinal(listaViajesPorDia);
				registrarTrabajador(cedula,listaViajesPorDia);
			}
		}else {
			mensaje = validacion.stream().collect(Collectors.joining(","));
		}
		return mensaje;
		
		
	}
	
	private void registrarTrabajador(Integer cedula, List<String> listaViajesPorDia) {
		RegistroUsuarioAcarreo registro = new RegistroUsuarioAcarreo();
		registro.setCedula(cedula);
		registro.setFechaRegistro(LocalDateTime.now());
		registro.setNumeroViajes(listaViajesPorDia.stream().collect(Collectors.joining(",")));
		registroUsuarioAcarreoService.registrarTrabajador(registro);
	}
	
	
	public RegistroUsuarioAcarreoService getRegistroUsuarioAcarreoService() {
		return registroUsuarioAcarreoService;
	}

	public void setRegistroUsuarioAcarreoService(RegistroUsuarioAcarreoService registroUsuarioAcarreoService) {
		this.registroUsuarioAcarreoService = registroUsuarioAcarreoService;
	}

	public AcarreoService getAcarreoService() {
		return acarreoService;
	}

	public void setAcarreoService(AcarreoService acarreoService) {
		this.acarreoService = acarreoService;
	}
	
	public ArchivoElementosDAO getArchivoElementos() {
		return archivoElementos;
	}

	public void setArchivoElementos(ArchivoElementosDAO archivoElementos) {
		this.archivoElementos = archivoElementos;
	}
}
