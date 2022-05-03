

public class InputChecker{

    public static boolean isDecimalNumber(String stringNumber) {
        String hasSpecial = ":";
        String regexDecimalPattern = "[+-]?([0-9]*[.])?[0-9]+";
        Pattern pattern = Pattern.compile(regexDecimalPattern);
        Matcher matcher = pattern.matcher(stringNumber);

        if(matcher.matches()) {
            return true;

        }
        else if (stringNumber.contains(hasSpecial)) {
            return false;
        }
        else {
            return false;
        }
    }
    public static boolean isIntegerNumber(String stringNumber) {
        String rgx = "^[0-9]*$";
        Pattern pattern = Pattern.compile(rgx);
        Matcher matcher = pattern.matcher(stringNumber);
        if(matcher.matches()) {
            return true;
        }else {
            return false;
        }
    }
    public static boolean isEnglishKeyboard(String string) {
        //This is not working as intended, and the sublist contains titles and authors in other languages
        String rgx = "[a-zA-Z0-9\\t\\n ./<>?;:\"'`!@#$%^&*()\\[\\]{}_+=|\\\\-]";
        Pattern pattern = Pattern.compile(rgx);
        Matcher matcher = pattern.matcher(string);
        if(matcher.matches()) {
            return true;
        }else {
            return false;
        }
    }



}


