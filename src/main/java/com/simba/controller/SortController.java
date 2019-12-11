package com.simba.controller;


import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Random;
import org.junit.Test;
import org.apache.commons.io.IOUtils;

public class SortController {


  @Test
  public void testReturn(){
    int i = test(10);
    System.out.println(i);
  }

  public int test(int i){
    int count=0;
    i+=50;
    if(i >= 160){
      return count;
    }
    if(i<120){
      count = test(i);
    }
    return count;
  }

  @Test
  public void descSort(){
    int[] list = initList(100);
//    int[] list = {5,3,7,6,4,1,0,2,9,10,8};
    scan(list);
    LocalDateTime localDateTime = LocalDateTime.now();
    long startTime = localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
//    int[] sortArr = descSort(list,0,list.length-1);
    int[] sortArr = qsort(list,0,list.length-1);
    LocalDateTime endLocalDateTime = LocalDateTime.now();
    long endTime = endLocalDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    scan(sortArr);
    System.out.println(endTime-startTime);
  }
  public int[] initList(int length){
    int[] list = new int[length];
    for (int i =0;i<length;i++){
      list[i] =(int)(Math.random()*100);
    }
    return list;
  }
  private void scan(int[] list){
    for (int i = 0 ;i<list.length;i++){
      System.out.print(list[i]+",");
    }
    System.out.println("===========");
  }

  private void exportData(int[] list){
    try {
      OutputStream outputStream = new FileOutputStream("e:\\output.txt");
      IOUtils.write(Arrays.toString(list),outputStream,"utf-8");
    }catch (Exception e){
      throw new RuntimeException(e.getMessage());
    }
  }

  private void exportDataAppend(int[] list){
    try {
      FileWriter fileWriter = new FileWriter("e:\\output.txt",true);
      fileWriter.write(Arrays.toString(list));
      fileWriter.write("/r/n");
      fileWriter.close();
    }catch (Exception e){
      throw new RuntimeException(e.getMessage());
    }
  }
  private int[] descSort(int[] arr,int start ,int end){
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
      arr = descSort(arr,start,i-1);
    }
    if(end>j+1){
      arr= descSort(arr,j+1,end);
    }
    return arr;
  }

  public int[] qsort(int arr[],int start,int end) {
    int pivot = arr[start];
    exportDataAppend(arr);
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
