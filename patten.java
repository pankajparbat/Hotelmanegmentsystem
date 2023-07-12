package Hotel.Managment.System;
import java.util.Scanner;
public class patten
{
    public static void main(String[] args)
    {
       int a,b,c;
        for(a=1;a<=5;a++){
           for (b=4;b>=a;b--)
           {
               System.out.print("  ");
           }

           for (c=1;c<=a;c++)
           {
               System.out.print(" *");
           }
            System.out.println();
        }
    }
}




