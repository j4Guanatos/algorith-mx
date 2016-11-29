/**
 * 
 */
package mx.epam.algorithms.math.series.strangecounter;

/**
 * Having an <i>strange counter</i>, determine the value of it after <i>t</i> iterations of the counter.<br>
 * <br>
 * The counter at time <i>t</i> = 1 has the value of <i>k</i> = 3, which is decremented as the time increases.<br>
 * When the value of <i>k</i> = 1, instead of being decremented to 0, it takes the last value of
 * that count-down cycle (<i>k</i>) multiplied by a factor <i>f</i> = 2.<br>
 * <br>
 * At this point, the value of <i>k</i> is updated with the result of the multiplication, in this case 6.<br>
 * <br>
 * Example:<br>
 * <br>
 * | t | val | t | val | t  | val |<br>
 * |---|-----|---|-----|----|-----|<br>
 * | 1 | 3   | 4 | 6   | 10 | 12  |<br>
 * | 2 | 2   | 5 | 5   | 11 | 11  |<br>
 * | 3 | 1   | 6 | 4   | 12 | 10  |<br>
 * |   |     | 7 | 3   | 13 | 9   |<br>
 * |   |     | 8 | 2   | 14 | 8   |<br>
 * |   |     | 9 | 1   | 15 | 7   |<br>
 * |   |     |   |     | 16 | 6   |<br>
 * |   |     |   |     | 17 | 5   |<br>
 * |   |     |   |     | 18 | 4   |<br>
 * |   |     |   |     | 19 | 3   |<br>
 * |   |     |   |     | 20 | 2   |<br>
 * |   |     |   |     | 21 | 1   |<br>
 * <br>
 * The problem is, having <i>t</i>, determine the value of <i>val</i>, for <i>k</i> = 3 and <i>f</i> = 2.<br>
 * <br>
 * Extra:<br>
 * The above problem has the values of <i>k</i> and <i>f</i> fixed.<br> 
 * Solve the problem with <i>k</i> and <i>f</i> variables.<br>
 * 
 * @author Ernesto Espinosa.
 */
public class StrangeCounter {

	/**
	 * Problem solution.
	 * @param t The value of <i>t</i>.
	 * @return The value of <i>val</i>.
	 */
	public static int strangeCounter(int t) {
		return -1;
	}
	
	/**
	 * Solution generalization.
	 * @param t The value of <i>t</i>.
	 * @param k The value of <i>k</i>, which is the initial value of the first count-down cycle.
	 * @param f The value of <i>f</i>, which is the multiplier for the subsequent cycles.
	 * @return The value of <i>val</i>.
	 */
	public static int strangeCounter(int t, int k, int f) {
		return -1;
	}
}
