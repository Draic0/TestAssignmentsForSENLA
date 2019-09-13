package common_package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Draic0 on 12.09.2019.
 */
public class common {
    public static void println(String str){
        System.out.println(str);
    }
    public static void print(String str){
        System.out.print(str);
    }
    public static String readLine(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return br.readLine();
        }catch(IOException exc){
            exc.printStackTrace();
            return null;
        }
    }
    public static boolean isExitCommand(String str){
        str = str.toLowerCase();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!Character.isLetter(ch)){
                str = str.substring(0,i)+str.substring(i+1);
                i--;
            }
        }
        return str.equals("exit")||str.equals("выход");
    }

    private static String punctuation = ".,:;{}()<>[]-–—+=?!";
    public static String cleanPunctuation(String str){
        while(str.length()>0&&punctuation.contains(""+str.charAt(0))){
            str = str.substring(1);
        }
        while(str.length()>0&&punctuation.contains(""+str.charAt(str.length()-1))){
            str = str.substring(0,str.length()-1);
        }
        return str;
    }
}
