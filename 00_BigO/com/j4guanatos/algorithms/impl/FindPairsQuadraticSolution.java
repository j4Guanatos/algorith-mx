package com.j4guanatos.algorithms.impl;

import java.util.HashSet;
import java.util.Set;

import com.j4guanatos.algorithms.FindPairsSolution;
import com.j4guanatos.algorithms.Pair;

public class FindPairsQuadraticSolution implements FindPairsSolution {

	@Override
	public Set<Pair> findPairs(int[] numbers, int numberToSearch) {
		final Set<Pair> foundPairs = new HashSet<>();
		for(int i=0; i<numbers.length; i++){
			for(int j=0; j<numbers.length; j++){
				if(i!=j && numbers[i]+numbers[j]==numberToSearch){
					foundPairs.add(Pair.getInstance(numbers[i], numbers[j]));
				}
			}
		}
		return foundPairs;
	}

}
