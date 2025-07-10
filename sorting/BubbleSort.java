package dsapractice.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {5, 4, 2, 6, 8, 1};

        for (int j = 0; j < a.length; j++) {

            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int k = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = k;

                }
            }

        }
        System.out.println(Arrays.toString(a));
    }
}
