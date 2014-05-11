package com.sorts.heap;

import com.sorts.SortAlgorithm;
import com.sorts.SortAlgorithmTest;

public class HeapSortTest extends SortAlgorithmTest {

	@Override
	protected <T extends Comparable<T>> SortAlgorithm<T> getInstance() {
		return new HeapSort<T>();
	}
	
}
