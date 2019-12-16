package com.simba.service.impl;

import com.simba.service.Sort;

/**
 * 快速排序
 * 基本思想：选择一个数为基准数（一般选择数组第一个，但是为了效率高需要认真选择排序基准数）
 * 首先从右往左依次和基准数比较，如果比基准数大，则继续往左移动。如果比基准数小，则和基准数换位置
 * 如果右边和基准数替换位置，则开始从左边往右边比较，如果比基准数小继续往右移动，如果比基准数大，则和基准数变换位置
 * 然后继续从右往左移动，比较，然后继续从左往右,知道左右两边相等
 * 然后分别遍历左边数组和右边数组
 *
 * 排序的时间复杂度为（nlog(n)）
 * 属于稳定排序
 */
public class QuickSort implements Sort {

  @Override
  public int[] sort(int[] sortArr) {
    return quickSort(sortArr,0,sortArr.length);
  }

  private int[] quickSort(int[] arr,int start ,int end){
    int key = arr[start];
    int  i = start;
    int  j =end ;
    while(i<j){
      while(i<j) {
        if(arr[j]<key){
          int k = arr[i];
          arr[i] = arr[j];
          arr[j] = k;
          break;
        }else{
          j--;
        }
      }
      while(i<j){
        if(arr[i]>key){
          int t = arr[i];
          arr[i] = arr[j];
          arr[j] =t;
          break;
        }else{
          i++;
        }
      }
    }
    if(start<i-1){
      arr = quickSort(arr,start,i-1);
    }
    if(end>j+1){
      arr= quickSort(arr,j+1,end);
    }
    return arr;
  }

  public int[] qsort(int arr[],int start,int end) {
    int pivot = arr[start];
    int i = start;
    int j = end;
    while (i<j) {
      while ((i<j)&&(arr[j]>pivot)) {
        j--;
      }
      while ((i<j)&&(arr[i]<pivot)) {
        i++;
      }
      if ((arr[i]==arr[j])&&(i<j)) {
        i++;
      } else {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    if (i-1>start) {
      arr=qsort(arr,start,i-1);
    }
    if (j+1<end) {
      arr=qsort(arr,j+1,end);
    }
    return arr;
  }



}
