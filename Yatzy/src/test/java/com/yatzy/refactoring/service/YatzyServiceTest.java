package com.yatzy.refactoring.service;

import org.junit.*;

import com.yatzy.refactoring.model.DiceRoller;
import com.yatzy.refactoring.service.YatzyService;

import static org.junit.Assert.*;

public class YatzyServiceTest {

	/**
	 * Test the thrown exception when invalid arguments
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_shouldThrowException() {
		new DiceRoller(1, 2, 3, 4, 8);
	}
    
	/**
	 * Test chance sum of all dices
	 */
	
	@Test
	public void testChance_shouldReturn15() {
		assertEquals(15, YatzyService.chance(new DiceRoller(2, 3, 4, 5, 1)));
	}
	
	@Test
	public void testChance_shouldReturn16() {
		assertEquals(16, YatzyService.chance(new DiceRoller(3, 3, 4, 5, 1)));
	}
	
	/**
	 * Test yatzy 
	 */

	@Test
	public void testYatzy_shouldReturn50() {
		assertEquals(50, YatzyService.yatzy(new DiceRoller(4, 4, 4, 4, 4)));
	}
	
	@Test
	public void test2Yatzy_shouldReturn50() {
		assertEquals(50, YatzyService.yatzy(new DiceRoller(6, 6, 6, 6, 6)));
	}
	
	@Test
	public void testYatzy_shouldReturn0() {
		assertEquals(0, YatzyService.yatzy(new DiceRoller(6, 6, 6, 6, 3)));
	}
	
	/**
	 * Test ones
	 */

	@Test
	public void testOnes_shouldReturn1() {
		assertEquals(1,YatzyService.ones(new DiceRoller(1, 2, 3, 4, 5)));
	}
	
	@Test
	public void testOnes_shouldReturn2() {
		assertEquals(2, YatzyService.ones(new DiceRoller(1, 2, 1, 4, 5)));
	}
	
	@Test
	public void testOnes_shouldReturn0() {
		assertEquals(0, YatzyService.ones(new DiceRoller(6, 2, 2, 4, 5)));
	}
	
	@Test
	public void testOnes_shouldReturn5() {
		assertEquals(5, YatzyService.ones(new DiceRoller(1, 1, 1, 1, 1)));
	}
	
	/**
	 * Test twos
	 */

	@Test
	public void testTwos_shouldReturn4() {
		assertEquals(4, YatzyService.twos(new DiceRoller(1, 2, 3, 2, 6)));
	}
	
	@Test
	public void testTwos_shouldReturn10() {
		assertEquals(10, YatzyService.twos(new DiceRoller(2, 2, 2, 2, 2)));
	}
	
	@Test
	public void testTwos_shouldReturn0() {
		assertEquals(0, YatzyService.twos(new DiceRoller(4, 1, 5, 3, 6)));
	}
	
	/**
	 * Test threes
	 */

	@Test
	public void testThrees_shouldReurn6() {
		assertEquals(6, YatzyService.threes(new DiceRoller(1, 2, 3, 2, 3)));
	}
	
	@Test
	public void testThrees_shouldReurn12() {
		assertEquals(12, YatzyService.threes(new DiceRoller(2, 3, 3, 3, 3)));
	}
	
	@Test
	public void testThrees_shouldReurn0() {
		assertEquals(0, YatzyService.threes(new DiceRoller(4, 1, 2, 5, 6)));
	}
	
	/**
	 * Test fours
	 */

	@Test
	public void testFours_shouldReturn12() {
		assertEquals(12, YatzyService.fours(new DiceRoller(4, 4, 4, 5, 5)));
	}
	
	@Test
	public void testFours_shouldReturn4() {
		assertEquals(4, YatzyService.fours(new DiceRoller(4, 5, 5, 5, 5)));
	}
	
	@Test
	public void testFours_shouldReturn0() {
		assertEquals(0, YatzyService.fours(new DiceRoller(5, 1, 2, 3, 6)));
	}
    
	
	
	@Test
	public void testFives_shouldReturn10() {
		assertEquals(10, YatzyService.fives(new DiceRoller(4, 4, 4, 5, 5)));
	}
	
	@Test
	public void testFives_shouldReturn25() {
		assertEquals(25, YatzyService.fives(new DiceRoller(5, 5, 5, 5, 5)));
	}
	
	@Test
	public void testFives_shouldReturn0() {
		assertEquals(0, YatzyService.fives(new DiceRoller(4, 1, 2, 3, 6)));
	}
	
	/**
	 * Test sixes
	 */

	@Test
	public void testSixes_shouldReturn18() {
		assertEquals(18, YatzyService.sixes(new DiceRoller(6, 5, 6, 6, 5)));
	}
	
	@Test
	public void testSixes_shouldReturn6() {
		assertEquals(6, YatzyService.sixes(new DiceRoller(4, 4, 6, 5, 5)));
	}
	
	@Test
	public void testSixes_shouldReturn0() {
		assertEquals(0, YatzyService.sixes(new DiceRoller(4, 4, 4, 5, 5)));
	}
	
	/**
	 * Test one pair
	 */

	@Test
	public void testScorePair_shouldReturn6() {
		assertEquals(6, YatzyService.score_pair(new DiceRoller(3, 4, 3, 5, 6)));
	}
	
	@Test
	public void testScorePair_shouldReturn10() {
		assertEquals(10, YatzyService.score_pair(new DiceRoller(5, 3, 3, 5, 5)));
	}
	
	@Test
	public void testScorePair_shouldReturn0() {
		assertEquals(0, YatzyService.score_pair(new DiceRoller(1, 2, 3, 4, 5)));
	}
	
	/**
	 * Test two pairs
	 */

	@Test
	public void testTwoPair_shouldReturn16() {
		assertEquals(16, YatzyService.two_pair(new DiceRoller(3, 3, 5, 5, 5)));
	}
	
	@Test
	public void testTwoPair_shouldReturn0() {
		assertEquals(0, YatzyService.two_pair(new DiceRoller(1, 1, 3, 4, 5)));
	}
	
	/**
	 * Test three of a kind
	 */

	@Test
	public void testThreeOfAkind_shouldReturn9() {
		assertEquals(9, YatzyService.three_of_a_kind(new DiceRoller(3, 3, 3, 4, 5)));
		assertEquals(15, YatzyService.three_of_a_kind(new DiceRoller(5, 3, 5, 4, 5)));
		assertEquals(9, YatzyService.three_of_a_kind(new DiceRoller(3, 3, 3, 3, 5)));
		assertEquals(0, YatzyService.three_of_a_kind(new DiceRoller(1, 2, 3, 4, 3)));
	}
	
	@Test
	public void testThreeOfAkind_shouldReturn15() {
		assertEquals(15, YatzyService.three_of_a_kind(new DiceRoller(5, 3, 5, 5, 5)));
	}
	
	@Test
	public void testThreeOfAkind_shouldReturn0() {
		assertEquals(0, YatzyService.three_of_a_kind(new DiceRoller(3, 3, 4, 4, 5)));
	}
	
	/**
	 * Test four of a kind
	 */

	@Test
	public void testFourOfAkind_shouldReturn12() {
		assertEquals(12, YatzyService.four_of_a_kind(new DiceRoller(3, 3, 3, 3, 3)));
	}
	
	@Test
	public void testFourOfAkind_shouldReturn20() {
		assertEquals(20, YatzyService.four_of_a_kind(new DiceRoller(5, 5, 5, 4, 5)));
	}
	
	@Test
	public void testFourOfAkind_shouldReturn0() {
		assertEquals(0, YatzyService.four_of_a_kind(new DiceRoller(1, 2, 3, 4, 3)));
	}
	
	/**
	 * Test small straight
	 */

	@Test
	public void testSmallStraight_shouldReturn15() {
		assertEquals(15, YatzyService.smallStraight(new DiceRoller(1, 2, 3, 4, 5)));
	}
	
	@Test
	public void test2SmallStraight_shouldReturn15() {
		assertEquals(15, YatzyService.smallStraight(new DiceRoller(2, 3, 4, 5, 1)));
	}
	
	@Test
	public void testSmallStraight_shouldReturn0() {
		assertEquals(0, YatzyService.smallStraight(new DiceRoller(2, 3, 4, 5, 6)));
	}
	
	/**
	 * Test large straight
	 */

	@Test
	public void testLargeStraight_shouldReturn20() {
		assertEquals(20, YatzyService.largeStraight(new DiceRoller(6, 2, 3, 4, 5)));
	}
	
	@Test
	public void test2LargeStraight_shouldReturn20() {
		assertEquals(20, YatzyService.largeStraight(new DiceRoller(2, 3, 4, 5, 6)));
	}
	
	@Test
	public void testLargeStraight_shouldReturn0() {
		assertEquals(0, YatzyService.largeStraight(new DiceRoller(1, 2, 2, 4, 5)));
	}
	
	/**
	 * Test full house
	 */

	@Test
	public void testFullHouse_shouldReturn18() {
		assertEquals(18, YatzyService.fullHouse(new DiceRoller(6, 2, 2, 2, 6)));
		assertEquals(0, YatzyService.fullHouse(new DiceRoller(2, 3, 4, 5, 6)));
	}
	
	@Test
	public void testFullHouse_shouldReturn0() {
		assertEquals(0, YatzyService.fullHouse(new DiceRoller(2, 3, 4, 5, 6)));
	}
	
	@Test
	public void test2FullHouse_shouldReturn0() {
		assertEquals(0, YatzyService.fullHouse(new DiceRoller(6, 6, 6, 6, 6)));
	}
}
