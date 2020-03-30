package com.hua.shardingjdbc;

import java.util.Arrays;

/**
 * @author 倪勤华
 * @date 2020-03-20 18:59
 */
public class Test1 {
    public static void main(String[] args) {
        String street1="33 Rodger Drive";
        String street2="Rutherglen";
        System.out.println(String.format("street1: %s",street1));
        System.out.println(String.format("street2: %s",street2));
        String[] address =new String [3];
        String[] words = (street1+" "+street2).split(" ");
        int index=0;//address数组的下标
        for (int i=0;i<words.length;++i){
            if (address[index]==null)
                address[index]=words[i];
            else if(address[index].length()+words[i].length()+1<=10)//+1代表空格
                address[index]+=" "+words[i];
            else
                address[++index]=words[i];
        }


        print(address);
    }
    //一家网店要求用户把地址写成两行，每行不能超过15个字母。现在，地址将打印成3行在发货单上，每行不能超过10个字母。
    private static void print(String[] address) {

        Arrays.stream(address).forEach(System.out::println);
    }
}
