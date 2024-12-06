package dev.buskopan.maior_valor_array;

import java.util.Arrays;

public class MaiorValorNoArray {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,700,8,10,100,50};
        System.out.println("O maior valor do array é: " + encontrarValor(array));
    }
    public static int encontrarValor(int[] arr) {
        if (arr.length == 0 ) {
            return 0;
        }
        return Arrays.stream(arr).max().getAsInt();
    }
}
