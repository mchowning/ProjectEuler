import java.util.concurrent.TimeUnit;

/*
 * Simple class for running problems and calculating
 * how long they take.
 */

public class Main {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		System.out.println(new Problem15().run());
		
		float  elapsedTimeInSeconds = (System.nanoTime() - startTime) / 
				(float)1000000000; // TODO Change to 1000000000F ????
		System.out.println("Took " + elapsedTimeInSeconds + " seconds");
	}
}

