import java.util.*;

public class ProjectEuler {

	public void run() {
		System.out.println(Long.toString(numLatticePaths(20)));		
	}
	
	public long numLatticePaths(int n) {
		long[][] array = new long[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				array[i][j] = 0;
			}
		}
		return numLatticePaths(array, n, n);
	}
	
	public long numLatticePaths(long[][] prevResults, int x, int y) {
		if (x == 1 || y == 1) return x + y;
		if (prevResults[x][y] != 0) return prevResults[x][y];
		if (prevResults[x - 1][y] == 0) {
			prevResults[x - 1][y] = numLatticePaths(prevResults, x - 1, y);
		}
		if (prevResults[x][y - 1] == 0) {
			prevResults[x][y - 1] = numLatticePaths(prevResults, x, y - 1);
		}
		return prevResults[x - 1][y] + prevResults[x][y - 1];
	}
}
