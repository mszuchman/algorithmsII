package com.sorts;

import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public abstract class SortAlgorithmTest {
	long start;

	@Rule
	public TestName	name	= new TestName();

	@BeforeClass
	public static void beforeClass() {
		System.out.println("=========================================================");
	}

	@Before
	public void before() {
		start = System.currentTimeMillis();
	}

	@Test
	public void testSortedNumbers() {
		SortAlgorithm<Integer> algorithm = getInstance();

		Integer[] numbers = new Integer[100];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
		}
		Integer[] copy = numbers.clone();

		algorithm.sort(numbers);

		Assert.assertArrayEquals(copy, numbers);
	}

	@Test
	public void testWithReverseSortNumbers() {
		SortAlgorithm<Integer> algorithm = getInstance();

		Integer[] numbers = new Integer[100];
		for (int i = 0; i < numbers.length; i++) {
			numbers[numbers.length - i - 1] = i;
		}

		Integer[] copy = numbers.clone();

		algorithm.sort(numbers);
		Arrays.sort(copy);

		Assert.assertArrayEquals(copy, numbers);
	}

	@Test
	public void testWithShuffleNumbers() {
		SortAlgorithm<Integer> algorithm = getInstance();
		Integer[] numbers = { 2, 3, 1, 4, 5, 0 };
		Integer[] copy = numbers.clone();

		algorithm.sort(numbers);
		Arrays.sort(copy);

		Assert.assertArrayEquals(copy, numbers);
	}

	@After
	public void after() {
		System.out.println(getClass().getName().toString() + "." + name.getMethodName() + " took "
				+ (System.currentTimeMillis() - start) + "ms");
	}

	protected abstract <T extends Comparable<T>> SortAlgorithm<T> getInstance();
}
