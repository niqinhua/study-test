package com.hua.test;

/**
 * @author 倪勤华
 * @date 2020-02-06 16:32
 */
public class Test {


    public static void main(String[] args) {
        String a="aaa.ddsa.cdsd";
        String[] split = a.split("\\.");
        System.out.println(split);

    }

    //    private static int count(int n){
//        if(n==1){
//            return 1;
//        }else if(n==2){
//            return 2;
//        }else{
//            return count(n-1)+count(n-2);
//        }
//    }
    private static int count(int n) {
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }

        int a1=1;
        int a2=2;
        int sum =0;
        for (int i = 3; i <=n; i++) {
                sum=a1+a2;
                a1=a2;
                a2=sum;

        }
        return sum;
    }


}
