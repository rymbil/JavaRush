package com.javarush.task.task20.task2027;

public class Matrix {
	public static boolean compare(int[][] matrix1, int[][] matrix2){
		
		for(int i=0;i<matrix1.length;i++){			
			for(int j=0;j<matrix1[i].length;j++){
				if(matrix1[i][j] != 0 && matrix2[i][j] != 0){
					if(matrix1[i][j] != matrix2[i][j]){
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public static void shiftRight(int[][] matrix){
		int yMax = matrix.length-1;
		int xMax = matrix[0].length-1;
		for(int y = 0; y<=yMax; y++){
			for(int x=xMax-1;x>=0;x--){
				matrix[y][x+1] = matrix[y][x];
			}
			matrix[y][0] = 0;
		}		
		
	}
	
	public static void shiftLeft(int[][] matrix){
		int yMax = matrix.length-1;
		int xMax = matrix[0].length-1;
		for(int y = 0; y<=yMax; y++){
			for(int x=0;x<xMax;x++){
				matrix[y][x] = matrix[y][x+1];
			}
			matrix[y][xMax] = 0;
		}		
		
	}
	
	public static void shftDown(int[][] matrix){
		int yMax = matrix.length-1;
		int xMax = matrix[0].length-1;
		for(int x = 0; x<=xMax; x++){
			for(int y=yMax;y>0;y--){
				matrix[y][x] = matrix[y-1][x];
			}
			matrix[0][x] = 0;
		}		
	}
}
