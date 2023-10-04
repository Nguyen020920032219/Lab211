/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package applicationLayer.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author trand
 */
public class DataInput {

    public static String getString(String displayMessage) throws Exception {
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.println(displayMessage);
        s = sc.nextLine();
        return s.trim();
    }

    public static String getString() throws Exception {
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        return s.trim();
    }

    public static int getInteger(String displayMessage) throws Exception {
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.println(displayMessage);
        s = sc.nextLine();
        if (s.matches("\\d{1,10}")) {
            return Integer.parseInt(s);
        } else {
            throw new Exception("Data invalid, the corect is integer.");
        }
    }

    public static int getInteger() throws Exception {
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        if (s.matches("\\d{1,10}")) {
            return Integer.parseInt(s);
        } else {
            throw new Exception("Data invalid, the corect is integer.");
        }
    }

    public static String getDate(String date) throws Exception {
        if (date.length() != 10) {
            throw new Exception("Date invalid, the corect form is dd/mm/yyyy.");
        }
        String[] dateParts = date.split("/");
        if (dateParts.length != 3) {
            throw new Exception("Date invalid, the corect form is dd/mm/yyyy.");
        }
        int day = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]);

        if (month < 1 || month > 12) {
            throw new Exception("Month invalid, 1 <= month <= 12.");
        }
        if (year < 1) {
            throw new Exception("Year invalid, year > 0.");
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day > 30 || day < 1) {
                throw new Exception("Day invalid, 1 <= day <=30 in month 4,6,9,11.");
            }
        } else if (month != 2) {
            if (day > 31 || day < 1) {
                throw new Exception("Day invalid, 1 <= day <=31 in month 1,3,5,7,8,10,12.");
            }
        }
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            if (month == 2 && (day > 29 || day < 1)) {
                throw new Exception("Day invalid, 1 <= day <=29 in month 2 in leap year.");
            }
        } else {
            if (month == 2 && (day > 28 || day < 1)) {
                throw new Exception("Day invalid, 1 <= day <=28 in month 2 in normal year.");
            }
        }
        return date;
    }

    public static String getCode(String code) {
        int codeValue = Integer.parseInt(code);
        codeValue++;
        return String.valueOf(codeValue);
    }

    public static String getCurrentTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return sdf.format(date);
    }

    public static int getChoice(String displayMessage, int min, int max) {
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.println(displayMessage);
        s = sc.nextLine();
        if (s.matches("\\d{1}") && Integer.parseInt(s) <= max && Integer.parseInt(s) >= min) {
            return Integer.parseInt(s);
        } else {
            System.out.println("Choice invalid, the corect is " + min + "<=integer<=" + max + ".");
        }
        return 0;
    }
}
