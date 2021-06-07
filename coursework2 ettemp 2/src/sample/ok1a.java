package sample;

import java.sql.SQLOutput;

public class ok1a {
    public static void main(String[] args){
        String a="sunshine";
        final int mid = a.length() / 2;
        String[] parts = {a.substring(0, mid),a.substring(mid)};
        int i=0;
        String ab="";
        int ad =mid;
        while(i!=mid){
            System.out.println(ab);
            i=i+1;
            ab=ab+parts[0].substring(ad-1,ad);
            ab+=parts[1].substring(ad-1,ad);
            ad=ad-1;



        }
        System.out.println(ab);

    }


}
