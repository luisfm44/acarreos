/**
 * 
 */
package co.com.techandsolve.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author luisfelipemarin
 *
 */
public interface ArchivoElementosDAO {
		
	public List<String> obtenerElementosArchivo(MultipartFile archivoAcarreos)throws IOException;
	public List<String> validarArchivo(List<String> listaValores);
	public void escribirArchivoFinal(List<String> listaViajes);
}
