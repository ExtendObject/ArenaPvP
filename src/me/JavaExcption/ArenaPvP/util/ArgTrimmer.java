package me.JavaExcption.ArenaPvP.util;

import java.lang.reflect.Constructor;

class ArgTrimmer<T>{
    private T[] original;
    private Constructor<?> constructor;

    public ArgTrimmer(T[] original){
        this.original = original;
        try {
            constructor = original.getClass().getConstructor(int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public T[] trim(int i){
        int length = original.length - i;
        if(length <= 0)return newInstance(0);
        T[] newargs = newInstance(length);
        System.arraycopy(original,i,newargs,0,length);
        return newargs;
    }

    private T[] newInstance(int i){
        try {
            constructor.setAccessible(true);
            return (T[])constructor.newInstance(i);
        }
        catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

}
