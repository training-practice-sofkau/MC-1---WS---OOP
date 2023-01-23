package co.com.movingu.utilities;

import java.util.Scanner;

public class Utilities {
    private Scanner input;
    public void menu(){
        System.out.println("Moving - U");
        System.out.println("1. Register user");
        System.out.println("2. Borrow/Return");
        System.out.println("3. Pay a ticket");
        System.out.println("4. Check availability");
        System.out.println("5. Exit");
    }

    public String captureString() {
        return input.nextLine();
    }

    public int captureInt(){
        return Integer.parseInt(input.nextLine());
    }
}
