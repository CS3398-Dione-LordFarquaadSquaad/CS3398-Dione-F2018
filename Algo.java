/*
Error free - row only
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
        
            int[][] Row = new int[numC][maxR];
            for (int i = 0; i < numR; i++){
                for (int j = 0; j < maxR; j++){
                    //read num for next point
                    Row[i][j] = reader.nextInt(10);
                }
            }
        
            int[][] Column = new int[numR][maxC];
            for (int i = 0; i < numC; i++){
                for (int j = 0; j < maxC; j++){
                    //read num for next point
                    Column[i][j] = reader.nextInt(10);
                }
            }
        
            int[][] Grid = new int[numC][numR];
            int[][] Lvalues = new int[maxR][numR];
            int[] currRparam = new int[maxR];
            int[] currR = new int[numC]; //current grid row (for comparison)
            int[] newR = new int[numC]; //replaces the current grid row after full iteration
            int[] workingR = new int[numC]; //"added" to newR if valid
            int[] currCparam = new int[maxC];
            int[] currC = new int[numR];
            int workingParam;
            int currParamNum; //location in currParamC or currParamR
            int loc; //location in currR or currC
            int[] ws = new int[maxR];
            int space; //number of spaces before currParam
            int check = 999;
            boolean done = false;
            boolean notMax = true;
            boolean good;
        
            for (int i = 0; i < numC; i++){
                for (int j= 0; j<numR; j++){
                    Grid[i][j]=1;
                }
                
                for(currParamNum = maxR-1; currParamNum >= 0; currParamNum--){
                    if(Row[i][currParamNum] != 0){
                        Lvalues[currParamNum][i] = numC - Row[i][currParamNum];
                        int temp = currParamNum+1;
                        while(temp <= maxR-1){
                            Lvalues[currParamNum][i] -= Row[i][temp++]+1;
                        }
                    }
                    else 
                        Lvalues[currParamNum][i] = 0;
                }
            }
            
            //fill Grid
            while(!done){
                done = true;
                
                //for all rows 
                for (int i = 0; i < numR; i++){
                    
                    //fill param list
                    for ( loc = 0; loc < maxR; loc++){
                        currRparam[loc] = Row[i][loc];
                    }
                
                    //fill CurrR and reset newR
                    for (loc = 0; loc < numC; loc++){
                        currR[loc] = Grid[loc][i];
                        newR[loc] = -1;
                        workingR[loc] = -1;
                    }

                    //fill row
                    for(currParamNum = maxR - 1; currParamNum >= 0; currParamNum--){
                        space = 0;
                        check = 999;
                        do{ if(currRparam[currParamNum] != 0){
                            loc = 0;
                            for(int k = 0; k < currParamNum; k++){
                                workingParam = currRparam[k];
                                for (; workingParam>0; workingParam--){
                                    if(loc+workingParam <= Lvalues[k][i]){
                                        workingR[loc] = 2;
                                        loc++;
                                    }
                                    else break;
                                }
                                if(currRparam[k] != 0){
                                    workingR[loc] = 0;
                                    loc++;
                                }
                            }
                            
                            for(int k = space; k > 0; k--){
                                workingR[loc] = 0;
                                 loc++;
                            }
                            check = loc+1;
                            
                            for(int k = currRparam[currParamNum]; k > 0; k--){
                                    workingR[loc] = 2;
                                    loc++;
                            }
                            
                            if(currParamNum < maxR-1){
                                int gt = Lvalues[currParamNum + 1][i];
                                while(loc < gt){
                                    workingR[loc] = 0;
                                    loc++;
                                }
                            }
                            
                            for( int k = currParamNum + 1; k < maxR; k++){
                                for (workingParam = currRparam[k]; workingParam > 0; workingParam--){
                                    if(loc < numC){
                                        workingR[loc] = 2;
                                        loc++;
                                    }
                                }
                                if(loc < numC){
                                    currR[loc] = 0;
                                    loc++;
                                }
                            }
                            
                            while( loc < numC){
                                workingR[loc] = 0;
                                loc++;
                            }
                            
                            good = true;
                            for( loc = 0; loc<numC /*&& good*/; loc++){
                                System.out.print(workingR[loc]);
                                if(currR[loc] != 1){
                                    if(currR[loc] != workingR[loc]){
                                        good = false;
                                    }
                                }
                            }
                            System.out.println("");
                            
                            if(good){
                                done = false;
                                for( loc = 0; loc < numC; loc++){
                                    if(newR[loc] == -1)
                                        newR[loc] = workingR[loc];
                                    else if(workingR[loc] != newR[loc])
                                        newR[loc] = 1;
                                }
                            }
                            space++;
                        }}while( check <= Lvalues[currParamNum][i]);
                        
                        System.out.println("Row# " + i);
                        for(loc = 0; loc < numC; loc++){    
                            Grid[loc][i] = newR[loc];
                            System.out.print(Grid[loc][i]);
                        }
                        System.out.print("\n \n");
                    }
                }
                done = true;
            }
        }
        catch(Exception e){
            System.out.println("error: " + e);
        }
        
    }
}