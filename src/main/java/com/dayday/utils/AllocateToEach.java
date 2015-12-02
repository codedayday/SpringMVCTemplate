package com.dayday.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by dayday on 2015/11/3.
 * 将count平均分配到一个长度为n的数组中,数组每个元素最后分配允许的最大值各自是有限制的
 * <br> 比如count=10,数组为{4, 5, 6}
 * <br> 最后结果为{4, 3, 3}
 * <br> 也就是数组第一个位置最后最多分配的数为4,超过4就不能再分配了,只能分配到其他位置上
 * <br> 如果数组所允许的最大值不足count,那么超出的部分就不分配了
 */
public class AllocateToEach {

    public static void main(String[] args) {
        int[] result = allocate(10, new int[]{1, 1, 1, 1});
        System.out.println(Arrays.toString(result));
    }

    public static int[] allocate(int count, int[] eachCount) {
        int length = eachCount.length;
        int[] result = new int[length];
        if (length > 0) {
            ArrayList<Integer> hasMore = new ArrayList<Integer>();
            for (int i = 0; i < eachCount.length; i++) {
                if (eachCount[i] > 0) {
                    System.out.println(i);
                    hasMore.add(i);
                }
            }
            allocate(eachCount, result, count, hasMore);
        }
        return result;
    }

    public static void allocate(int[] eachCount, int[] result, int left, ArrayList<Integer> hasMore) {
        int average;
        int remainder;
        if (left > 0 && hasMore.size() > 0) {
            Iterator<Integer> iterator = hasMore.iterator();
            average = left / hasMore.size();
            remainder = left % hasMore.size();
            left = 0;
            if (average > 0) {
                left = allocateAverage(eachCount, result, left, average, iterator);
                left += remainder;
                if (left > 0 && hasMore.size() > 0) {
                    allocate(eachCount, result, left, hasMore);
                }
            } else if (remainder > 0) {
                allocateAverage(eachCount, result, -remainder, 1, iterator);
            }
        }
    }

    private static int allocateAverage(int[] eachCount, int[] result, int left, int average, Iterator<Integer> iterator) {
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            int min = Math.min(average, eachCount[next]);
            result[next] += min;
            System.out.println(next + "_" + min);
            int difference = average - min;
            if (difference > 0) { //商处理
                left += difference;
            } else if (left < 0) { //余数处理
                left += min;
                if (left == 0) return 0;
            }
            eachCount[next] = eachCount[next] - min;
            if (eachCount[next] <= 0) {
                iterator.remove();
            }
        }
        return left;
    }
}
