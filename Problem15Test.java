import static org.junit.Assert.*;

import org.junit.Test;

public class Problem15Test {

	@Test
	public void testOne() {
		assertEquals(Problem15.numLatticePaths(1), 2);
	}
	
	@Test
	public void testTwo() {
		assertEquals(Problem15.numLatticePaths(2), 6);
	}

	@Test
	public void testThree() {
		assertEquals(Problem15.numLatticePaths(3), 20);
	}
	
	@Test
	public void testFour() {
		assertEquals(Problem15.numLatticePaths(4), 70);
	}
	
	@Test
	public void testFive() {
		assertEquals(Problem15.numLatticePaths(5), 252);
	}
	
	@Test
	public void testTwenty() {
		assertEquals(Problem15.numLatticePaths(20), 137846528820L);
	}
}