package co.com.techandsolve.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.techandsolve.model.RegistroUsuarioAcarreo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistroTrabajadorTest {

	@Autowired
	private RegistroUsuarioAcarreoService registro;
	
	@Test
	public void registrarTrabajador() {
		RegistroUsuarioAcarreo r = new RegistroUsuarioAcarreo();
		r.setCedula(9976706);
		r.setFechaRegistro(LocalDateTime.now());
		r.setNumeroViajes("2,1,2,3,8");
		RegistroUsuarioAcarreo real = registro.registrarTrabajador(r);
		assertEquals(r, real);
	}

	public RegistroUsuarioAcarreoService getRegistro() {
		return registro;
	}

	public void setRegistro(RegistroUsuarioAcarreoService registro) {
		this.registro = registro;
	}

	
	
	
}
