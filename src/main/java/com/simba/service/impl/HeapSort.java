package com.simba.service.impl;

import com.simba.service.Sort;
import java.util.Arrays;

/**
 * 堆排序
 * 基本思想：将数据看成完成二叉树，按照完全二叉树来排序
 *
 * 排序的时间复杂度为
 * 属于稳定排序
 */
public class HeapSort implements Sort {

  @Override
  public int[] sort(int[] sortArr) {
    //拷贝源数据
    int[] arr = Arrays.copyOf(sortArr,sortArr.length);
    int len = arr.length;
    buildMaxHeap(arr,len);
    for(int i =len-1;i>0;i++){
      swap(arr,0,i);
      len--;
      heapify(arr,0,len);
    }

    return arr;
  }
  //构建一个大顶堆
  private void buildMaxHeap(int[] arr,int len){
    for (int i=(int)Math.floor(len/2);i>=0;i--){
      heapify(arr,i,len);
    }
  }
  //
  private void heapify(int[] arr ,int i ,int len){
    int left = i*2 +1;
    int right = i*2 +2;
    int largest = i;
    if(arr[left]>arr[largest] && left <len){
      largest = left;
    }
    if(arr[right]>arr[largest] && right <len){
      largest = right;
    }
    if(largest != i){
      swap(arr,i,largest);
      heapify(arr,largest,len);
    }
  }
  //交换
  private void swap(int[] arr ,int i,int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
