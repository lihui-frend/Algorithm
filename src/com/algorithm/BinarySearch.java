package com.algorithm;

public class BinarySearch {

    public static int search(int arr[],int index,int low,int high){
        if (index<arr[low]||index>arr[high]||low>high){
            return -1;
        }
        int middle = (low+high)/2;
        if (index<arr[middle]){
            return search(arr,index,low,middle-1);
        }else if(index>arr[middle]){
            return search(arr,index,middle+1,high);
        }else {
            return middle;
        }
    }

    public static int search(int arr[],int index){
        int low = 0;
        int high = arr.length-1;
        while (low<=high){
            int middle = (low+high)/2;
            if (index==arr[middle]){
                return middle;
            }else if (index<arr[middle]){
                high = middle - 1;
            }else {
                low = middle + 1;
            }
        }
        return -1;
    }
    public static void main(String [] args){
        int arr[] = {3,6,8,12,17,26,44,100};
        System.out.println(search(arr,12));
        System.out.print(search(arr,100,0,arr.length-1));
    }
}
