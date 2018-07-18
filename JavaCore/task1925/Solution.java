package com.javarush.task.task19.task1925;

/*
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));

        ArrayList<String> list = new ArrayList<>();
        while (fileReader.ready()){
            list.add(fileReader.readLine());
        }

        fileReader.close();
        boolean first = true;
        for(int i=0; i<list.size();i++) {
            String line = list.get(i);
            String[] words = line.split(" ");
            for (int j = 0; j < words.length; j++) {
                if (words[j].length() > 6) {
                    if(first){
                        fileWriter.write(words[j]);
                        first = false;
                    }
                    else {
                        fileWriter.write("," + words[j]);
                    }

                }
            }
        }

        fileWriter.close();
    }
}
