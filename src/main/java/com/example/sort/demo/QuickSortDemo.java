package com.example.sort.demo;

import java.util.Arrays;

/**
 * 快速排序
 * 分治法：
 * 每一轮挑选一个基准元素，其他比它大的元素全部移动到右边，比它小的元素全部移动到左边
 * 每一轮操作n次，一共需要logn轮，时间复杂度O(nlogn)
 * 重点在于：
 * 【基准元素 pivot 的选择】此例中取数组的第一个元素为基准元素
 * 【元素的交换】采用单边循环法
 * <p>
 * 单边循环法：
 * 首先选定第一个元素为基准元素，设定一个mark指针指向数列起始位置，mark指针代表小于基准元素的区域边界
 * 从基准元素的下一个开始遍历
 * 大于基准元素，继续next
 * 小于基准元素，1.mark指针右移一位，因为小于基准元素的区域增大了一位；2.将最新遍历到的元素和mark指针位置的元素交换
 */
public class QuickSortDemo {

    public static void main(String[] args) {
        int[] demo = {4, 3, 7, 5, 6, 2, 8, 1};
        quickSortDemo(demo, 0, demo.length - 1);
        System.out.println(Arrays.toString(demo));
    }

    /**
     * @param demo
     * @param startIndex
     * @param endIndex
     */
    public static void quickSortDemo(int[] demo, int startIndex, int endIndex) {
        //关于这里的这个判断:
        //假如当前demo基准元素排在第二个，被切分后左边数组只有一个元素，此时pivot下标为1，那么startIndex = endIndex = 0
        //假如当前demo基准元素排在第一个，被切分后左边数组没有元素，pivot下标为0，那么startIndex0，endIndex=-1
        //这两种情况其实就是快速排序的终止情况，即某一段子数组只有一个元素或没有元素
        if (startIndex >= endIndex) {
            return;
        }
        //用这个方法进行单边循环，并且返回基准元素循环后的位置
        int pivot = partition(demo, startIndex, endIndex);

        //递归，将上面方法切开的前一半和后一半分别递归
        quickSortDemo(demo, startIndex, pivot - 1);
        quickSortDemo(demo, pivot + 1, endIndex);
    }

    /**
     * 分治，采用单边循环法交换元素
     *
     * @param demo
     * @param startIndex
     * @param endIndex
     * @return 返回基准元素位置
     */
    public static int partition(int[] demo, int startIndex, int endIndex) {
        //把第一个元素的位置设置为mark的位置
        int mark = startIndex;
        //去第一个元素为基准元素
        int pivot = demo[mark];
        //从第二个元素开始遍历
        for (int i = startIndex + 1; i <= endIndex; i++) {
            //如果比基准元素小，就把mark标记右移一位，然后将当前遍历到的元素和mark位置的元素交换
            if (demo[i] < pivot) {
                mark++;
                int temp = demo[i];
                demo[i] = demo[mark];
                demo[mark] = temp;
            }
        }
        //遍历完成后，把即一个元素(基准元素)和mark位置的元素交换
        demo[startIndex] = demo[mark];
        demo[mark] = pivot;
        return mark;
    }
}
