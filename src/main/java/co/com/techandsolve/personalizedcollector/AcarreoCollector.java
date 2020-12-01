package co.com.techandsolve.personalizedcollector;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;



public class AcarreoCollector implements Collector<Integer,AcarreoAccumulator,List<String>>{

	@Override
	public Supplier<AcarreoAccumulator> supplier() {
		return()-> new AcarreoAccumulator();
	}

	@Override
	public BiConsumer<AcarreoAccumulator, Integer> accumulator() {
		 return (accumulator, elemento) -> accumulator.decidirElemento(elemento);
	}

	@Override
	public BinaryOperator<AcarreoAccumulator> combiner() {
		return null;
	}

	@Override
	public Function<AcarreoAccumulator, List<String>> finisher() {
		return (accumulator) -> accumulator.getListaElementosDia();
	}

	@Override
	public Set<Characteristics> characteristics() {
		return EnumSet.of(Characteristics.UNORDERED);
	}

}
