package me.JavaExcption.ArenaPvP.util;


public class JavaUtil {
    public static String[] trimArguments(int i,String[] args){
        return new ArgTrimmer<>(args).trim(i);
    }

}
