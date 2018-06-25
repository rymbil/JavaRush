package com.javarush.task.task20.task2026;

import java.util.ArrayList;

public class MyRectangleManager {
    ArrayList<MyRectangle> rectangles;
    public MyRectangleManager(){
        rectangles = new ArrayList<>();
    }

    public void addPoint(int x, int y){
        MyPoint newPoint = new MyPoint(x,y);
        boolean added = false;
        for(MyRectangle myRectangle : rectangles){
            if(myRectangle.tryAddPoint(newPoint)){
                myRectangle.addPoint(newPoint);
                added = true;
                break;
            }
        }

        if(!added)
            rectangles.add(new MyRectangle(newPoint));
    }

    public int getRectancleCount(){
        return rectangles.size();
    }
}
