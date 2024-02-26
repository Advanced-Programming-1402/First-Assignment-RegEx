import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise3 {

    /*
    implement the method below so that it extracts a URL from a String
    I will write the basics for this one method, you will have to implement the other two methods from scratch
    */

    public static String extractURL(String text) {
        String regex = "http[s]?:.+\\..+[mro]";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group();
        }
        else{
            return null;
        }
    }

    /*
    implement the method below to validate an email address
     */

    public static boolean validateEmail(String email) {
        String regex = "\\w+@\\w*\\.\\w+[mg]";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.find()) {
            return true;
        }
        else {
            return false;
        }
    }

    /*
    implement the method below so that it returns a list of words with repeated letters
    */

    private static boolean isItRepeatedLetter(String str) { // Function to check a word is RepeatedLetter or not
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<String> findWordsWithRepeatLetters(String input) {
        List<String> wordsWithRepeatLetters = new ArrayList<>();
        List<String> tempList = new ArrayList<>(); // contains all of input Words

        String wordRegex = "\\w+";

        Pattern pattern = Pattern.compile(wordRegex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            tempList.add(matcher.group(0));
        }

        for (String s : tempList) {
            if (isItRepeatedLetter(s)) {
                wordsWithRepeatLetters.add(s);
            }
        }

        return wordsWithRepeatLetters;
    }

    /*
    Bonus Problem ;)
    implement the method below so that it returns a list of words that are repeated twice accidentally in a string
    for example: "appleapple orange pearpear pineapple" -> ["appleapple", "pearpear"]
    */

    private static boolean isItRepeatedWord(String s) { // Function to check a word is RepeatedWord or not
        int border = s.length() / 2;
        String sub1 = s.substring(0, border);
        String sub2 = s.substring(border, s.length());

        if (sub1.equals(sub2)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static List<String> findReapetdWords(String input) {
        List<String> repeatedWords = new ArrayList<>();
        List<String> tempList = new ArrayList<>(); // contains all of input Words

        String wordRegex = "\\w+";

        Pattern pattern = Pattern.compile(wordRegex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            tempList.add(matcher.group(0));
        }

        for (String str : tempList) {
            if (isItRepeatedWord(str)) {
                repeatedWords.add(str);
            }
        }

        return repeatedWords;
    }

    public static void main(String[] args) {
        // test your code here!
    }
}