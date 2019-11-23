package com.example.sort.demo;

import java.util.Arrays;

/**
 * 冒泡排序
 * 相邻元素两两比较，
 * 每一路结束后会在队尾的有序区域多一个元素
 * 一共需要遍历size-1轮
 * 时间复杂度O(n²)
 */
public class BubbleSortDemo {


    public static void main(String[] args) {
        int[] demo = {17, 5, 12, 8, 15, 6, 19, 10, 18, 10, 3, 9, 14, 2, 11, 4, 1, 16, 7, 13};
//        bubbleSortV1(demo);
//        bubbleSortV2(demo);
        bubbleSortV3(demo);
    }

    /**
     * v1  未优化
     *
     * @param demo
     */
    public static void bubbleSortV1(int[] demo) {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < demo.length - 1; i++) {
            for (int j = 0; j < demo.length - i - 1; j++) {
                //内层循环如果写成demo.length-1也可以，只是相当于把队尾的有序区域也拿进来参与比较了
                if (demo[j] > demo[j + 1]) {
                    int temp = demo[j];
                    demo[j] = demo[j + 1];
                    demo[j + 1] = temp;
                }
            }
        }
        System.out.println("V1用时：" + (System.currentTimeMillis() - t1));

        //输出结果
        System.out.println(Arrays.toString(demo));
    }

    /**
     * 初步优化
     * 如果某一轮遍历中没有发生过交换，说明数组已经有序，剩下的遍历可以不必进行
     *
     * @param demo
     */
    public static void bubbleSortV2(int[] demo) {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < demo.length - 1; i++) {
            //初始化一个标记，认为当前数组是有序的
            boolean isSorted = true;
            for (int j = 0; j < demo.length - i - 1; j++) {
                if (demo[j] > demo[j + 1]) {
                    int temp = demo[j + 1];
                    demo[j + 1] = demo[j];
                    demo[j] = temp;
                    //如果发生了交换，说明数组是无序的
                    isSorted = false;
                }
            }
            //如果某一个回合遍历结束之后数组是有序的，那么直接结束遍历
            if (isSorted) {
                System.out.println("在第" + (i + 1) + "轮遍历后数组已经有序");
                break;
            }
        }
        System.out.println("V2用时：" + (System.currentTimeMillis() - t1));
        //输出结果
        System.out.println(Arrays.toString(demo));
    }

    /**
     * 再次优化
     * 以上，第i轮遍历后队尾的i个元素是有序区域，这只是一般情况，实际有序元素的格式会大于i
     * 在每一轮遍历时，最后发生交换的位置，就是实际有序区域开始的位置，再往后就都是有序的
     *
     * @param demo
     */
    public static void bubbleSortV3(int[] demo) {
        long t1 = System.currentTimeMillis();
        //定义无序区域的下标，内部循环中相邻元素比较时只需要比较到这个位置
        int sortBorder = demo.length - 1;
        //定义最后一次交换的位置
        int lastExchangeIndex = 0;
        for (int i = 0; i < demo.length - 1; i++) {
            //初始化一个标记，认为当前数组是有序的
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                if (demo[j] > demo[j + 1]) {
                    int temp = demo[j];
                    demo[j] = demo[j + 1];
                    demo[j + 1] = temp;
                    //如果发生了交换，说明数组是无序的
                    isSorted = false;
                    //覆盖最后交换位置
                    lastExchangeIndex = j;
                }
            }
            //将本次最后交换位置定义为下一次遍历的终点位置，即无序区域的结束位置
            sortBorder = lastExchangeIndex;
            //如果某一个回合遍历结束之后数组是有序的，那么直接结束遍历
            if (isSorted) {
                System.out.println("在第" + (i + 1) + "轮遍历后数组已经有序");
                break;
            }
        }
        System.out.println("V3用时：" + (System.currentTimeMillis() - t1));

        //输出结果
        System.out.println(Arrays.toString(demo));

    }

    /**
     * 此外，还有鸡尾酒排序
     * 是基于冒泡排序的改进，在每一轮遍历中，是双向进行比较交换的
     * 适用于数组元素大部分已经有序的情况
     */
}
