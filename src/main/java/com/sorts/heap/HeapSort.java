package com.sorts.heap;

import com.sorts.SortAlgorithm;

public class HeapSort<T extends Comparable<T>> extends SortAlgorithm<T> {
	private static final String	LINE_SEPARATOR	= repeat("=", 40);

	public T[] sort(T[] array) {
		draw(array);
		
		heapify(array);

		debug(LINE_SEPARATOR + "\n Heapified! \n" + LINE_SEPARATOR);

		draw(array);
		sortRemain(array);

		return array;
	}

	private void heapify(T[] array) {
		int parent;
		for (int child = 1; child < array.length; child++) {
			parent = getParent(child);
			while (array[parent].compareTo(array[child]) < 0) {
				swap(array, parent, child);
				child = parent;
				parent = getParent(parent);
			}
		}
	}

	private void sortRemain(T[] array) {
		int parent, leftChild, maxChild, rightChild;
		for (int n = array.length - 1; n >= 0; n--) {
			swap(array, 0, n);
			parent = 0;
			
			while (true) {
				leftChild = leftChild(parent);
				if (leftChild >= n)
					break;
				rightChild = leftChild + 1;

				if (rightChild < n && array[leftChild].compareTo(array[rightChild]) < 0) {
					maxChild = rightChild;
				} else {
					maxChild = leftChild;
				}

				if (array[parent].compareTo(array[maxChild]) < 0) {
					swap(array, parent, maxChild);
					parent = maxChild;
				} else
					break;
			}
		}
	}

	private void swap(T[] array, int from, int to) {
		T t = array[from];
		array[from] = array[to];
		array[to] = t;
		debug(LINE_SEPARATOR + "\n" + from + " swap " + to + "\n" + LINE_SEPARATOR);
		draw(array);
	}

	private int getParent(int i) {
		return (int) Math.floor((i - 1) / 2);
	}

	private int leftChild(int i) {
		return (int) i * 2 + 1;
	}
}
