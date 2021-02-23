package labs;

import mooc.EdxIO;

public class Lab06 {

    private static int tempInd;
    private static int tempInt;
    private static int count=1;
    private static boolean tempBool = true;
    private static final EdxIO io = EdxIO.create();

    public static void main(String[] args) {
        int n = io.nextInt();
        int[] array = new int[n];
        int[] arrayIdx = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = io.nextInt();
        }

        tempInd = array[1];

        for (int i = 0; i < n; i++) {
            arrayIdx[i] = i + 1;
        }

        mergeSort(array, arrayIdx, n);

        io.print(1 + " ");
        io.print(n + " ");
        io.print(array[0] + " ");
        io.print(array[n - 1] + "\n");
        io.print(arrayToString(array));
        io.close();
    }

    public static void merge(int[] array, int[] leftArray,
                             int[] rightArray, int[] arrayIdx, int[] leftArrayIdx,
                             int[] rightArrayIdx, int leftArrayLength, int rightArrayLength) {
        int i = 0, j = 0, k = 0;
        while (i < leftArrayLength && j < rightArrayLength) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                arrayIdx[k++] = leftArrayIdx[i++];
            } else {
                array[k] = rightArray[j];
                arrayIdx[k++] = rightArrayIdx[j++];
            }
        }
        while (i < leftArrayLength) {
            array[k] = leftArray[i];
            arrayIdx[k++] = leftArrayIdx[i++];
        }
        while (j < rightArrayLength) {
            array[k] = rightArray[j];
            arrayIdx[k++] = rightArrayIdx[j++];
        }
    }

    private static void mergeSort(int[] array, int[] arrayIdx, int n) {
        if (n < 2) {
            if (tempBool) {
                tempInd = arrayIdx[0];
                tempInt = array[0];
                tempBool = false;
            } else {
                io.print(tempInd + " ");
                io.print(arrayIdx[0] + " ");
                io.print(tempInt + " ");
                io.print(array[0]);
                io.println();
                tempBool = true;
            }
            return;
        }

        int midIdx = n / 2;
        int[] leftArray = new int[midIdx];
        int[] rightArray = new int[n - midIdx];
        int[] leftArrayIdx = new int[midIdx];
        int[] rightArrayIdx = new int[n - midIdx];

        System.arraycopy(array, 0, leftArray, 0, midIdx);
        System.arraycopy(array, midIdx, rightArray, 0, n - midIdx);
        System.arraycopy(arrayIdx, 0, leftArrayIdx, 0, midIdx);
        System.arraycopy(arrayIdx, midIdx, rightArrayIdx, 0, n - midIdx);

        mergeSort(leftArray, leftArrayIdx, midIdx);
        mergeSort(rightArray, rightArrayIdx, n - midIdx);

        merge(array, leftArray, rightArray, arrayIdx, leftArrayIdx, rightArrayIdx, midIdx, n - midIdx);
    }

    private static String arrayToString(int[] array) {
        String stringArray = "";
        for (int j : array) {
            stringArray += j + " ";
        }
        return (stringArray.replaceFirst(".$", ""));
    }
}
