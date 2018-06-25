package com.javarush.task.task20.task2026;

public class MyPoint {
    private int x,y;
    public MyPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean isNear(MyPoint point){
        if((point.x == x + 1) && (point.y == y)) return true; //point правее
        if((point.x == x - 1) && (point.y == y)) return true; //point левее
        if((point.y == y + 1) && (point.x == x)) return true; //point ниже
        if((point.y == y - 1) && (point.x == x)) return true; //point выше
        return false;
    }

    public boolean equals(MyPoint point){
        if(this.y == point.y && this.x == point.x)
            return true;
        else
            return false;
    }
}
