package co.com.techandsolve.service;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AcarreoServiceTest {

	@Autowired
	private AcarreoService acarreoService;

	@Test
	public void testProcesarViajesPorDia() throws IOException {
		List<String> listaValoresArchivo = Arrays.asList("5", "4", "130", "30", "1", "1", "3", "20", "20", "20", "11",
				"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "6", "9", "19", "29", "39", "49", "59", "10",
				"32", "56", "76", "8", "44", "60", "47", "85", "71", "91");
		List<String> resultadoReal = acarreoService.procesarViajesPorDia(listaValoresArchivo);
		List<String> resultadoEsperado = Arrays.asList("2", "1", "2", "3", "8");
		assertEquals(resultadoEsperado, resultadoReal);

	}
}
