package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        string += " ";
        if(string == null) throw new TooShortStringException();
        int firstS = string.indexOf(' ');
        if(firstS == -1) throw new TooShortStringException();
        int fourthS = firstS;
        for(int i=0;i<4;i++){
            fourthS = string.indexOf(' ', fourthS+1);
            if(fourthS == -1) throw new TooShortStringException();
        }
        return string.substring(firstS+1, fourthS);
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
