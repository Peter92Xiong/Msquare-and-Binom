import java.math.BigInteger;
import java.util.Scanner;

public class Binom {
	
	static BigInteger x = new BigInteger("1");
	static BigInteger gNN = new BigInteger("1");
	
	public static BigInteger calc2BigInteger(BigInteger knk, int counter) {
		//BigInteger x = new BigInteger("1");
		//int newN = n.intValue();
		int newN = gNN.intValue();
		x = x.multiply(BigInteger.valueOf(newN - counter)).divide(BigInteger.valueOf(counter + 1));
//		System.out.println("start x" + x);
		if(counter < knk.intValue() -1) {
			counter++;
//			System.out.println(x);
			x = calc2BigInteger(knk, counter);
			
		}
//		System.out.println("end of x " + x);
		return x;
	}
	

//	public static BigInteger calBigInteger2(BigInteger n, BigInteger k) {
//		BigInteger x = new BigInteger("1");
//		BigInteger y = new BigInteger("1");
//		BigInteger z = new BigInteger("0");
//		if(n.compareTo(k) == 0) {
//			return x;
//		}
//		int i = 0;
//		y = calBigInteger2(n - i, k)
//		
//		return x;
//	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int done;
//		int done2;
		int startCounter = 0;
		do {
			System.out.println(
					"Please enter two numbers you'll like to compute the binomial coeffient for, or enter -1 to quit ");
			int n = scanner.nextInt();
			if(n == -1) {break;}
			int k = scanner.nextInt();
			if(k == -1) {break;}
			done = n;
//			done2 = k;
			if (n >= 1 && n <= 1000 && k >= 1 && k <= n) {
//				System.out.println("B(" + n + ", " + k + ") = " + calcBigInteger(n, k));
				String nNew = String.valueOf(n);
				
				String kNew = String.valueOf(k);
				BigInteger bNewN = new BigInteger(nNew);
				BigInteger bNewK = new BigInteger(kNew);
				gNN = bNewN;
				System.out.println("B(" + n + ", " + k + ") = " + calc2BigInteger(bNewK,startCounter));
				startCounter = 0;
				x = new BigInteger("1");

			} else {
				System.out.println("Incorrect format, the first number must be between from 1 to 1000, and");
				System.out.println("the 2nd input must be between 1 and the first number. Try again");
			}
		} while (done != -1);

		scanner.close();
	}

}
