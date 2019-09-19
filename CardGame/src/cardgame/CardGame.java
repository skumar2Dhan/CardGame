/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

import java.util.Random;
import java.lang.*;
import java.util.Scanner; // to allow scanner
public class CardGame
{
public static void main(String[] args)
{
int[][] deck= new int[4][4];
int[][] faceValue= new int[4][4];
int i,j,x1,y1,x2,y2,status=0;
Scanner in=new Scanner(System.in);
   Random randomGenerator= new Random();
   for(i=0;i<4;i++)
   {
       for(j=0;j<4;j++)
   {
       deck[i][j]=randomGenerator.nextInt(8)+1;
   }
   }
   for(i=0;i<4;i++)
   {
       for(j=0;j<4;j++)
   {
       faceValue[i][j]=0; //0 for Face UP and 1 for Face Down
   }
   }
   do
   {
       for(i=0;i<4;i++)
       {
           for(j=0;j<4;j++)
           {
               if(faceValue[i][j]==1)
                   status++;
           }
       }
       System.out.print("\n\n\t1\t2\t3\t4");
       System.out.print("\n\t--------------------------");
       for(i=0;i<4;i++)
       {
           System.out.print("\n"+(i+1)+"|\t");
           for(j=0;j<4;j++)
       {
           if(faceValue[i][j]==0)
               System.out.print("*\t");
           else
               System.out.print(deck[i][j]+"\t");
           }
       System.out.println();
       }
       System.out.println("Enter Card1 x-axis Index : ");
       x1=in.nextInt();
       System.out.println("Enter Card1 y-axis Index : ");
       y1=in.nextInt();
       System.out.println("Enter Card2 x-axis Index : ");
       x2=in.nextInt();
       System.out.println("Enter Card2 y-axis Index : ");
       y2=in.nextInt();
       System.out.print("\n\n\t1\t2\t3\t4");
       System.out.print("\n\t--------------------------");
       for(i=0;i<4;i++)
       {
           System.out.print("\n"+(i+1)+"|\t");
           for(j=0;j<4;j++)
       {
           if((x1-1)==i&&(y1-1)==j)
               System.out.print(deck[i][j]+"\t");
           else if((x2-1)==i&&(y2-1)==j)
               System.out.print(deck[i][j]+"\t");
           else if(faceValue[i][j]==0)
               System.out.print("*\t");
           else if(faceValue[i][j]==1)
               System.out.print(deck[i][j]+"\t");
           }
       System.out.println();
       }
       if(deck[x1-1][y1-1]==deck[x2-1][y2-1])
       {
           faceValue[x1-1][y1-1]=1;
           faceValue[x2-1][y2-1]=1;
       }
       status=0;
   }while(status!=16);
   System.out.println("\nAll cards are Face up..!! You have WON..");
}
}