package com.simba.service.impl;

import com.simba.service.Sort;

/**
 * 冒泡排序
 * 选择第一个数，和后面的数进行对比，如果大于后面的数，进行对换，然后一次执行下去，
 * 第一次比较n-1次，第二次比较n-2次，最后一次比较一次
 * 时间复杂度为，最多是O(n^2)顺序完全倒叙,最少是O(n),只需要一次排序，平均复杂度O(n^2)
 * 属于稳定排序
 */
public class BubbleSort implements Sort {

  @Override
  public int[] sort(int[] sortArr) {
    int len = sortArr.length;
    while(len>0){
      for(int i= 0;i<len-1;i++){
        if(sortArr[i]>sortArr[i+1]){
          int temp = sortArr[i];
          sortArr[i] = sortArr[i+1];
          sortArr[i+1] = temp;
        }
      }
      len --;
    }
    return sortArr;
  }


}
