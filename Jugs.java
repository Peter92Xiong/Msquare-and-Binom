import java.util.Scanner;

public class Jugs {
	int a, b, c, n;
	boolean[][] visited;
	int[][] prevA, prevB;
	int finalA, finalB;
    String[][] operation;
    
	public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
		System.out.print("Enter A: ");
        int a = scanner.nextInt();
        
		System.out.print("Enter B: ");
        int b = scanner.nextInt();
        
		System.out.print("Enter C: ");
        int c = scanner.nextInt();
        
        Jugs jugs = new Jugs(a, b, c, 1002);

        boolean possible = jugs.visit(0, 0, -1, -1, "");
        
		if (possible) {
			System.out.println("Yay! Found a solution.");
			jugs.printSolution(jugs.finalA, jugs.finalB);
		} else {
			System.out.println("Impossible!");
        }

        scanner.close();
    }
    
    public Jugs(int _a, int _b, int _c, int _n) {
        a = _a;
        b = _b;
        c = _c;
        n = _n;

        visited = new boolean[n][n];
        
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = false;
            }
        }

        prevA = new int[n][n];
		prevB = new int[n][n];
		operation = new String[n][n];
    }

	private boolean visit(int _a, int _b, int _prevA, int _prevB, String _operation) {
		if (_a < 0 || _a > a || _b < 0 || _b > b || visited[_a][_b]) return false;
		
		visited[_a][_b] = true;
		prevA[_a][_b] = _prevA;
		prevB[_a][_b] = _prevB;
		operation[_a][_b] = _operation;

		if (_a + _b == c) {
			finalA = _a;
			finalB = _b;
			return true;
        }
        
        boolean ret = visit(a, _b, _a, _b, "Fill Jug 1");
        
		ret = ret | visit(_a, b, _a, _b, "Fill Jug 2");
		ret = ret | visit(0, _b, _a, _b, "Empty Jug 1");
        ret = ret | visit(_a, 0, _a, _b, "Empty Jug 2");
        
		int x = (_a < b-_b) ? _a : b-_b;
        ret = ret | visit(_a-x, _b+x, _a, _b, "Pour Jug 1 -> Jug 2");
        
		x = (_b < a-_a) ? _b : a-_a;
        ret = ret | visit(_a+x, _b-x, _a, _b, "Pour Jug 2 -> Jug 1");
        
		return ret;
	}

	private void printSolution(int a, int b) {
		if (a == 0 && b == 0) return;
		printSolution(prevA[a][b], prevB[a][b]);
		System.out.println(operation[a][b] + " [a = " + a + ", b = " + b + "]");
	}
}