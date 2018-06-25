package com.javarush.task.task20.task2026;

import java.util.ArrayList;

/*
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }



    public static int getRectangleCount(byte[][] a) {
        MyRectangleManager myRectangleManager = new MyRectangleManager();
        int M = a.length;
        for(int y=0; y<M;y++){
            for(int x=0;x<M;x++){
                if(a[y][x] == 1){
                    myRectangleManager.addPoint(x,y);
                }
            }
        }
        return myRectangleManager.getRectancleCount();
    }
}
