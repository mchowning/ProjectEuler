import static org.junit.Assert.*;

import org.junit.Test;


public class ProjectEulerTest {

	ProjectEuler pe = new ProjectEuler();
	
	@Test
	public void testOne() {
		assertEquals(pe.numLatticePaths(1), 2);
	}
	
	@Test
	public void testTwo() {
		assertEquals(pe.numLatticePaths(2), 6);
	}

	@Test
	public void testThree() {
		assertEquals(pe.numLatticePaths(3), 20);
	}
	
	@Test
	public void testFour() {
		assertEquals(pe.numLatticePaths(4), 70);
	}
}