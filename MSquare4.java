import java.util.Scanner;

public class MSquare4 {
    public static int[][] convertData(int[] data) {
        int row;
        int[][] ans = new int[2][5];
        for (int i = 0; i < 10; i++) {
            if (i > 4 && i <= 9) {
                row = 1;
                ans[row][i - 5] = data[i];
            } else {
                row = 0;
                ans[row][i] = data[i];
            }
        }
        return ans;
    }

    public static int[] rightShift(int[] data) {
        int res[] = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            if (i == data.length - 1) {
                res[0] = data[i];
            } else {
                res[i + 1] = data[i];
            }
        }
        return res;
    }

    public static int[] topBottomShift(int[] data) {
        int[] res = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            if (i > 4 && i <= 9) {
                res[i] = data[i - 5];
            } else {
                res[i] = data[i + 5];
            }
        }
        return res;
    }

    public static int[] rotateMiddle(int[] data) {
        int[] res = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            if (i == 1) {
                res[i] = data[i + 5];
                res[i + 1] = data[i];
            } else if (i == 3) {
                res[i] = data[i - 1];
            } else if (i == 5 || i == 6) {
                res[i] = data[i + 1];
            } else if (i == 7) {
                res[i] = data[i - 5];
            } else {
                res[i] = data[i];
            }
        }
        return res;
    }

    public static void display(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        int[] data = new int[10];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a 2D array of length 10:");
        for (int i = 0; i < 10; i++) {
            data[i] = scanner.nextInt();
        }
        scanner.close();
        // right shift
        int[] shiftedData = rightShift(data);
        // convert into 2D
        int[][] shiftedData2D = convertData(shiftedData);
        // printing all data
        System.out.println(":All data after right shift:");
        display(shiftedData2D);
        // top bottom shift
        int[] topBottomShiftData = topBottomShift(data);
        int[][] shiftedTopBottom2D = convertData(topBottomShiftData);
        // printing all data
        System.out.println(":All data after top bottom shift:");
        display(shiftedTopBottom2D);
        // top bottom shift
        int[] middleRotate = rotateMiddle(data);
        int[][] middleRotate2D = convertData(middleRotate);
        // printing all data
        System.out.println(":All data after middle rotate:");
        display(middleRotate2D);
    }
}