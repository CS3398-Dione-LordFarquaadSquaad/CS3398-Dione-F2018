/*
Thursday 5pm check in. 
Done with data structure, almost done with rows algorithm (debugging). Columns are will be little more than copy paste
*/

import java.io.FileReader;
import java.io.*;
import java.util.Scanner;

public class Algo{
    public static void main(String[] args){
        int numR;
        int numC;
        int maxR;
        int maxC;
        String filename = "specs.txt";
        
        try{
            FileReader fin = new FileReader(filename);
            BufferedReader bin = new BufferedReader(fin);
            Scanner reader = new Scanner(bin);
        
        
            //read file
            numR = reader.nextInt(10);
            numC = reader.nextInt(10);
            maxR = reader.nextInt(10);
            maxC = reader.nextInt(10);
        
            int[][] Row = new int[numR][maxR];
            for (int i = 0; i < numR; i++){
                for (int j = 0; j < maxR; j++){
                    //read num for next point
                    Row[i][j] = reader.nextInt(10);
                }
            }
        
            int[][] Column = new int[numR][maxR];
            for (int i = 0; i < numC; i++){
                for (int j = 0; j < maxC; j++){
                    //read num for next point
                    Column[i][j] = reader.nextInt(10);
                }
            }
        
            int[][] Grid = new int[numC][numR];
            int[][] Lvalues = new int[numC]
            int[] currRparam = new int[maxR];
            int[] currR = new int[numC];
            int[] newR = new int[numC]; //replaces the current grid row after full iteration
            int[] workingR = new int[numC]; //"added" to newR if valid
            int[] currCparam = new int[maxC];
            int[] currC = new int[numR];
            int currParam; 
            int currParamNum; //location in currParamC or currParamR
            int loc; //location in currR or currC
            int[] ws = new int[maxR];
            int fillstart;
            int space;
            boolean done = false;
            boolean notMax = true;
            boolean good;
        
        //CALC MAXVALUES!!
        
            for (int i = 0; i < numR; i++){
                for (int j= 0; j<numC; j++){
                    Grid[j][i]=1;
                }
            }
                    
            //fill Grid
            while(!done){
                
                //for all rows 
                for (int i = 0; i < numR; i++){
                    
                    //fill param list
                    for (int j = 0; j < maxR; i++){
                        currRparam[j] = Row[i][j];
                    }
                
                    //fill CurrR and reset newR
                    for (int j = 0; j < numC; j++){
                        currR[j] = Grid[j][i];
                        newR[j] = -1;
                    }

                    //fill row
                    for(int currParamNum = maxR - 1; currParamNum >= 0; currParamNum--){
                        fillstart = -1;
                        space = 0;
                        do{
                            for(int k = 0; k < currParamNum; k++){
                                fillstart++;
                                for (int currParam = currRparam[currParamNum]; currParam>0; currParam--){
                                    workingR[fillstart] = 2;
                                    fillstart++
                                }
                                currR[fillstart] = 0
                            }
                            
                            for(int k = space; k > 0; k--){
                                fillstart++
                                workingR[fillstart] = 0;
                            }
                            check = fillstart++;
                            
                            for(int k = ; k > 0; k--){
                                fillstart++
                                workingR[fillstart] = 2;
                            }
                            
                            if(j < maxR-1)
                                fillstart = CmaxR[j + 1];
                            
                            for( int k = j + 1; k < maxR; j++){
                                for (int l = currRparam[j]; l > 0; l--){
                                    workingR[fillstart] = 2;
                                    fillstart++;
                                }
                                currRfillstart = 0;
                                fillstart++;
                            }
                            
                            good = true;
                            for( loc = 0; loc<numC && good; loc++){
                                if(currR[loc] != 1){
                                    if(currR[loc] != workingR[loc]){
                                        good = false;
                                    }
                                }
                            }
                            
                            if(good){
                                for( loc = 0; loc < numC; loc++){
                                    if(newR[loc] = -1)
                                        newR[loc] = workingR[loc];
                                    else if(workingR[loc] != newR[loc])
                                        newR[loc] = 1;
                                }
                            }
                            space++
                        }while( (check+1)>= CmaxR[currParamNum])
                    for(int l = 0; for l < numC; l++){    
                        grid[l][currParamnum]
                    }
                }
            }
        
        }
        catch(Exception e){
        }
        
    }
}