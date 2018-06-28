package com.javarush.task.task20.task2027;

import java.util.ArrayList;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        System.out.println(detectAllWords(crossword, "home", "same"));
        /*
Ожидаемый результат
home - (5, 3) - (2, 0) справа снизу вверх налево
same - (1, 1) - (4, 1) слева на право

         */
    }
    public static void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print((char)matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static ArrayList<Word> getWordOne(int[][] crossword, String word, int[][] wordMatrix, int startX, int startY, int endX, int endY){
        ArrayList<Word> words = new ArrayList<Word>();
        int yMax = crossword.length-1;
        int xMax = crossword[0].length-1;
        //printMatrix(wordMatrix);
        //System.out.println();
        while(true){
            if(Matrix.compare(wordMatrix, crossword)){
                Word wordTemp = new Word(word);
                wordTemp.setStartPoint(startY, startX);
                wordTemp.setEndPoint(endY, endX);
                words.add(wordTemp);
            }

            if(Math.max(startX, endX)<xMax){
                startX++;
                endX++;
                Matrix.shiftRight(wordMatrix);
                //printMatrix(wordMatrix);
                //System.out.println();
            }
            else{
                while(Math.min(startX, endX)>0){
                    Matrix.shiftLeft(wordMatrix);
                    endX--;
                    startX--;
                }

                if(Math.max(startY, endY)<yMax){
                    startY++;
                    endY++;
                    Matrix.shftDown(wordMatrix);
                    //printMatrix(wordMatrix);
                    //System.out.println();
                }
                else
                    break;

            }
        }

        return words;
    }

    public static ArrayList<Word> getWordOneHorizontal(int[][] crossword, String word, boolean reverse){
        ArrayList<Word> words = new ArrayList<Word>();
        int yMax = crossword.length-1;
        int xMax = crossword[0].length-1;
        String newWord = word;
        if(word.length()>xMax+1) return words;

        int startX, startY, endX, endY;
        if(reverse){
            newWord = new StringBuilder(word).reverse().toString();
            startX = word.length()-1;
            startY = 0;
            endX = 0;
            endY = 0;
        }
        else{
            startX = 0;
            startY = 0;
            endX = word.length()-1;
            endY = 0;
        }

        int[][] wordMatrix = new int[yMax+1][xMax+1];

        for(int i=0;i<newWord.length();i++){
            wordMatrix[0][i] = newWord.charAt(i);
        }

        words.addAll(getWordOne(crossword, word, wordMatrix, startX, startY, endX, endY));

        return words;
    }

    public static ArrayList<Word> getWordOneVertical(int[][] crossword, String word, boolean reverse){
        ArrayList<Word> words = new ArrayList<Word>();
        int yMax = crossword.length-1;
        int xMax = crossword[0].length-1;
        String newWord = word;
        if(word.length()>yMax+1) return words;

        int startX, startY, endX, endY;
        if(reverse){
            newWord = new StringBuilder(word).reverse().toString();
            startX = 0;
            startY = word.length()-1;
            endX = 0;
            endY = 0;
        }
        else{
            startX = 0;
            startY = 0;
            endX = 0;
            endY = word.length()-1;
        }

        int[][] wordMatrix = new int[yMax+1][xMax+1];

        for(int i=0;i<newWord.length();i++){
            wordMatrix[i][0] = newWord.charAt(i);
        }

        words.addAll(getWordOne(crossword, word, wordMatrix, startX, startY, endX, endY));


        return words;
    }

    public static ArrayList<Word> getWordOneMainDiagonal(int[][] crossword, String word, boolean reverse){
        ArrayList<Word> words = new ArrayList<Word>();
        int yMax = crossword.length-1;
        int xMax = crossword[0].length-1;
        String newWord = word;
        if(word.length()>xMax+1 || word.length()>yMax+1) return words;

        int startX, startY, endX, endY;
        if(reverse){
            newWord = new StringBuilder(word).reverse().toString();
            startX = word.length()-1;
            startY = word.length()-1;
            endX = 0;
            endY = 0;
        }
        else{
            startX = 0;
            startY = 0;
            endX = word.length()-1;;
            endY = word.length()-1;
        }

        int[][] wordMatrix = new int[yMax+1][xMax+1];

        for(int i=0;i<newWord.length();i++){
            wordMatrix[i][i] = newWord.charAt(i);
        }

        words.addAll(getWordOne(crossword, word, wordMatrix, startX, startY, endX, endY));


        return words;
    }

    public static ArrayList<Word> getWordOneSideDiagonal(int[][] crossword, String word, boolean reverse){
        ArrayList<Word> words = new ArrayList<Word>();

        int yMax = crossword.length-1;
        int xMax = crossword[0].length-1;
        String newWord = word;
        if(word.length()>xMax+1 || word.length()>yMax+1) return words;

        int startX, startY, endX, endY;
        if(reverse){
            newWord = new StringBuilder(word).reverse().toString();
            startX = word.length()-1;
            startY = 0;
            endX = 0;
            endY = word.length()-1;
        }
        else{
            startX = 0;
            startY = word.length()-1;
            endX = word.length()-1;
            endY = 0;
        }

        int[][] wordMatrix = new int[yMax+1][xMax+1];

        for(int i=0;i<newWord.length();i++){
            wordMatrix[newWord.length()-1-i][i] = newWord.charAt(i);
        }

        words.addAll(getWordOne(crossword, word, wordMatrix, startX, startY, endX, endY));


        return words;
    }

    public static ArrayList<Word> getWordsOne(int[][] crossword, String word){
        ArrayList<Word> words = new ArrayList<Word>();
        words.addAll(getWordOneHorizontal(crossword, word, false));
        words.addAll(getWordOneHorizontal(crossword, word, true));
        words.addAll(getWordOneVertical(crossword, word, false));
        words.addAll(getWordOneVertical(crossword, word, true));
        words.addAll(getWordOneMainDiagonal(crossword, word, false));
        words.addAll(getWordOneMainDiagonal(crossword, word, true));
        words.addAll(getWordOneSideDiagonal(crossword, word, false));
        words.addAll(getWordOneSideDiagonal(crossword, word, true));
        return words;
    }

    public static ArrayList<Word> detectAllWords(int[][] crossword, String... words){
        ArrayList<Word> wordsList = new ArrayList<Word>();

        for(String word : words){
            wordsList.addAll(getWordsOne(crossword, word));
        }

        return wordsList;

    }

    public static void printWords(ArrayList<Word> words){
        for(Word word : words){
            System.out.println(word);
        }
    }

}
