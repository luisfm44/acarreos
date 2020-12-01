package co.com.techandsolve.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.techandsolve.personalizedcollector.AcarreoCollector;

@Service
public class AcarreoService {
	
	
	
	
	
	public List<String> procesarViajesPorDia(List<String> valores) {

        return valores.stream().map(Integer::valueOf).collect(new AcarreoCollector());
	}
	
	

	
}
