package com.vadymandartem;

 import java.io.*;
 import java.nio.charset.StandardCharsets;


public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        char[] ourText = new char[4000000];
        try(BufferedReader buf = new BufferedReader (new InputStreamReader(new FileInputStream("C:\\Users\\Tempuser\\IdeaProjects\\Laba1\\src\\com\\vadymandartem\\11.txt"), "UTF-8"))){
            int c;
            int i=0;
            while ( (c = buf.read()) != -1){
                char symbol = ((char)c);
                if (Character.isUpperCase(symbol)) symbol=Character.toLowerCase(symbol);
                if (symbol >= 'а' && symbol<= 'я'){
                    ourText[i] = symbol;
                    i++;
                }
                if ((symbol==' ' || symbol=='\n' || symbol=='\t') && i>0 && ourText[i-1]!=' ' ){
                    ourText[i] = ' ';
                    i++;
                }
                if ((symbol==' ' || symbol=='\n' || symbol=='\t') && i==0){
                    ourText[i] = ' ';
                    i++;
                }
            }
            int length = i;
            buf.close();
            for (i=0;i<length;i++)
            System.out.print(ourText[i]);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
