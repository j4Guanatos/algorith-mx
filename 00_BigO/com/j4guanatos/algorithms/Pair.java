package com.j4guanatos.algorithms;

public class Pair {
	private Integer firstNumber;
	private Integer secondNumber;

	private Pair() {
	}

	public static Pair getInstance(final Integer firstNumber, final Integer secondNumber) {
		Pair pair = new Pair();
		pair.firstNumber = firstNumber;
		pair.secondNumber = secondNumber;
		return pair;
	}

	@Override
	public boolean equals(Object objToCompare) {
		if (objToCompare == null || !(objToCompare instanceof Pair)) {
			return false;
		}
		Pair pairToCompare = (Pair) objToCompare;
		return isTheSamePair(this, pairToCompare);
	}

	private boolean isTheSamePair(Pair pair, Pair pairToCompare) {
		return (pair.firstNumber.equals(pairToCompare.firstNumber) && pair.secondNumber.equals(pairToCompare.secondNumber))
				|| (pair.firstNumber.equals(pairToCompare.secondNumber) && pair.secondNumber.equals(pairToCompare.firstNumber));
	}

	@Override
	public int hashCode() {
		return (firstNumber + secondNumber) * 7;
	}

	@Override
	public String toString() {
		return String.format("Pair: %s, %s", firstNumber, secondNumber);
	}
}