package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(consoleReader.readLine()));
        ArrayList<String> words = new ArrayList<>();
        while (fileReader.ready()){
            words.addAll(Arrays.asList(fileReader.readLine().split(" ")));
        }
        StringBuilder result = getLine(words.toArray(new String[0]));
        System.out.println(result.toString());
    }

    public static StringBuilder getStringBuilder(String[] words, int startWordIndex){
        StringBuilder stringBuilder = new StringBuilder();
        if(words == null || words.length==0) return stringBuilder;
        ArrayList<String> wordsList = new ArrayList<>();
        wordsList.addAll(Arrays.asList(words));

        stringBuilder.append(" " + wordsList.get(startWordIndex) + " ");
        wordsList.remove(startWordIndex);
        for(int i=0;i<wordsList.size();i++){
            if(Character.toUpperCase(wordsList.get(i).charAt(0)) == Character.toUpperCase(stringBuilder.charAt(stringBuilder.length()-2))) {
                stringBuilder.append(wordsList.get(i) + " ");
                wordsList.remove(i);
                i=-1;
            }
            else if(Character.toUpperCase(wordsList.get(i).charAt(wordsList.get(i).length()-1)) == Character.toUpperCase(stringBuilder.charAt(1))){
                stringBuilder.insert(0, " " + wordsList.get(i));
                wordsList.remove(i);
                i=-1;
            }

        }

        stringBuilder = new StringBuilder(stringBuilder.toString().trim());
        return stringBuilder;
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder max = new StringBuilder();
        for(int i=0;i<words.length;i++){
            StringBuilder current = getStringBuilder(words, i);
            if(max == null || max.length() < current.length())
                max = current;
        }

        return max;

    }
}
