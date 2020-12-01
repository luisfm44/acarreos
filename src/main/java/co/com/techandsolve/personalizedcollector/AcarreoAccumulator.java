package co.com.techandsolve.personalizedcollector;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class AcarreoAccumulator {

	private List<String> listaElementosDia = new ArrayList<>();
	private Integer numeroDiasTrabajo = null;
	private Integer numeroElementosDiaTrabajo = null;
	private List<Integer> elementosDiaTrabajoActual = new ArrayList<>();
	


	/**
	 * Método que define la posición del elemento que entra en el Stream.
	 * 
	 * @param elemento
	 */
	public void decidirElemento(Integer elemento) {
		if (Objects.isNull(numeroDiasTrabajo)) {
			numeroDiasTrabajo = elemento;
		} else if (Objects.isNull(numeroElementosDiaTrabajo)) {
			numeroElementosDiaTrabajo = elemento;
		} else {
			elementosDiaTrabajoActual.add(elemento);
		}

		if (Objects.nonNull(numeroElementosDiaTrabajo) && !elementosDiaTrabajoActual.isEmpty()
				&& elementosDiaTrabajoActual.size() == numeroElementosDiaTrabajo) {
			Integer cnt = procesarElementosViaje(elementosDiaTrabajoActual);
			if(Objects.nonNull(cnt)) {
				listaElementosDia.add(cnt.toString());
			}
			numeroElementosDiaTrabajo = null;
			elementosDiaTrabajoActual = new ArrayList<>();
		}

	}
	
	
	/**
	 * Método que calcula los viajes a realizar
	 * 
	 * @param elementosDiaTrabajoActual
	 * @return
	 */
	public Integer procesarElementosViaje(List<Integer> elementosDiaTrabajoActual) {
		List<Integer> elementosOrdenados = elementosDiaTrabajoActual.stream().sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		Integer cantidadElementos = elementosOrdenados.size();
		Integer viajes = 0;
		ArrayDeque<Integer> dequeList = new ArrayDeque<>(elementosOrdenados);
		int numeroElementoMenor = 1;
		int pesoTotal = 0;
		boolean ultimoElemento = false;

		for (int i = 0; i <= cantidadElementos; i++) {
			if (!dequeList.isEmpty()) {
				if (dequeList.getFirst().intValue() >= 50) {
					dequeList.removeFirst();
					viajes++;
				} else {
					if (null != dequeList.getLast()) {
						pesoTotal = dequeList.getFirst().intValue()
								+ (dequeList.getFirst().intValue() * numeroElementoMenor);
						if (pesoTotal >= 50) {
							if (dequeList.size() == 1 && dequeList.getFirst().intValue() < 50) {
								dequeList.removeFirst();
								ultimoElemento = true;
							}
							if (!ultimoElemento) {
								dequeList.removeFirst();
								dequeList.removeLast();
							}
							viajes++;
							pesoTotal = 0;
							numeroElementoMenor = 0;
						} else {
							numeroElementoMenor++;
							dequeList.removeLast();
						}
					}
				}
			} else {
				break;
			}
		}
		return viajes;
	}

	public List<String> getListaElementosDia() {
		return listaElementosDia;
	}

	public void setListaElementosDia(List<String> listaElementosDia) {
		this.listaElementosDia = listaElementosDia;
	}

	public Integer getNumeroDiasTrabajo() {
		return numeroDiasTrabajo;
	}

	public void setNumeroDiasTrabajo(Integer numeroDiasTrabajo) {
		this.numeroDiasTrabajo = numeroDiasTrabajo;
	}

	public Integer getNumeroElementosDiaTrabajo() {
		return numeroElementosDiaTrabajo;
	}

	public void setNumeroElementosDiaTrabajo(Integer numeroElementosDiaTrabajo) {
		this.numeroElementosDiaTrabajo = numeroElementosDiaTrabajo;
	}

	public List<Integer> getElementosDiaTrabajoActual() {
		return elementosDiaTrabajoActual;
	}

	public void setElementosDiaTrabajoActual(List<Integer> elementosDiaTrabajoActual) {
		this.elementosDiaTrabajoActual = elementosDiaTrabajoActual;
	}


}
