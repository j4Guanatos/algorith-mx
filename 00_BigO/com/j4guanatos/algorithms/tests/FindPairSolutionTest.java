package com.j4guanatos.algorithms.tests;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.j4guanatos.algorithms.FindPairs;
import com.j4guanatos.algorithms.Pair;
import com.j4guanatos.algorithms.FindPairs.SolutionType;

public class FindPairSolutionTest {

	private static TestInput input = null;
	private static FindPairs findPairs = null;
	private static final int ARRAY_LENGTH = 100_000,
							 MAX_RANDOM_NUMBER = 200_000,
							 NUMBER_TO_SEARCH = 7378;
	private static final String INPUT_FILE = "testData1.txt";
	private static final boolean useFile = true; 
	private static boolean isRandomExecution; 
	
	@BeforeClass
	public static void setUpBeforeClass() throws URISyntaxException{
		if(useFile)
			input = getInputDataFromFile(INPUT_FILE);
		if(input==null){
			int[] numbersArray = getRandomUniqueNumbers(ARRAY_LENGTH, MAX_RANDOM_NUMBER);
			input = TestInput.withValues(NUMBER_TO_SEARCH, numbersArray);
			isRandomExecution = true;
		}
		System.out.println("Input array: "+Arrays.toString(input.numbersArray));
		System.out.println("Number to search: "+input.numberToSearch);
		findPairs = FindPairs.withValues(input.numbersArray, input.numberToSearch);
	}
	
	private static TestInput getInputDataFromFile(String fileName) throws URISyntaxException{
		try{
			List<String> lines = Files.readAllLines(Paths.get(TestInput.class.getResource(fileName).toURI()));
			String arrayAsString = lines.get(0);
			int numberToSearch = Integer.parseInt(lines.get(1));
			int occurrences = Integer.parseInt(lines.get(2));
			String[] array = arrayAsString.split(",");
			int[] numbersArray = new int[array.length];
			for(int i=0; i<array.length; i++){
				numbersArray[i] = Integer.parseInt(array[i]);
			}
			return TestInput.withValues(numberToSearch, occurrences, numbersArray);
		}catch(Exception e){
			System.err.println("Input file error, generating random array");
		}
		return null;
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
	
	@Test
	public void testQuadraticSolution() {
		executeTest(SolutionType.QUADRATIC);
	}
	
	@Test
	public void testNLogNSolution() {
		executeTest(SolutionType.N_LOG_N);
	}
	
	@Test
	public void testNSolution() {
		executeTest(SolutionType.N);
	}
	
	private void executeTest(SolutionType solutionType){
		long startTime = System.currentTimeMillis();
		Set<Pair> foundPairs = findPairs.findPairs(solutionType);
		long endTime = System.currentTimeMillis();
		System.out.println(String.format("[%d millis]\t%d Found pairs: %s", endTime-startTime, foundPairs.size(), foundPairs));
		assertFoundPairs(foundPairs.size());
	}
	
	private void assertFoundPairs(int occurrences){
		Assume.assumeFalse(isRandomExecution);
		Assert.assertEquals(input.occurrences, occurrences);
	}

	private static class TestInput{
		private int numberToSearch;
		private int occurrences;
		private int[] numbersArray;
		
		private static TestInput withValues(int numberToSearch, int occurrences, int[] numbersArray){
			TestInput testInput = new TestInput();
			testInput.numbersArray = numbersArray;
			testInput.numberToSearch = numberToSearch;
			testInput.occurrences = occurrences;
			return testInput;
		}
		
		private static TestInput withValues(int numberToSearch, int[] numbersArray){
			TestInput testInput = new TestInput();
			testInput.numbersArray = numbersArray;
			testInput.numberToSearch = numberToSearch;
			return testInput;
		}
	}
}