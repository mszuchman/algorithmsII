package com.sorts.heap;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class HeapSortTest {
	@Test
	public void testSortedNumbers(){
		HeapSort<Integer> heapSort = new HeapSort<Integer>();
		
		Integer[] numbers  = new Integer[100];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i]=i;
		}
		Integer[] copy = numbers.clone();
		
		heapSort.sort(numbers);
		
		Assert.assertArrayEquals(copy, numbers);
	}
	@Test
	public void testWithReverseSortNumbers(){
		HeapSort<Integer> heapSort = new HeapSort<Integer>();
		
		Integer[] numbers  = new Integer[100];
		for (int i = 0; i < numbers.length; i++) {
			numbers[numbers.length-i-1]=i;
		}
		
		Integer[] copy = numbers.clone();
		
		heapSort.sort(numbers);
		Arrays.sort(copy);
		
		Assert.assertArrayEquals(copy, numbers);
	}
	@Test
	public void testWithShuffleNumbers(){
		HeapSort<Integer> heapSort = new HeapSort<Integer>();
		heapSort.turnOnDebug(true);
		Integer[] numbers  = { 2, 3, 1, 4, 5, 0 };
		Integer[] copy = numbers.clone();
		
		heapSort.sort(numbers);
		Arrays.sort(copy);
		
		Assert.assertArrayEquals(copy, numbers);
	}
}
