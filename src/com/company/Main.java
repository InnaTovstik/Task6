package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	    String str1 = "2020/12/23 05:30";
	    String str2 = "2020/13/77 99:99";
	    String adrEmail = "abc@mail.com";
        String adrEmail1 = "zzz@ccc.v";
        printRez(str1, checkData(str1));
        printRez(str2, checkData(str2));
        printRez(adrEmail, extractDomain(adrEmail));
        printRez(adrEmail1, extractDomain(adrEmail1));
    }

    public static String checkData(String str)
    {
        String rez = "invalid";
        String regex1 = "\\d?\\d{3}/(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01]) [0-11][0-9]:[0-5][0-9]";
        if(str.matches(regex1)) {
            rez = "valid";
        }
        return rez;
    }

        public static String extractDomain(String str)
        {
            String emailDomain = null;
            String regex = "([A-Za-z0-9._%+-]+)@([A-Za-z0-9.-]+\\.[A-Za-z]{1,4})";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(str);
            if( matcher.find()){
                emailDomain = matcher.group(2);
            }
            return emailDomain;
        }

        public static void printRez(String first, String second){
            System.out.println(first + " -> " + second);
        }

    }