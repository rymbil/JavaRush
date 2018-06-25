package com.javarush.task.task20.task2026;

import java.util.ArrayList;

public class MyRectangle {
    private ArrayList<MyPoint> points;
    public MyRectangle(MyPoint point){
        points = new ArrayList<>();
        points.add(point);
    }

    public boolean tryAddPoint(MyPoint point){
        boolean added = false;
        for(MyPoint currentPoint : points){
            if(point.isNear(currentPoint)){
                added = true;
                break;
            }
        }
        return added;
    }

    public void addPoint(MyPoint point){
        boolean added = false;
        for(MyPoint currentPoint : points){
            if(point.isNear(currentPoint)){
                points.add(point);
                break;
            }
        }
    }

}
