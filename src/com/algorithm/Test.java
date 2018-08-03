package com.algorithm;

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
    public static void main(String [] args){
        String str = "aaaabbcccddeeeeefghij";
        System.out.print(Compression(str));
    }
}
