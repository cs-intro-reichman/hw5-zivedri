/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {

    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param ch - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int count = 0;
        for (int i = 0;i < str.length();i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        if (str1.length() == 0) {
            return true;
        }
        if (str1.length() > str2.length()) {
            return false;
        }
        for (int i =0; i < str1.length();i++) {
            if (countChar(str1,str1.charAt(i)) > countChar(str2,str1.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        for (int i =0;i < str.length() - 1;i++) {
            if (str.charAt(i) != ' ') {
                str = str.substring(0,i+1) + " " + str.substring(i+1);
            }
        }
        return str;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String s ="";
        int r; // the random letter int value.
        int range = 122 - 97 + 1; // the int values range of the english alphabet in java.
        for (int i = 0;i < n;i++) {
            r = (int) (Math.random() * range) + 97; // the random letter value.
            s = s + (char) r;
        }
        return s;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        if (str1.equals(str2)) {
            return "";
        }
        int i =0;
        while (i < str1.length()){
            if (countChar(str2,str1.charAt(i)) > 0) { // if the current letter still appear at str2.
                int index = str2.indexOf(str1.charAt(i)); // the index of the current letter in str1 in str2.
                str1 = str1.substring(0, i) + str1.substring(i + 1); // removing the letter from str1.
                str2 = str2.substring(0,index) + str2.substring(index + 1); // removing the letter from str 2.
                i = str1.indexOf(str1.charAt(0)); // starting now from the new first index of str1.
            }
            else {
                i++;
            }
        }
        return str1;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
