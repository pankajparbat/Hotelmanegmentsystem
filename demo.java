package Hotel.Managment.System;

import java.util.Scanner;

public class demo
{
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        System.out.println("enter your name ");
        String name= S.nextLine();

        System.out.println("enter your no ");
        int roll= S.nextInt();
        System.out.println("your name "+name);
        System.out.println("your no is "+roll);


    }
}
