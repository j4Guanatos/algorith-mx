package com.j4guanatos.algorithms.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.j4guanatos.algorithms.FindPairsSolution;
import com.j4guanatos.algorithms.Pair;

public class FindPairsNLogNSolution implements FindPairsSolution {

	@Override
	public Set<Pair> findPairs(int[] numbers, int numberToSearch) {
		Arrays.sort(numbers);
		final Set<Pair> foundPairs = new HashSet<>();
		int complement = 0;
		for (int i = 0; i < numbers.length; i++) {
			complement = numberToSearch - numbers[i];
			if (isInTheArray(numbers, complement, i)) {
				foundPairs.add(Pair.getInstance(numbers[i], complement));
			}
		}
		return foundPairs;
	}

	private static boolean isInTheArray(int[] numbers, int number, int currentIndex) {
		int indexFound = Arrays.binarySearch(numbers, number);
		return indexFound >= 0 && indexFound != currentIndex;
	}

}
