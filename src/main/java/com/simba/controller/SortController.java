package com.simba.controller;


import com.simba.service.Sort;
import com.simba.service.impl.BubbleSort;
import com.simba.service.impl.InsertionSort;
import com.simba.service.impl.SelectionSort;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;
import org.junit.Test;
import org.apache.commons.io.IOUtils;

public class SortController {


  @Test
  public void testSort(){
//    Sort sort = new BubbleSort();
//    Sort sort = new SelectionSort();
//    Sort sort = new InsertionSort();
    InsertionSort sort = new InsertionSort();
    int arr[] = sort.binaryInserionSort(initArr());
    scan(arr);
  }

  private int[] initArr(){
    int[] arr ={4,8,2,5,1,9,11,6,3,10,7};
    return arr;
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



}
