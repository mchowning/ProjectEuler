import java.util.concurrent.TimeUnit;

/*
 * Simple starter class for running problems and calculating
 * how long they take.
 */

public class Main {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		int input = 20;
		String result = Long.toString(Problem15.numLatticePaths(input));
		System.out.println(result);
		
		float  elapsedTimeInSeconds = (System.nanoTime() - startTime) / 
				(float)1000000000;
		System.out.println("Took " + elapsedTimeInSeconds + " seconds");
	}
}

