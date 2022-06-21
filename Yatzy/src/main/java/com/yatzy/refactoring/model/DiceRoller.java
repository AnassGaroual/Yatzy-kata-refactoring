package com.yatzy.refactoring.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class containing a constructor to get dice elements
 * 
 */
public class DiceRoller {

	List<Integer> dice = new ArrayList<Integer>();

	public DiceRoller(int d1, int d2, int d3, int d4, int d5) {
		this.dice = Arrays.asList(d1, d2, d3, d4, d5);
		if (dice.stream().anyMatch(d -> d <= 0 || d >= 7)) // In case of invalid arguments, throw exception
		{
			throw new IllegalArgumentException();
		}
	}

	public List<Integer> getDice() {
		return this.dice;
	}

}
