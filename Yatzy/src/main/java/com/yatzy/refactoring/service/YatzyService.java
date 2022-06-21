package com.yatzy.refactoring.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.yatzy.refactoring.model.DiceRoller;
import com.yatzy.refactoring.utils.YatzyUtility;

/**
 * This is a code refactoring of the kata problem described in https://github.com/emilybache/Yatzy-Refactoring-Kata .
 * This is just a first  attempt based only on usage of java streams, variables, naming editing &
 * more test unit use cases, implementation of more best practices such as SOLID principles and design patterns to ensure maintainability
 * and extensibility of the application.
 * @author   Anass GAROUAL
 */

/**
 * Class containing all the business logic, to be refactored using SOLID
 * principles (Especilly single responsibility through using design pattern
 * strategy)
 */
public class YatzyService {

	public static final List<Integer> SMALL_STRAIGHT = Arrays.asList(1, 2, 3, 4, 5);
	public static final List<Integer> LARGE_STRAIGHT = Arrays.asList(2, 3, 4, 5, 6);

	/**
	 * The player scores the sum of all dice.
	 *
	 * @param dice the object containing dice sequence
	 * @return the sum
	 */
	public static int chance(DiceRoller dice) {
		return dice.getDice().stream().mapToInt(Integer::intValue).sum();
	}

	/**
	 * If all dice have the same number, the player scores 50 points.
	 *
	 * @param dice the object containing dice sequence
	 * @return 50 in case of same numbre, 0 otherwise
	 */
	public static int yatzy(DiceRoller dice) {
		return dice.getDice().stream().filter(d -> d == dice.getDice().get(0)).count() == 5 ? 50 : 0;
	}

	/**
	 * The player scores the sum of the dice that reads one.
	 *
	 * @param dice the object containing dice sequence
	 * @return result
	 */
	public static int ones(DiceRoller dice) {

		return YatzyUtility.countSum(dice.getDice().stream(), 1);
	}

	/**
	 * The player scores the sum of the dice that reads two.
	 *
	 * @param dice the object containing dice sequence
	 * @return result
	 */
	public static int twos(DiceRoller dice) {
		return YatzyUtility.countSum(dice.getDice().stream(), 2);
	}

	/**
	 * The player scores the sum of the dice that reads three.
	 *
	 * @param dice the object containing dice sequence
	 * @return result
	 */
	public static int threes(DiceRoller dice) {
		return YatzyUtility.countSum(dice.getDice().stream(), 3);
	}

	/**
	 * The player scores the sum of the dice that reads four.
	 *
	 * @param dice the object containing dice sequence
	 * @return result
	 */
	public static int fours(DiceRoller dice) {
		return YatzyUtility.countSum(dice.getDice().stream(), 4);
	}

	/**
	 * The player scores the sum of the dice that reads five.
	 *
	 * @param dice the object containing dice sequence
	 * @return result
	 */
	public static int fives(DiceRoller dice) {
		return YatzyUtility.countSum(dice.getDice().stream(), 5);
	}

	/**
	 * The player scores the sum of the dice that reads six.
	 *
	 * @param dice the object containing dice sequence
	 * @return result
	 */
	public static int sixes(DiceRoller dice) {
		return YatzyUtility.countSum(dice.getDice().stream(), 6);
	}

	/**
	 * The player scores the sum of the two highest matching dice.
	 *
	 * @param dice the object containing dice sequence
	 * @return result
	 */
	public static int score_pair(DiceRoller dice) {
		Map<Integer, Long> mapFrequence = YatzyUtility.frequencyMap(dice.getDice().stream());
		int maxValue = mapFrequence.entrySet().stream().filter(e -> e.getValue() >= 2).mapToInt(Entry::getKey).max()
				.orElse(0);

		return maxValue * 2;

	}

	/**
	 * If there are two pairs of dice with the same number, the player scores the
	 * sum of these dice.
	 *
	 * @param dice the object containing dice sequence
	 * @return result
	 */
	public static int two_pair(DiceRoller dice) {
		Map<Integer, Long> mapFrequence = YatzyUtility.frequencyMap(dice.getDice().stream());

		List<Integer> pairDice = mapFrequence.entrySet().stream().filter(e -> e.getValue() >= 2).map(Entry::getKey)
				.collect(Collectors.toList());
		return pairDice.size() == 2 ? pairDice.stream().mapToInt(Integer::intValue).sum() * 2 : 0;
	}

	/**
	 * If there are n dice with the same number, the player scores the sum of these
	 * dice.
	 *
	 * @param dice the object containing dice sequence and n the number of kind
	 * @return result
	 */
	private static int numberOfAKind(DiceRoller dice, int n) {
		for (Entry<Integer, Long> entry : YatzyUtility.frequencyMap(dice.getDice().stream()).entrySet()) {
			if (entry.getValue() >= n) {
				return entry.getKey() * n;
			}
		}
		return 0;
	}

	/**
	 * If there are four dice with the same number, the player scores the sum of
	 * these dice.
	 *
	 * @param dice the object containing dice sequence
	 * @return result
	 */
	public static int four_of_a_kind(DiceRoller dice) {
		return numberOfAKind(dice, 4);
	}

	/**
	 * If there are three dice with the same number, the player scores the sum of
	 * these dice.
	 *
	 * @param dice the object containing dice sequence
	 * @return result
	 */
	public static int three_of_a_kind(DiceRoller dice) {
		return numberOfAKind(dice, 3);
	}

	/**
	 * When placed on “small straight”, if the dice read 1,2,3,4,5 the player scores
	 * 15
	 * 
	 * @param dice the object containing dice sequence
	 * @return result
	 */
	public static int smallStraight(DiceRoller dice) {
		List<Integer> sorted = dice.getDice().stream().sorted().collect(Collectors.toList());
		return SMALL_STRAIGHT.equals(sorted) ? 15 : 0;
	}

	/**
	 * When placed on “large straight”, if the dice read 2,3,4,5,6 the player scores
	 * 15
	 * 
	 * @param dice the object containing dice sequence
	 * @return result
	 */
	public static int largeStraight(DiceRoller dice) {
		List<Integer> sorted = dice.getDice().stream().sorted().collect(Collectors.toList());
		return LARGE_STRAIGHT.equals(sorted) ? 20 : 0;
	}

	/**
	 * If the dice are two of a kind and three of a kind, the player scores the sum
	 * of all the dice.
	 * 
	 * @param dice the object containing dice sequence
	 * @return result
	 */
	public static int fullHouse(DiceRoller dice) {
		Map<Integer, Long> mapFrequence = YatzyUtility.frequencyMap(dice.getDice().stream());
		if (mapFrequence.entrySet().stream().mapToInt(Entry::getKey).distinct().count() == 2 && mapFrequence.entrySet()
				.stream().filter(e -> e.getValue() >= 2).mapToInt(Entry::getKey).count() >= 2) {
			return dice.getDice().stream().mapToInt(Integer::intValue).sum();
		}
		return 0;

	}
}