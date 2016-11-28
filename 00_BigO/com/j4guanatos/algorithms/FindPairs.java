package com.j4guanatos.algorithms;

import java.util.Objects;
import java.util.Set;

import com.j4guanatos.algorithms.impl.FindPairsNLogNSolution;
import com.j4guanatos.algorithms.impl.FindPairsNSolution;
import com.j4guanatos.algorithms.impl.FindPairsQuadraticSolution;

public class FindPairs {
	
	private int[] numbersArray;
	private Integer numberToSearch;
	
	public enum SolutionType {QUADRATIC, N_LOG_N, N};
	
	private FindPairs(){}
	
	public static FindPairs withValues(int[] numbersArray, Integer numberToSearch){
		Objects.requireNonNull(numbersArray, "numbersArray is required");
		Objects.requireNonNull(numberToSearch, "numberToSearch is required");
		FindPairs findPairsInstace = new FindPairs();
		findPairsInstace.numbersArray = numbersArray;
		findPairsInstace.numberToSearch = numberToSearch;
		return findPairsInstace;
	}
	
	public Set<Pair> findPairs(SolutionType solutionType){
		FindPairsSolution solutionImplementation = getSolutionImplementation(solutionType);
		return solutionImplementation.findPairs(numbersArray, numberToSearch);
	}
	
	private static FindPairsSolution getSolutionImplementation(SolutionType solutionType){
		switch (solutionType) {
		case QUADRATIC:
			return new FindPairsQuadraticSolution();
		case N_LOG_N:
			return new FindPairsNLogNSolution();
		case N:
			return new FindPairsNSolution();
		default:
			throw new IllegalArgumentException("Invalid solutionType");
		}
	}
	
}