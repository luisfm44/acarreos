package co.com.techandsolve.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import co.com.techandsolve.constants.Constantes;

/**
 * Clase encargada de alimentar los datos 
 * que vienen desde un archivo plano
 * @author luisfelipemarin
 * @version 1.0
 *
 */

@Component
public class ArchivoElementosDAOImpl implements ArchivoElementosDAO {

	
	/**
	 * Método encargado de cargar el archivo y pasar sus valores a una lista
	 * @param MultipartFile archivoAcarreos
	 */
	public List<String> obtenerElementosArchivo(MultipartFile archivoAcarreos) throws IOException {

		return new BufferedReader(new InputStreamReader(archivoAcarreos.getInputStream())).lines()
				.collect(Collectors.toList());

	}

	/**
	 * Método encargado de verificar el formato del archivo
	 * @param listaValores
	 */
	public List<String> validarArchivo(List<String> listaValores) {
		List<String> listaMensajes = new ArrayList<>();
		String numeroDias = Optional.of(listaValores.stream().findFirst().get()).orElse("");

		if (Integer.parseInt(numeroDias) <= 0 && Integer.parseInt(numeroDias)>500) {
			listaValores.add(Constantes.ERROR_NUMERO_DIAS_CERO);
		} else {
			listaValores.add(Constantes.ERROR_CONTENIDO_ARCHIVO);
		}
		
		 if(listaValores.stream().anyMatch(registro -> !StringUtils.isNumeric(registro))){
			 listaValores.add(Constantes.ERROR_VALOR_NO_NUMERICO);
	        }
		return listaMensajes;
	}
	
	public void escribirArchivoFinal(List<String> listaViajes) {
		String[] lines = new String[listaViajes.size()];
		lines = listaViajes.toArray(lines);
	      Path path = Paths.get("outputfile.txt");
	      try (BufferedWriter br = Files.newBufferedWriter(path,
	            Charset.defaultCharset(), StandardOpenOption.CREATE)) {
	         Arrays.stream(lines).forEach((s) -> {
	            try {
	               br.write(s);
	               br.newLine();
	            } catch (IOException e) {
	               throw new UncheckedIOException(e);
	            }

	         });
	      } catch (Exception e) {
	         
	      }
	}
}
