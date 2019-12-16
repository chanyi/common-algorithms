package com.simba.service.impl;

import com.simba.service.Sort;

/**
 * 选择排序
 * 选出n个中最小的元素和第一个换位，然后再选出n-1个中最小的元素，和第二位的元素换位，依次执行。。。
 * 时间复杂度O(n^2)
 * 交换次数比冒泡算法要少，因为交换比比较要耗cpu，所以选择排序比冒泡排序要快
 * 属于不稳定排序 比如：5 8 5 2 9，我们知道第一遍选择第1个元素5会和2交换，那么原序列中两个5的相对前后顺序就被破坏了
 */
public class SelectionSort implements Sort {

  @Override
  public int[] sort(int[] sortArr) {
    for(int i =0 ;i< sortArr.length-1;i++){
      int min = i;
      for(int j=i;j<sortArr.length-1;j++){
        if(sortArr[min]>sortArr[j+1]){
          min = j+1;
        }
      }
      //交换第i为和最小数所在的位置min
      int temp = sortArr[i];
      sortArr[i] = sortArr[min];
      sortArr[min] = temp;
    }
    return sortArr;
  }
}
