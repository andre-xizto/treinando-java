package dev.buskopan.bubble_sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {43,63,64,2,7,0,100,243,64,2,534,745,346,342,3,32,1,6};
        System.out.println("Antes da ordenação: " + Arrays.toString(array));
        ordenar(array);
        System.out.println("Depois da ordenação: " + Arrays.toString(array));
    }

    public static void ordenar(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
