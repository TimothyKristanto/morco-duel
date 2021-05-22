import java.util.*;

public class MorseCode {

    public static HashMap morsecode = new HashMap();
    private static String letter1 = "";

    public static void fillMorsecode(){
        morsecode.put("A", ".-");
        morsecode.put("B", "-...");
        morsecode.put("C", "-.-.");
        morsecode.put("D", "-..");
        morsecode.put("E", ".");
        morsecode.put("F", "..-.");
        morsecode.put("G", "--.");
        morsecode.put("H", "....");
        morsecode.put("I", "..");
        morsecode.put("J", ".---");
        morsecode.put("K", "-.-");
        morsecode.put("L", ".-..");
        morsecode.put("M", "--");
        morsecode.put("N", "-.");
        morsecode.put("O", "---");
        morsecode.put("P", ".--.");
        morsecode.put("Q", "--.-");
        morsecode.put("R", ".-.");
        morsecode.put("S", "...");
        morsecode.put("T", "-");
        morsecode.put("U", "..-");
        morsecode.put("V", "...-");
        morsecode.put("W", ".--");
        morsecode.put("X", "-..-");
        morsecode.put("Y", "-.--");
        morsecode.put("Z", "--..");
    }

    public static boolean checkMorsecode(String code, String letter){

        if(morsecode.get(letter).equals(code)){
            return true;
        }
        return false;
    }

    public static String randomLetter(){
        Random rand = new Random();

        int randint = rand.nextInt(morsecode.size());
        String letter = String.valueOf((char) (randint + 65));
        while(letter.equals(letter1)){
            randint = rand.nextInt(morsecode.size());
            letter = String.valueOf((char) (randint + 65));
        }
        letter1 = letter;
        return letter;
    }

    public static void showMorsecode(){
        System.out.println("Daftar Kode morse : ");
        for(Object i : morsecode.keySet()){
            System.out.println("Kode morse '" + i + "' : '" + morsecode.get(i) + "'");
        }
    }

}
