package com.cookvert.util;

/**
 *
 */

public class TextValidator {

    private TextValidator(){}

    /**
     * Parses given String number to see if it has more than 3 digits after decimal point.
     * @param number double value in String form
     * @return true, if number has more than 3 digits after decimal point, otherwise false
     */
    public static boolean accuracyMoreThanThreeDigits(String number){
        int counter = 0;

        for(int i=0; i < number.length(); i++){
            if(number.charAt(i) == '.'){
                // start new loop after dot and count the number of characters after that
                for(int j =i+1; j < number.length(); j++){
                    counter++;
                    // if there are more than 3 characters after dot, return true
                    if(counter > 3){
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
