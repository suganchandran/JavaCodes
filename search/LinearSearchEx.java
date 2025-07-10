package dsapractice.search;

import java.time.LocalDateTime;

public class LinearSearchEx {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());

        long[]a=new long[1000000000];

        for (long i=0;i<1000000000;i++){
            a[(int)i]=i;
        }

        int target=9999999;

        for (int i=0;i<a.length;i++){

            if(a[i]==target){
                System.out.println("index: "+i +" "+ LocalDateTime.now());
                return;
            }
        }
        System.out.println(-1);
    }
}
