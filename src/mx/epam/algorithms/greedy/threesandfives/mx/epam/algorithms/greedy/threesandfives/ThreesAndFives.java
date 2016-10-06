package mx.epam.algorithms.greedy.threesandfives;

public class ThreesAndFives {
	
	public static void main(String args[]) {
		ThreesAndFives test = new ThreesAndFives();
		String r1L = test.numberWithNumberOfDigits(1000000);
		System.out.println(r1L);
	}
	
	public String numberWithNumberOfDigits( int n ) {
		int numberOfFives = 0, numberOfThrees = 0;
		if( n < 3 || n > 100000) { return "-1"; }
		
		if( n % 3 == 0) {
			// we will have only fives in the final number
			numberOfFives = n;
		} else {
			// How many groups of fives we are going to have initially.
			int groupsOfFives = n / 3;
			
			while( groupsOfFives > 0 && (n - (groupsOfFives * 3) ) % 5 != 0) {
				groupsOfFives--;
			}
			
			numberOfFives = groupsOfFives * 3;
			numberOfThrees = n - numberOfFives;
			// if we don't have any fives and the threes are not multiple of 5 return -1;
			if(numberOfFives == 0 && numberOfThrees % 5 != 0){
				return "-1";
			}
		}
		
		return convertNumberWithNumberOfDigitsStr(numberOfFives, numberOfThrees);
	}

	private String convertNumberWithNumberOfDigitsStr(int numberOfThrees, int numberOfFives) {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < numberOfFives; i++) {
			builder.append("5");
		}
		for(int i = 0; i < numberOfThrees; i++) {
			builder.append("3");
		}
		return builder.toString();
	}
}
