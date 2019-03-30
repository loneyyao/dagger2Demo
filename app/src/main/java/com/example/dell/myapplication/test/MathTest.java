package com.example.dell.myapplication.test;

/**
 * create by lizejun
 * date 2018/8/23
 */
public class MathTest {
    public static void main(String args[]){
        int preSum=1;
        int prepreSum = 1;
        int month=1;
        int sum=1;
        while(month<=20){
            if(month>=3){
                prepreSum = preSum;
                preSum =sum;
                sum=prepreSum+preSum;
            }else{
                sum=prepreSum;
            }
            System.out.println("sum = " + sum);
            month++;
        }
    }
}
