package com.wen.test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test1 {
    /*
    *  按要求在 main 方法中完成以下功能：
    定义一个长度为 5 的 int 型数组 arr，
    提示用户输入 5 个 1-60 之间的数字作为数组元素
    生成 2-10（范围包含 2 和 10）之间的随机数 num
    遍历数组 arr,筛选出数组中不是 num 倍数 的元素并输出
    并输出数组中所有元素的平均值
    PS：输入的数组元素范围包括 1 和 60，不需要代码判断

    */

    public static void main(String[] args) {
        //定义一个长度为 5 的 int 型数组 arr，
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        //提示用户
        for (int i = 0; i <arr.length ; i++) {
            System.out.println("输入"+(i+1)+" 个 1-60 之间的数字作为数组元素");
            arr[i] = sc.nextInt();

        }
//        System.out.println(Arrays.toString(arr));
        // 生成 2-10（范围包含 2 和 10）之间的随机数 num
        int num = random.nextInt(9)+2;

        // 遍历数组 arr,筛选出数组中不是 num 倍数 的元素并输出
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if(arr[i]%num!=0){
                System.out.println(arr[i]);
            }
        }
        int avg = sum/arr.length;
        System.out.println("所有元素的平均值:"+avg);

    }

}
