package dsapractice.sorting;

import java.util.Arrays;

public class MergeSort {

    static int[]arr={6,8,9,2,1,3,4};

    public static void main(String[] args) {

        System.out.println("Orginal array: ");
        printArray();
        mergeSort(arr,0, arr.length-1);
        System.out.println("sorted array: ");
        printArray();


    }


    public static void mergeSort(int[]arr,int left,int right){

        if(left<right){

            int mid=left+(right-left)/2;

            System.out.println("Mid value: "+mid);

            System.out.println("Array : "+ Arrays.toString(Arrays.copyOfRange(arr,left,mid+1)));
            mergeSort(arr,left,mid);

            System.out.println("Arrays: "+Arrays.toString(arr));

            System.out.println("Arrays : "+Arrays.toString(Arrays.copyOfRange(arr,mid+1,right+1)));
            mergeSort(arr,mid+1,right);

            System.out.println("Array right : "+Arrays.toString(arr));
            merge(arr, left,mid ,right);
        }


    }

    public static void merge(int[]arr,int left,int mid,int right){

        System.out.println("Performing Merger Ops [LEFT]"+ left+" Mid "+mid+" [RIGHT]"+ right );

        int  n1=mid-left+1;
        int n2=right-mid;

        int[]leftArray=new int [n1];
        int[]rightArray=new int [n2];

        System.out.println(" N1 ["+n1 +"] N2["+n2+"]");

        for (int i=0;i<n1;i++){
            leftArray[i]=arr[left+i];
        }
        for (int j=0;j<n2;j++){
            rightArray[j]=arr[mid+1+j];
        }

        System.out.println("Merging left "+Arrays.toString(leftArray)+" right "+Arrays.toString(rightArray));

        int i=0,j=0,k=left;

        while (i<n1 && j<n2){

            if (leftArray[i]<=rightArray[j]){

                arr[k]=leftArray[i];
                System.out.println("Copied sorted value of orginal array: "+leftArray[i]);
                i++;
            }

            else {
                arr[k]=rightArray[j];
                System.out.println("Copied sorted value org Array: "+rightArray[j]);
                j++;
            }
            k++;

        }

        while (i<n1){

            arr[k]=leftArray[i];
            System.out.println("Copied leftArray: "+leftArray[i]);
            i++;
            k++;

        }

        while (j<n2){

            arr[k]=rightArray[j];
            System.out.println("Copied rightArray: "+rightArray[j]);
            j++;
            k++;
        }
    }

    public static void printArray(){
        for (int num:arr){
            System.out.print(num+" ");
        }

        System.out.println();
    }
}
