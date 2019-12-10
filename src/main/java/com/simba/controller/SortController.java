package com.simba.controller;


import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Random;
import org.junit.Test;

public class SortController {


  @Test
  public void descSort(){
    int[] list = initList(100);
    scan(list);
    LocalDateTime localDateTime = LocalDateTime.now();
    long startTime = localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    for(int i=0;i<list.length;i++){
      int j = list.length-1;
      while (i<=j-1){
        if(list[i] >list[j]){
          int k = list[i];
          list[i] = list[j];
          list[j] = k;
          break;
        }
        j--;
      }
    }
    LocalDateTime endLocalDateTime = LocalDateTime.now();
    long endTime = endLocalDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    scan(list);
    System.out.println(endTime-startTime);
  }
  public int[] initList(int length){
    int[] list = new int[length];
    for (int i =0;i<length;i++){
      list[i] =(int)(Math.random()*100);
    }
    return list;
  }
  public void scan(int[] list){
    for (int i = 0 ;i<list.length;i++){
      System.out.print(list[i]+",");
    }
    System.out.println("===========");
  }
}
