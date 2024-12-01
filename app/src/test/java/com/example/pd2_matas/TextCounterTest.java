package com.example.pd2_matas;

import com.example.pd2_matas.utils.TextCounter;

import org.junit.Test;

import static org.junit.Assert.*;

public class TextCounterTest {

    // Test cases for counting characters
    @Test
    public void charCount_noInput() {
        String text = "";
        int count = TextCounter.getCharsCount(text);
        assertEquals("Expected 0 characters for empty input", 0, count);
    }

    @Test
    public void charCount_singleWord() {
        String text = "Matas";
        int count = TextCounter.getCharsCount(text);
        assertEquals("Expected 5 characters for input 'Matas'", 5, count);
    }

    @Test
    public void charCount_multipleWords() {
        String text = "Hello Android Studio";
        int count = TextCounter.getCharsCount(text);
        assertEquals("Expected 20 characters for input 'Hello Android Studio'", 20, count);
    }

    @Test
    public void charCount_onlySpaces() {
        String text = "     ";
        int count = TextCounter.getCharsCount(text);
        assertEquals("Expected 5 characters for input with only spaces", 5, count);
    }

    @Test
    public void charCount_spacesAndWords() {
        String text = "   Android Development   ";
        int count = TextCounter.getCharsCount(text);
        assertEquals("Expected 25 characters for input '   Android Development   '", 25, count);
    }

    // Test cases for counting words
    @Test
    public void wordCount_noInput() {
        String text = "";
        int count = TextCounter.getWordsCount(text);
        assertEquals("Expected 0 words for empty input", 0, count);
    }

    @Test
    public void wordCount_singleWord() {
        String text = "Programming";
        int count = TextCounter.getWordsCount(text);
        assertEquals("Expected 1 word for input 'Programming'", 1, count);
    }

    @Test
    public void wordCount_multipleWords() {
        String text = "Hello Android Studio";
        int count = TextCounter.getWordsCount(text);
        assertEquals("Expected 3 words for input 'Hello Android Studio'", 3, count);
    }

    @Test
    public void wordCount_onlySpaces() {
        String text = "     ";
        int count = TextCounter.getWordsCount(text);
        assertEquals("Expected 0 words for input with only spaces", 0, count);
    }

    @Test
    public void wordCount_tabsAndSpaces() {
        String text = "\tHello \t World\t ";
        int count = TextCounter.getWordsCount(text);
        assertEquals("Expected 2 words for input with tabs and spaces", 2, count);
    }

    @Test
    public void wordCount_spacesAndWords() {
        String text = "   Android Development   ";
        int count = TextCounter.getWordsCount(text);
        assertEquals("Expected 2 words for input '   Android Development   '", 2, count);
    }
}