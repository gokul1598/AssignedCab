package com.example.demo.entity;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
  public static void main(String[] args) {
    Date date = new Date();
    // Pattern 
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
    System.out.println("Time in 12 Hour format - " + sdf.format(date));
  }
}