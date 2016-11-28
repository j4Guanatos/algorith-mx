package com.j4guanatos.algorithms.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.j4guanatos.algorithms.FindPairsSolution;
import com.j4guanatos.algorithms.Pair;

public class FindPairsNSolution implements FindPairsSolution {

	@Override
	public Set<Pair> findPairs(int[] numbers, int numberToSearch) {
		final Set<Pair> foundPairs = new HashSet<>();
		Map<Integer, Integer> complementsMap = new HashMap<>();
		int complement = 0;
		for(int i=0; i<numbers.length; i++){
			complement = numberToSearch-numbers[i];
			if(complementsMap.get(numbers[i])!=null){
				foundPairs.add(Pair.getInstance(numbers[i], complement));
			}	
			complementsMap.put(complement, numbers[i]);
		}
		return foundPairs;
	}

}
