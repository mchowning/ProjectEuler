/*
 * Starting in the top left corner of a 2×2 grid, and only being able to 
 * move to the right and down, there are exactly 6 routes to the bottom 
 * right corner.  How many such routes are there through a 20×20 grid?
 */

public class Problem15 implements Problem{
	
	public String run() {
		int input = 20;
		return Long.toString(numLatticePaths(input));
	}
	
	/*
	 * Solves the problem recursively by reducing the problem to
	 * the sum of all the possible solutions that are present after
	 * each of the two possible opening moves.  In other words,
	 * after the first move, you either have a square of (x-1, y)
	 * or a square of (x, y - 1) dimensions.  Solving for both of these
	 * and adding them together gets the solution.  This recursion
	 * occurs in the fillInCalculatedValues method.
	 *
	 * This solution did bog down quite a bit around sizes of 16x16
	 * though, so I just added a grid-style array to store previously
	 * saved results.  This sped up the program a significant amount.
	 * Sounds like this may have just been my jerry-rigged memoization
	 * technique.
	 */
	
	public static long numLatticePaths(int n) {
		
		// Lattice sizes start at 1, so add an extra spot to the end of the array
		// to make it possible to directly map square numbers to array positions.
		long[][] prevResults = new long[n + 1][n + 1]; 
		initializeArrayToZero(prevResults);
		
		return numLatticePaths(prevResults, n, n);
	}
	
	/*
	// An alternative implementation some other people (far smarter than
	// me used was n choose k and binomial coefficients.  In particular, 
	// for a X, Y size square of lattices, where X <= Y, there are 
	// X + Y choose Y lattice paths.  The binomial coefficient to calculate
	// this is X! / ((X - Y)! Y!).  The below two functions work for smaller
	// numbers, but long breaks once you get bigger (definitely doesn't work
	// for 20).  Would probably need to use BigInteger instead.
	public static long numLatticePaths(int n) {
		return factorial(2 * n) / (long)Math.pow(factorial(n), 2);
	}
	
	private static long factorial(int n) {
		if (n == 1) return n;
		return n * factorial(n - 1);
	}
	*/
	
	private static long numLatticePaths(long[][] prevResults, int x, int y) {
		
		// If the lattice is 1 in any direction, then the possible number of
		// paths is 1 + the size of the other direction.
		if (x == 1 || y == 1) return x + y;  
		
		if(alreadyCalculated(prevResults[x][y])) return prevResults[x][y];
		
		fillInUncalculatedValues(prevResults, x, y);		
		return prevResults[x - 1][y] + prevResults[x][y - 1];
	}
	
	private static void initializeArrayToZero(long[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				array[i][j] = 0;
			}
		}
	}
	
	private static void fillInUncalculatedValues(long[][] prevResults, int x, int y) {
		if (!alreadyCalculated(prevResults[x - 1][y])) {
			prevResults[x - 1][y] = numLatticePaths(prevResults, x - 1, y);
		}
		if (!alreadyCalculated(prevResults[x][y - 1])) {
			prevResults[x][y - 1] = numLatticePaths(prevResults, x, y - 1);
		}
	}
	
	// Only implemented to improve readability.
	private static boolean alreadyCalculated(long n) {
		return n != 0;
	}
}
