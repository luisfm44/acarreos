package co.com.techandsolve.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.com.techandsolve.constants.Constantes;
import co.com.techandsolve.dto.RespuestaCargaDTO;
import co.com.techandsolve.service.OperacionRegistroTrabajadorService;



@RestController
@RequestMapping("/error")
public class AcarreoApi {

	

	
	@Autowired
	@Qualifier("operacionTrabajoService")
	private OperacionRegistroTrabajadorService operacionRegistro;
	
	@PostMapping(path = "/acarreo", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*",methods= {RequestMethod.GET,RequestMethod.POST})
    public ResponseEntity<RespuestaCargaDTO> uploadFile(@RequestPart("acarreo_file") MultipartFile archivoAcarreos,
                                                                 @RequestPart("acarreo_cedula") String cedula) throws NumberFormatException, IOException {
        RespuestaCargaDTO respuestaDTO;
        
        	respuestaDTO = operacionRegistro.realizarOperacionRegistro(archivoAcarreos, Integer.parseInt(cedula));
        	respuestaDTO.setMensaje(String.format(Constantes.ARCHIVO_PROCESADO_EXITOSAMENTE,
        			archivoAcarreos.getOriginalFilename()));

            return ResponseEntity.status(HttpStatus.OK).body(respuestaDTO);
       
    }

	public OperacionRegistroTrabajadorService getOperacionRegistro() {
		return operacionRegistro;
	}

	public void setOperacionRegistro(OperacionRegistroTrabajadorService operacionRegistro) {
		this.operacionRegistro = operacionRegistro;
	}

	
	
}
