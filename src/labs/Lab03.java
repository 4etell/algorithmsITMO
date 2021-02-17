package labs;

import mooc.EdxIO;

public class Lab03 {
    public static void main(String[] args) {
        try (EdxIO io = EdxIO.create()) {

            String firstOutputString = "1 ";
            int n = io.nextInt();
            int[] array = new int[n];

            for (int i = 0; i < n; i++) {
                array[i] = io.nextInt();
            }

            for (int j = 1; j < n; j++) {
                int k = 0;
                int i = j - 1;
                while (i >= 0 && array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    i--;
                    k++;
                }
                firstOutputString += j - k + 1 + " ";
            }

            io.println(firstOutputString.replaceFirst(".$", ""));
            io.print(arrayToString(array));
        }
    }

    private static void swap(int[] array, int firstNum, int secondNum) {
        int temp = array[firstNum];
        array[firstNum] = array[secondNum];
        array[secondNum] = temp;
    }

    private static String arrayToString(int[] array) {
        String stringArray = "";
        for (int j : array) {
            stringArray += j + " ";
        }
        return (stringArray.replaceFirst(".$", ""));
    }
}
