package com.example.pd2_matas.utils;

public class TextCounter {

    public static int getCharsCount(String inputPhrase){
        return inputPhrase.length();
    }
    public static int getWordsCount(String inputPhrase){
        if (inputPhrase.trim().isEmpty()) {
            return 0;
        }
        return inputPhrase.trim().split("\\s+").length;
    }
}
