package com.yatzy.refactoring.utils;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class containing utility methods intended to be reused in the application
 * 
 */
public class YatzyUtility {
	
	/**
	 * Method returning elements and their
	 * respective frequencies
	 *
	 * @param elements the stream of dice sequences
	 * @return map of frequencies
	 */
	public static Map<Integer, Long> frequencyMap(Stream<Integer> elements) {
		return elements.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}
	
	/**
	 * Method returning sum of same number 
	 *
	 * @param elements the stream of dice sequences and num the number
	 * @return sum of number occurrences
	 */
	public static int countSum(Stream<Integer> elements, int num) {
		return (int) (elements.filter(d -> d == num).count() * num);
	}

}
