/**
 *
 */
package mx.epam.algorithms.arrays.zerosdocount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;

/**
 * Having an arrays of numbers, place all zeros to the left of the array (if
 * any). The operation must preserve the existing relative order between the
 * numbers.
 *
 * Extra: An objective of this problem is to solve it in-place and in O(1N).
 * This is, without any extra arrays and in a single iteration (only one for).
 * Otherwise, give a demonstration that this is not possible.
 *
 * @author Ernesto Espinosa.
 */
public class ZerosDoCount {

	public static final boolean IS_LEFT = true;
	public static final int NUMBER = 0;

	public static void main(String[] args) {
		try {
			System.out.println(Paths.get(".").toAbsolutePath());
			Path path = Paths.get("./src/mx/epam/algorithms/arrays/zerosdocount/");
			String content = new String(Files.readAllBytes(path.resolve("a.in")));
			int[] out = rearrange(Arrays.stream(content.split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray());
			StringBuilder builder = new StringBuilder();
			Arrays.stream(out).forEach(i -> builder.append(i).append(' '));
			Files.write(path.resolve("a.out"), Collections.singleton(builder.toString()), StandardOpenOption.CREATE,
					StandardOpenOption.WRITE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int[] rearrange(int[] array) {
		return (IS_LEFT) ? numberMoveLeft(array, NUMBER) : numberMoveRight(array, NUMBER);
	}

	public static int[] numberMoveLeft(int[] input, int num) {
		int zeroPos = -1;
		for (int i = input.length - 1; i >= 0; i--) {
			if (input[i] == num) {
				if (zeroPos == -1) {
					zeroPos = i;
				}
				continue;
			} else if (zeroPos != -1) {
				int temp = input[i];
				input[i] = input[zeroPos];
				input[zeroPos] = temp;
				zeroPos--;
			}
		}
		return input;
	}

	public static int[] numberMoveRight(int[] input, int num) {
		int zeroPos = -1;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == num) {
				if (zeroPos == -1) {
					zeroPos = i;
				}
				continue;
			} else if (zeroPos != -1) {
				int temp = input[i];
				input[i] = input[zeroPos];
				input[zeroPos] = temp;
				zeroPos++;
			}
		}
		return input;
	}

}
