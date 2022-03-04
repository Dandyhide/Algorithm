package com.company.Everyday;

public class DetectCapitalUse {
    public boolean detectCapitalUse(String word) {
        if (word.equals(word.toUpperCase())){
            return true;
        }
        if (word.equals(word.toLowerCase())){
            return true;
        }
        if (word.equals(word.substring(0, 1).toUpperCase()+word.toLowerCase().substring(1))){
            return true;
        }
        return false;
    }
}
