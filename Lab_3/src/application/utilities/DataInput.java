/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.utilities;

import java.util.Scanner;

/**
 *
 * @author trand
 */
public class DataInput {

    public static int getChoice(String displayMessage, int min, int max) {
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.println(displayMessage);
        s = sc.nextLine();
        if ((s.matches("\\d{1}")) && (Integer.parseInt(s) <= max) && (Integer.parseInt(s) >= min)) {
            return Integer.parseInt(s.trim());
        } else {
            System.out.println("Choice invalid, the corect is " + min + "<=integer<=" + max + ".");
        }
        return 0;
    }

    public static String getString(String displayMessage) {
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.println(displayMessage);
        s = sc.nextLine();
        return s;
    }

    public static int getInteger(String displayMessage) throws Exception {
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.println(displayMessage);
        s = sc.nextLine();
        if (s.matches("\\d{1,100}")) {
            return Integer.parseInt(s.trim());
        } else {
            throw new Exception(">>>>>Data invalid, the correct is integer.");
        }
    }

    public static int getYear(String diplayMessage) throws Exception {
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.println(diplayMessage);
        s = sc.nextLine();
        if (s.matches("\\d{1,4}")) {
            if (Integer.parseInt(s.trim()) >= 1) {
                return Integer.parseInt(s.trim());
            } else {
                throw new Exception(">>>>>Year invalid, year must be 1<=integer<=9999.");
            }
        } else {
            throw new Exception(">>>>>Year invalid, year must be 1<=integer<=9999.");
        }
    }

    public static long getLong(String displayMessage) throws Exception {
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.println(displayMessage);
        s = sc.nextLine();
        if (s.matches("\\d{1,100}")) {
            return Long.parseLong(s.trim());
        } else {
            throw new Exception(">>>>>Data invalid, the correct is long.");
        }
    }
}
