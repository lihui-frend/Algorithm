package com.algorithm;

import java.util.Arrays;

public class Test {
    public static String Compression(String string){

        String [] str = string.split("");
        StringBuilder stringBuilder = new StringBuilder();
        int p = 1;
        for (int i = 0; i<str.length;i++){
            if (i!=str.length-1&&str[i].equals(str[i+1])){
                p++;
            }else {
                stringBuilder.append(str[i]+p);
                p = 1;
            }
        }
        return stringBuilder.toString();
    }

    public static int[] target(int arr[],int target){
        int length = arr.length;
        int [] result = new int[2];
        for (int i=0;i<length-1;i++){
            for (int j=i+1;j<length;j++){
                if (arr[i]+arr[j]==target){
                    result[0] = i+1;
                    result[1] = j+1;
                    return result;
                }
            }
        }
        return null;
    }
    public static void main(String [] args){
        String str = "aaaabbcccddeeeeefghij";
        int[] arr = {33,1,11,29,1,1};
        System.out.print(Arrays.toString(target(arr,2)));
    }
}
