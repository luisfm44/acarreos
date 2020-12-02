package co.com.techandsolve.dto;

import java.io.Serializable;
import java.util.List;

public class RespuestaCargaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje;
	private List<DetalleCargaDTO> listaDetalleCarga;
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public List<DetalleCargaDTO> getListaDetalleCarga() {
		return listaDetalleCarga;
	}
	public void setListaDetalleCarga(List<DetalleCargaDTO> listaDetalleCarga) {
		this.listaDetalleCarga = listaDetalleCarga;
	}
	
	

}
