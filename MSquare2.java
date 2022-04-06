import java.util.Scanner;

public class MSquare2 {

	static int[][] startSequence;
	static int[][] userSequence;
	boolean[][] visited;
	int[][] prevA, prevB;
	int finalA, finalB;
	String[][] operation;

	public static void main(String[] args) {
		MSquare2 ms = new MSquare2();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter 8 numbers, one by one for the sequence you'll like: ");
//		for (int i = 0; i < 2; i++) {
//			for (int j = 0; j < 4; j++) {
//				System.out.print(startSequence[i][j] + " ");
//			}
//
//		}
		// put the numers into the 2d array
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				userSequence[i][j] = scanner.nextInt();
			}
		}
		// put the numbers into the 2nd row
		int temp1 = userSequence[1][0];
		int temp2 = userSequence[1][1];
		int temp3 = userSequence[1][2];
		int temp4 = userSequence[1][3];
		userSequence[1][0] = temp4;
		userSequence[1][1] = temp3;
		userSequence[1][2] = temp2;
		userSequence[1][3] = temp1;

//		for (int i = 0; i < 2; i++) {
//			for (int j = 0; j < 4; j++) {
//				System.out.print(userSequence[i][j] + " ");
//			}
//
//		}
		
		//to check if equal or not
//		boolean equalOrNot = true;
//		if (startSequence.length == userSequence.length) {
//			for (int i = 0; i < 2; i++) {
//				for (int j = 0; j < 4; j++) {
//					if (startSequence[i][j] != userSequence[i][j]) {
//						equalOrNot = false;
//					}
//				}
//			}
//		} else {
//			equalOrNot = false;
//		}
//
//		if (equalOrNot) {
//			System.out.println("they are equal");
//		} else {
//			System.out.println("they are not equal");
//		}
	}

	public MSquare2() {
		startSequence = new int[2][4];
		userSequence = new int[2][4];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				startSequence[i][j] = j + 1;
			}
		}
		int temp = 8;
		for (int i = 1; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				startSequence[i][j] = temp;
				temp--;
			}
		}

	}
//
//	public static boolean visted(int[][] start, int[][] user) {
//
//		//boolean equalOrNot = true;
//		if (start.length == user.length) {
//			for (int i = 0; i < 2; i++) {
//				for (int j = 0; j < 4; j++) {
//					if (start[i][j] != user[i][j]) {
//						return false;
//					}
//				}
//			}
//		} else {
//		
//			
//			
//			
//			
//			
//			
//		}
//
//		return false;
//	}
//	private boolean visit(int[][] _b, int _prevA, int _prevB, String _operation) {
//		if (_b > b || visited[_a][_b]) return false;
//		if (_b.length == startSequence.length) {
//			for (int i = 0; i < 2; i++) {
//				for (int j = 0; j < 4; j++) {
//					if (startSequence[i][j] != _b[i][j]) {
//						return false;
//					}
//				}
//			}
//		} else {
//		visited[_a][_b] = true;
//		prevA[_a][_b] = _prevA;
//		prevB[_a][_b] = _prevB;
//		operation[_a][_b] = _operation;
//
//		if (_a + _b == c) {
//			finalA = _a;
//			finalB = _b;
//			return true;
//        }
//        
//        boolean ret = visit(a, _b, _a, _b, "Fill Jug 1");
//        
//		ret = ret | visit(_a, b, _a, _b, "Fill Jug 2");
//		ret = ret | visit(0, _b, _a, _b, "Empty Jug 1");
//        ret = ret | visit(_a, 0, _a, _b, "Empty Jug 2");
//        
//		int x = (_a < b-_b) ? _a : b-_b;
//        ret = ret | visit(_a-x, _b+x, _a, _b, "Pour Jug 1 -> Jug 2");
//        
//		x = (_b < a-_a) ? _b : a-_a;
//        ret = ret | visit(_a+x, _b-x, _a, _b, "Pour Jug 2 -> Jug 1");
//        
//		return ret;
//	}
}
