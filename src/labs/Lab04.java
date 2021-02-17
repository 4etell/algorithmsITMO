package labs;

import mooc.EdxIO;

public class Lab04 {
    public static void main(String[] args) {
        try (EdxIO io = EdxIO.create()) {

            int n = io.nextInt();
            Double[] arrayOfNum = new Double[n];
            Integer[] arrayOfInd = new Integer[n];

            for (int i = 0; i < n; i++) {
                arrayOfNum[i] = io.nextDoubleFast();
                arrayOfInd[i] = i;
            }

            for (int j = 1; j < n; j++) {
                int i = j - 1;
                while (i >= 0 && arrayOfNum[i] > arrayOfNum[i + 1]) {
                    swap(arrayOfNum, i, i + 1);
                    swap(arrayOfInd, i, i + 1);
                    i--;
                }
            }

            io.print((arrayOfInd[0] + 1) + " " + (arrayOfInd[(n - 1) / 2] + 1) + " " + (arrayOfInd[n - 1] + 1));
        }
    }

    private static void swap(Object[] array, int firstNum, int secondNum) {
        Object temp = array[firstNum];
        array[firstNum] = array[secondNum];
        array[secondNum] = temp;
    }
}
