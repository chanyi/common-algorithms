package com.simba.service.impl;

import com.simba.service.Sort;
import java.sql.Array;
import javax.sound.midi.Soundbank;
import sun.security.util.Length;

/**
 * 插入排序
 * 在给好顺序的序列中插入一个数，然后序列依然保持有序
 * 从第一个元素开始，依次找到后面小于前面一位数，然后从后往前的插入
 * 时间复杂度O(n^2)
 * 属于稳定排序
 */

public class InsertionSort implements Sort {

  /**
   * 直接插入排序
   * @param sortArr
   * @return
   */
  @Override
  public int[] sort(int[] sortArr) {
    int j = 0;
    int temp =0;
    for(int i =1 ;i<sortArr.length;i++){
      //从第一个开始，找到需要插入的位置，并记录下来
      if(sortArr[i] < sortArr[i-1]){
         temp = sortArr[i];
         for(j = i-1;j>=0;j--){
           if(sortArr[j]>temp){
             sortArr[j+1]= sortArr[j];
           }
           else{
             break;
           }
         }
        sortArr[j+1] = temp;
      }
    }
    return sortArr;
  }

  /**
   * 折半插入排序
   * 是直接插入排序的优化方案，在查找插入位置的地方不使用顺序查找，而是使用折半查找
   * @param sortArr
   * @return
   */
  public int[] binaryInserionSort(int[] sortArr){
    int j = 0;
    int temp =0;
    for(int i =1 ;i<sortArr.length;i++){
      //从第一个开始，找到需要插入的位置，并记录下来
      if(sortArr[i]<sortArr[i-1]){
        temp = sortArr[i];
        //按照折半法找到排序的位置
        int max = i-1;
        int min = 0 ;
        int mid = 0;
        while (min<=max){
          mid = (max+min)/2;
          if(mid == 0){
            mid = -1 ;
            break;
          }
          if(sortArr[mid]<= temp && sortArr[mid+1]>=temp){
            j = mid;
            break;
          }else if(sortArr[mid]>temp){
            max = mid;
          }else if(sortArr[mid]<temp){
            min = mid;
          }else{

          }
        }
        for(j=i-1;j>mid;j--){
          sortArr[j+1] = sortArr[j];
        }
        sortArr[mid+1] = temp;
      }
    }
    return sortArr;
  }

  /**
   * 希尔插入排序
   * 选择一个增量序列（最好是互为质数，序列的选择和排序的效率有关）
   * 按照增量序列给排序数组的对应位置插入排序
   * 例如：增量序列为（5,3,1）
   * 则先给下标为5的倍数的位置元素排序（如：给arr[0],arr[5],arr[10],arr[15]...这些元素插入排序）
   * 然后给下标为3的倍数的位置元素排序
   * 最后给下标为1的倍数（所有位置）的元素排序
   * 要求：
   *    增量序列的最后一位一定要是1
   * 时间复杂度为O(n^2/3)
   * 非稳定排序算法
   *
   * @param sortArr
   * @return
   */
  public int[] InsertionSort(int[] sortArr){
    //选择一个增量序列
    int[] increaseOrder = {5,3,1};
    //按照增量序列排序
    for(int i =0;i<increaseOrder.length;i++){
      for (int j =0 ;j <sortArr.length;j+=increaseOrder[i]){
        //拿到排序的数列
//        if()
      }
    }
    return sortArr;
  }
}
