package dsapractice.sorting;

public class SelectionSort {

    public static void main(String[] args) {

        System.out.println(System.currentTimeMillis());

        int []a=new int[100000];

        for (int l=100000-1;l>1;l--){
            a[l]=l;
        }

        for (int i=0;i<a.length;i++){

//            int c=0;

            for (int j=i+1;j<a.length;j++){

                if (a[i]>a[j]){
                   // c =1;
                    int k=a[i];
                    a[i]=a[j];
                    a[j]=k;
                }
            }
    
//            if (c==0)
//                break;
        }

        System.out.println(System.currentTimeMillis());
    }



}
