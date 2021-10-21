package ui;

import java.util.Scanner;

public class ConsoleIO implements IO {

    private Scanner reader;

    public ConsoleIO() {
        reader = new Scanner(System.in);
    }

    public int nextInt() {
        return Integer.parseInt(reader.nextLine());
    }

    public void print(String s) {
        System.out.print(s);
    }

    public void println(String s) {
        System.out.println(s);
    }
}