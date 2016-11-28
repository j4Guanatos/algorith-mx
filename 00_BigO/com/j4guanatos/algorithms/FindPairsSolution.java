package com.j4guanatos.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class FindPairsSolution {
	private static final int ARRAY_LENGTH = 10000, 
							 MAX_RANDOM_NUMBER = 20000,
							 NUMBER_TO_SEARCH = 1534;
	
	public static void main(String[] args) {
		final int[] numbers = getRandomUniqueNumbers(ARRAY_LENGTH, MAX_RANDOM_NUMBER);
		System.out.println(String.format("Input array: %s\nNumber to search: %s", Arrays.toString(numbers), NUMBER_TO_SEARCH));
		Set<Pair> foundPairs = findPairsQuadratic(numbers, NUMBER_TO_SEARCH);
		System.out.println(String.format("%d Found pairs: %s", foundPairs.size(), foundPairs));
		foundPairs = findPairsNLogN(numbers, NUMBER_TO_SEARCH);
		System.out.println(String.format("%d Found pairs: %s", foundPairs.size(), foundPairs));
		foundPairs = findPairsN(numbers, NUMBER_TO_SEARCH);
		System.out.println(String.format("%d Found pairs: %s", foundPairs.size(), foundPairs));
	}
	
	private static Set<Pair> findPairsQuadratic(final int[] numbers, final int numberToSearch){
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
	
	private static Set<Pair> findPairsNLogN(final int[] numbers, final int numberToSearch){
		Arrays.sort(numbers);
		final Set<Pair> foundPairs = new HashSet<>();
		int complement = 0;
		for(int i=0; i<numbers.length; i++){
			complement = numberToSearch-numbers[i];
			if(isInTheArray(numbers, complement, i)){
				foundPairs.add(Pair.getInstance(numbers[i], complement));
			}
		}
		return foundPairs;
	}
	
	private static Set<Pair> findPairsN(final int[] numbers, final int numberToSearch){
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
	
	private static boolean isInTheArray(int[] numbers, int number, int currentIndex){
		int indexFound = Arrays.binarySearch(numbers, number);
		return indexFound>=0 && indexFound!=currentIndex;
	}
	
	private static int[] getRandomUniqueNumbers(final int arrayLength, final int maxNumber){
		if(maxNumber<arrayLength) 
			throw new IllegalArgumentException("Max number must be at least the length of the array");
		final Random numberGenerator = new Random();
		Set<Integer> previouslyGenerated = new HashSet<>();
		int[] generatedArray = new int[arrayLength];
		int i = 0, randomNumber = 0;
		while(i < arrayLength){
			randomNumber = numberGenerator.nextInt(maxNumber);
			if(previouslyGenerated.add(randomNumber)){ // Returns false if already existed
				generatedArray[i] = randomNumber;
				i++;
			}
		}
		return generatedArray;
	}

}