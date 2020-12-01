package co.com.techandsolve.collectors;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.techandsolve.personalizedcollector.AcarreoAccumulator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AcarreoAcumuladorTest {

	@Autowired
    private AcarreoAccumulator accumulator;
	
	@Test
	public void testCalcularViajes(){
		//List<Integer> list = Arrays.asList(11,10,9,8,7,6,5,4,3,2);
		//List<Integer> list = Arrays.asList(130,30,1,1);
		//List<Integer> list = Arrays.asList(20,20,20);
		//List<Integer> list = Arrays.asList(9,19,29,39,49,59);
		List<Integer> list = Arrays.asList(32,56,76,8,44,60,47,85,71,91); 
		Integer resultadoReal = accumulator.procesarElementosViaje(list);
		Integer resultadoEsperado = 8;
		assertEquals(resultadoEsperado, resultadoReal);
	}

	
	
	
	
}
