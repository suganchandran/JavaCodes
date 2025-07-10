package dsapractice.search;

import java.time.LocalDateTime;

public class BinarySearchEx {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());


        int[]a=new int[10000000];

        for (int i=0;i<10000000;i++){
            a[i]=i;
        }

        int t=9999999;

        int l=0;
        int r=a.length-1;


        while (l<=r){

            int m=(l+r)/2;

            if (a[m]==t){
                System.out.println("index: "+m+" "+ LocalDateTime.now());
                return;
            }
            else if (a[m]<t) {
                m=m+1;
                l=m;
            } else if (a[m]>t) {
                m=m-1;
                r=m;

            }
        }
    }
}
