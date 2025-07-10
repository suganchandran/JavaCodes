package dsapractice.sorting;

import java.util.Arrays;

public class QuickSort {

    static  int[] arr={8,7,9,3,5,1};

    public static void main(String[] args) {

        System.out.println("orginal array: ");
        printArray(arr);

        quickSort(arr,0,arr.length-1);

        System.out.println("sorted array: ");
        printArray(arr);

    }

    public  static  void quickSort(int[] arr,int low ,int high){

        if (low<high){

            System.out.println("pivot index before partition : "+high);
            int pivotInx=partition(arr,low,high);
            System.out.println("pivot index: "+pivotInx);

            quickSort(arr,low,pivotInx-1);

            System.out.println("pivot index : "+pivotInx);
            quickSort(arr,pivotInx+1,high);
        }
    }

    public static  int  partition(int[]arr,int low ,int high){

        int pivot=arr[high];
        int i=low-1;

        System.out.println("Input arrays in partition :"+ Arrays.toString(Arrays.copyOfRange(arr,low,high+1)));

        for (int j=low;j<high;j++){

            if (arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }

        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;

        printArray(arr);

        return i+1;
    }

    public  static  void printArray(int[] a){

        for (int x:a){
            System.out.print(x+" ");
        }


    }


}
