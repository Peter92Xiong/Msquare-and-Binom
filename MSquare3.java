import java.util.Scanner;

public class MSquare3
{

	static String startState = "1 2 3 4 5 6 7 8";
	private static StringMap visited;
	static String userState;
	private static StringMap allPossibility;
	private static Queue queue;
	private static Queue itterQueue;
	// static int[] visited;

	public MSquare3(String inputUserString)
	{

		this.userState = inputUserString;
//		queue = new Queue();
	}

	public static void main(String[] args)
	{
		allPossibility = new StringMap();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the state: ");

		String inuserState = scanner.nextLine();
		userState = inuserState;

		// allPossibility.insert(userState, "");
//	
//		if(solutionState.equals(userState)) {
//			System.out.println("yay");
//		}
//		System.out.println(stateC(startState));
//		Queue queue = new Queue();

		queue = new Queue();
		queue.enqueue(new QNode(0, startState));
		visited = new StringMap();
		visited.insert(startState, "");

		allPossibility.insert(startState, "");
		int temp = 0;

		bfs();
//		System.out.println("one shift " + stateC(startState, temp));
//		allPossibility.insert(startState, "");
//		startState = stateC(startState, temp);
//		
//		System.out.println("one more shift2 " + stateC(startState, temp));
//		allPossibility.insert(startState, "");
//		startState = stateC(startState, temp);
//
//		System.out.println("one more shift3 " + stateC(startState, temp));
//		allPossibility.insert(startState, "");
//		startState = stateC(startState, temp);
//
//		System.out.println("one more shift4 " + stateC(startState, temp));
//		allPossibility.insert(startState, "");
//		startState = stateC(startState, temp);
//		
//		System.out.println("one more shift5 " + stateC(startState, temp));
//		allPossibility.insert(startState, "");
//		startState = stateC(startState, temp);

//		if(isValidStringStateB(startState)) {
//			System.out.println("valid");
//		}else {
//			System.out.println("not valid");
//		}
//		System.out.println(solveString(startState));
//		System.out.println(allStates(startState);
//		allStates(startState);
//		while (startState.compareTo(userState) != 0) {
//			for (int i = 0; i <= 14; i = i + 2) {
//				while (startState.charAt(i) != userState.charAt(i)) {
//					stateA(startState);
//
//					stateA(startState);
//
//					stateB(startState);
//					stateC(startState);
//				}
//			}
////			stateA(startState);
////			stateB(startState);
////			stateC(startState);
//		}

//		boolean found = false;
//		if (startState.equals(userState))
//			found = true;
//
//		while (!queue.isEmpty() && !found) {
//			QNode x = queue.dequeue();
//			if (processNeighbors(x))
//				found = true;
//		}
//
//		if (found) {
//			System.out.println("Yes!");
//			printPath(userState);
//		} else {
//			System.out.println("Should have worked, redo code..");
//		}

	}

	private static void printPath(String word)
	{
		if (word.equals(""))
			return;
		StringNode x = visited.find(word);
		printPath(x.getValue());
		System.out.println(word);
	}

	private static boolean processNeighbors(QNode x)
	{

		int dist = x.getDist();
		String word = x.getWord();
		MSquare3 nMSquare3 = new MSquare3(word);
		for (int i = 0; i < word.length(); i++)
		{
			StringBuffer temp = new StringBuffer(word);
			for (char a = '1'; a <= '8'; ++a)
			{
				// temp.setCharAt(i, a);
				nMSquare3.stateA(word);
				String temp2 = temp.toString();
				if (temp2.equals(userState))
				{
					visited.insert(userState, word);
					return true;
				}
				if (visited.find(temp2) == null && allPossibility.find(temp2) != null)
				{
					queue.enqueue(new QNode(dist + 1, temp2));
					visited.insert(temp2, word);
				}
			}
		}
		return false;
	}

	public static String stateA(String inputString)
	{

		char[] arr = inputString.toCharArray();
		char[] newArr =
		{ arr[14], arr[1], arr[12], arr[1], arr[10], arr[1], arr[8], arr[1], arr[6], arr[1], arr[4], arr[1], arr[2],
				arr[1], arr[0] };

		String str = String.valueOf(newArr);
		return str;
	}

	public static String stateB(String inputString, int a)
	{
		int n = 0;
		n = a;
//		for(int i = 0; i<=2; i++) {
		char[] arr = inputString.toCharArray();
		char[] newarr =
		{ arr[6], arr[1], arr[0], arr[1], arr[2], arr[1], arr[4], arr[1], arr[10], arr[1], arr[12], arr[1], arr[14],
				arr[1], arr[8] };

		inputString = String.valueOf(newarr);
		if (allPossibility.find(inputString) == null)
		{
//			char[] arr = inputString.toCharArray();
//			char[] newarr =
//			{ arr[6], arr[1], arr[0], arr[1], arr[2], arr[1], arr[4], arr[1], arr[10], arr[1], arr[12], arr[1], arr[14],
//					arr[1], arr[8] };
//
//			inputString = String.valueOf(newarr);
			return inputString;

		} else if (allPossibility.find(inputString) != null)
		{
			if (n != 2)
			{
				n++;
				inputString = stateB(inputString, n);

			}
		}
		return inputString;

	}

	public static String stateC(String inputString, int x)
	{
		int n = 0;
		n = x;
		char[] arr = inputString.toCharArray();
		char[] newarr =
		{ arr[0], arr[1], arr[12], arr[1], arr[2], arr[1], arr[6], arr[1], arr[8], arr[1], arr[4], arr[1], arr[10],
				arr[1], arr[14] };
		inputString = String.valueOf(newarr);
		if (allPossibility.find(inputString) == null)
		{
//			char[] arr = inputString.toCharArray();
//			char[] newarr =
//			{ arr[6], arr[1], arr[0], arr[1], arr[2], arr[1], arr[4], arr[1], arr[10], arr[1], arr[12], arr[1], arr[14],
//					arr[1], arr[8] };
//
//			inputString = String.valueOf(newarr);
			return inputString;

		} else if (allPossibility.find(inputString) != null)
		{
			if (n != 2)
			{
				n++;
				inputString = stateC(inputString, n);

			}
		}
		return inputString;
	}

	public static void allStates(String theStartString)
	{
		allPossibility = new StringMap();
		// System.out.println(theStartString);
		if (theStartString.compareTo(userState) == 0)
		{
			System.out.println("it match");

		}
//		if (!allPossibility.findTF(theStartString)) {
//			allPossibility.insert(theStartString, ""); // insert the fist word
//			System.out.println("in the if statment");
		for (int i = 0; i <= 14; i = i + 2)
		{ // check the first char
			// if first char != the user char than do this code
			System.out.println("in the for-loop " + i);
			if (theStartString.charAt(i) != userState.charAt(i) && allPossibility.find(theStartString) == null)
			{
				String temp = theStartString;
				allPossibility.insert(temp, "");
				String temp2 = stateA(temp);
				// allPossibility.insert(temp, "");
				System.out.println("the temp: " + temp);
				System.out.println("the temp2: " + temp2);
				System.out.println("the startString " + theStartString);
//					if(allPossibility.findTF(temp)) {
//						System.out.println("temp in in the stringmap");
//					}
				// System.out.println("if the string is in the map: " +
				// allPossibility.find(temp).getKey());
				// allStates(temp2);

			}
//				for (int j = 0; j <= 14; j = j + 2) {
//				if(theStartString.charAt(i) != userState.charAt(i) && allPossibility.find(theStartString) == null) {
//					String temp = theStartString;
//					allPossibility.insert(temp, "");
//					String temp2= stateB(temp);
//					System.out.println("the temp: " + temp);
//					System.out.println("the temp2: " + temp2);
//					System.out.println("the startString " + theStartString);
//					
//				}
//				}
//				for (int k = 0; k <= 14; k = k + 2) {
//				if(theStartString.charAt(i) != userState.charAt(i) && allPossibility.find(theStartString) == null){
//					String temp = theStartString;
//					allPossibility.insert(temp, "");
//					String temp2= stateC(temp);
//				}
//				}

		}

//				// if the inputstring is now the userstate
//				if (theStartString.equals(userState)) {
//					//
//				}
//				// do stateA, if the word has never been found put it on a stringMap
//				if (!allPossibility.findTF(theStartString)) {
//					allPossibility.insert(theStartString, "");
//					// call the allstate again
//					allStates(theStartString);
//				}
//
//			} else if (theStartString.charAt(i) == userState.charAt(i)) {
//
//			}
//		}

	}

	public static void bfs()
	{
		int n = 0;
		int count = 0;
		while (startState.compareTo(userState) != 0)
		{
//			if (queue.isEmpty())
//			{
//				if (isValidStringStateA(startState))
//				{
//					startState = stateA(startState);
//					queue.enqueue(new QNode(0, startState));
//				} else if (isValidStringStateB(startState))
//				{
//					startState = stateB(startState, n);
//					queue.enqueue(new QNode(0, startState));
//				} else if (isValidStringStateC(startState))
//				{
//					startState = stateC(startState, n);
//					queue.enqueue(new QNode(0, startState));
//				}
//
//			}
			while (!queue.isEmpty()) // while Q not empty
			{
				QNode abc = queue.dequeue(); // remove
				startState = abc.getWord(); // get the word place it as startstate
//				for (int i = 0; i < 14; i = i + 2)
//				{
//					if (abcString.equals(userState))
//					{
//						printPath(abcString);
//					} else
//					{
//
//						stateA(abcString);
//
//					}
//
//				}
//				if (allPossibility.findTF(startState) == false) // if you can't find the word in hashmap, do this
//				{
				if (startState.compareTo(userState) == 0) // if the word is == to user do this
				{
					System.out.println("");
					System.out.println(count);
				} else
				{
					if (isValidStringStateA(startState)) // if you can do stateA with the word do this.
					{
						startState = stateA(startState); // do state A to the word
						queue.enqueue(new QNode(0, startState)); // add to the Q
						allPossibility.insert(startState, ""); // insert it to allposs
						System.out.print("A");
//							System.out.println("A " + startState); // print out the state
						count++;
//						solveString(startString);
					} else if (isValidStringStateB(startState))
					{
						startState = stateB(startState, n);
						allPossibility.insert(startState, "");
						queue.enqueue(new QNode(0, startState));
						System.out.print("B");
//							System.out.println("B " + startState);
						count++;
//						solveString(startString);
					} else if (isValidStringStateC(startState))
					{
						startState = stateC(startState, n);
						allPossibility.insert(startState, "");
						queue.enqueue(new QNode(0, startState));
						System.out.print("C");
//							System.out.println("C " + startState);
						count++;
//						solveString(startString);
//					} else
//					{
//						startState = stateC(startState);
//						System.out.println("C " + startState);
//						count++;
//						startState = stateB(startState);
//						System.out.println("B " + startState);
//						count++;
//		
//					}
						System.out.println(count++);
//					solveString(startString);

					}
				}
			}
//			}

		}
	}

	private static boolean isValidStringStateA(String startString)
	{
		String temp = stateA(startString);
		if (allPossibility.find(temp) == null)
		{
			return true;
		}
		return false;
	}

	private static boolean isValidStringStateB(String startString)
	{
		int n = 0;
		String temp = stateB(startString, n);
		if (allPossibility.find(temp) == null)
		{
			return true;
		}
		return false;
	}

	private static boolean isValidStringStateC(String startString)
	{
		int n = 0;
		String temp = stateC(startString, n);
		if (allPossibility.find(temp) == null)
		{
			return true;
		}
		return false;

	}

	private static boolean isValidString(String startString)
	{

		return !isValidStringStateA(startString) && !isValidStringStateB(startString)
				&& !isValidStringStateC(startString);

	}

//	public static String solveString(String startString)
//	{
//
////		for(int i = 0; i <=14; i=i+2) {
////			if(startString.charAt(i) != userState.charAt(i)) {
////				
////			}
////			
////		}
//		// System.out.println("in the solveString");
//		int count = 0;
//		while (startString.compareTo(userState) != 0)
//		{
//			if (isValidStringStateA(startString))
//			{
//				startString = stateA(startString);
//				allPossibility.insert(startString, "");
//				System.out.println("A " + startString);
//				count++;
////				solveString(startString);
//			} else if (isValidStringStateB(startString))
//			{
//				startString = stateB(startString);
//				allPossibility.insert(startString, "");
//				System.out.println("B " + startString);
//				count++;
////				solveString(startString);
//			} else if (isValidStringStateC(startString))
//			{
//				startString = stateC(startString);
//				allPossibility.insert(startString, "");
//				System.out.println("C " + startString);
//				count++;
////				solveString(startString);
//			} else
//			{
//				startString = stateC(startString);
//				System.out.println("C " + startString);
//				count++;
//				startString = stateB(startString);
//				System.out.println("B " + startString);
//				count++;
//
//			}
//			System.out.println(count++);
////			solveString(startString);
//
//		}
//
//		return startString;
//	}

}
