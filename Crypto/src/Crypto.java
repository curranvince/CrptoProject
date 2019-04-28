import java.util.*;
import java.util.regex.*;
public class Crypto {
    private static final Scanner keys = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("What is your input?");
        String input = keys.nextLine();
        System.out.println("what is your shift key?");
        int shift = keys.nextInt();
        String newInput = normalizeText(input);
        System.out.println("Normalized Text: " + newInput);
        String caesarText = caesarify(newInput, shift);
        System.out.println("Caesared Text: " + caesarText);
        String unCaesaredText = unCaesarify(caesarText, shift);
        System.out.println("UnCaesared Text: " + unCaesaredText);
    }
    public static String normalizeText(String temp) {
        temp = temp.toUpperCase();
        temp = temp.replaceAll(" ", "");
        temp = temp.replaceAll("\\s+", "");
        temp = temp.replaceAll("\"", "");
        temp = temp.replaceAll("\'", "");
        temp = temp.replaceAll("[)-?+.^!:,(]", "");
        return temp;
    }
    public static String caesarify(String plain, int shift) {
        if (shift > 26) {
            shift = shift % 26;
        } else if (shift < 0) {
            shift = (shift % 26) + 26;
        }
        String caesarText = "";
        int length = plain.length();
        for (int i = 0; i < length; i++) {
            char c = plain.charAt(i);
            char shiftC = (char) (c + shift);
            if (shiftC > 'Z') {
                caesarText += (char) (c - (26 - shift));
            } else {
                caesarText += shiftC;
            }
        }
        return caesarText;
    }
    public static String unCaesarify(String caesar, int shift) {
        if (shift > 26) {
            shift = shift % 26;
        } else if (shift < 0) {
            shift = (shift % 26) + 26;
        }
        String unCaesarText = "";
        int length = caesar.length();
        for (int i = 0; i < length; i++) {
            char c = caesar.charAt(i);
            char shiftC = (char) (c - shift);
            if (shiftC < 'A') {
                unCaesarText += (char) (c + (26 - shift));
            } else {
                unCaesarText += shiftC;
            }
        }
        return unCaesarText;
    }
}

