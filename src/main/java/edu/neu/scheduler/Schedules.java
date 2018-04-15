/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.scheduler;

/**
 *
 * @author Akhilesh Kashyap
 */
public class Schedules {
    public void createSchedules(){
    int shifts[][]=new int[21][21];
    String days[] = {"M", "T", "W", "TH", "F", "S", "SU"};
    String batch[] = {"M", "E", "N"};
    for(int i=0;i<20;i++){
            shifts[i][i+1]=1;
            shifts[i+1][i]=1;
            }
 String shiftComb[]=new String[21];
 int o=0;
    for(int t = 0; t<7; t++) {
     for(int u = 0; u<3; u++) {   
        int k = t % 7;
       int l = u % 3;
        System.out.print("\t"+days[k] + batch[l]);
        shiftComb[o++]=days[k] + batch[l];
    }
     
    }
     System.out.println();
     
    for(int i=0;i<21;i++){
       System.out.print(shiftComb[i]+"\t");
        
    for(int j=0;j<21;j++){
       
       
       System.out.print(shifts[i][j]+"\t"); 
       
    }
System.out.println();
}
}
}
