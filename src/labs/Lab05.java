package labs;

import mooc.EdxIO;

public class Lab05 {
    private static String outputString = "";

    public static void main(String[] args) {
        try (EdxIO io = EdxIO.create()) {

            int n = io.nextInt();
            int[] arrayOfNum = new int[n];

            for (int i = 0; i < n; i++) {
                arrayOfNum[i] = io.nextInt();
            }

            sort(arrayOfNum, n);
            io.print(outputString + "No more swaps needed.");

        }
    }

    private static void sort(int[] array, int n) {
        for (int i = 0; i < n - 1; i++) {

            int minIdx = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }

            if (i < minIdx) {
                outputString += ("Swap elements at indices " + (i + 1) + " and " + (minIdx + 1) + "." + "\n");
            } else if (i > minIdx) {
                outputString += ("Swap elements at indices " + (minIdx + 1) + " and " + (i + 1) + "." + "\n");
            }

            swap(array, i, minIdx);
        }
    }

    private static void swap(int[] array, int firstNum, int secondNum) {
        int temp = array[firstNum];
        array[firstNum] = array[secondNum];
        array[secondNum] = temp;
    }
}
