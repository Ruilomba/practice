import java.util.HashMap;
import java.util.Map;

public class HalvesAreAlike {
    public static boolean halvesAreAlike(String s) {
        int length = s.length();
        int middle = length / 2;

        int leftVowels = 0;
        int rightVowels = 0;

        for(int i = 0; i < middle ; i++){
            if(isVowel(s.charAt(i))) leftVowels++;
            if(isVowel(s.charAt(length - 1 - i))) rightVowels++;
        }

        return leftVowels == rightVowels;
    }

    private static boolean isVowel(Character s){
        switch (Character.toLowerCase(s)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u': return true;
            default: return false;
        }
    }

    public static void main(String[] args) {
        boolean result = halvesAreAlike("book");
        result = halvesAreAlike("AbCdEfGh");
        result = halvesAreAlike("textbook");
        result = halvesAreAlike("MerryChristmas");
    }
}
 