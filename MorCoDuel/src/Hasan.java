import java.util.*;

public class Hasan implements Hero{
    public static int hp = 750;
    public static int att = 90;
    public static int speed = 100;
    public static String kodemorse_skill1 = MorseCode.randomLetter();
    public static String kodemorse_skill2 = MorseCode.randomLetter();
    public static int skill1_cooldown = 2;
    public static int skill2_cooldown = 3;
    public static int heal = 0;

    public int attack(int hp_musuh){
        return hp_musuh - att;
    }

    public int[] skill1(int hp_musuh, int att_musuh) {
        Random rand = new Random();

        int[] res = new int[3];
        int att_up = 0;

        int randint = rand.nextInt(10);
        if(randint == 0 || randint == 1){
            att_up = att * 2;
            System.out.println("Hasan mengaktifkan Critical Damage!!!");
        }else{
            att_up = att;
        }
        hp_musuh -= att_up;

        res[1] = hp_musuh;
        res[2] = att_up;

        return res;
    }

    public int[] skill2(int hp_musuh, int att_musuh) {
        int [] res = new int[1];
        res[0] = 0;
        System.out.println("Hasan menggunakan efek menghindari serangan!");

        return res;
    }

    public void status() throws InterruptedException{
        System.out.println("==========================");
        System.out.println("|     Hasan's Status     |");
        System.out.println("==========================");
        Thread.sleep(1500);
        System.out.println("HP : " + hp);
        System.out.println("Attack : " + att);
        System.out.println("Speed : " + speed);
        System.out.println("Skill 1 : Melakukan basic attack dengan kemungkinan 'critical hit' (basic attack +100%) sebesar 20%");
        System.out.println("Kode morse : " + kodemorse_skill1);
        System.out.println("Cooldown : 2 ronde");
        System.out.println("SKill 2/Ult : Memiliki 100% kemungkinan untuk menghindari serangan musuh pada ronde itu");
        System.out.println("Kode morse : " + kodemorse_skill2);
        System.out.println("Cooldown : 3 ronde\n");
    }

    public String[] skill1Mode(){
        String[] modeskill = {"attack musuh", "att up temp"};
        return modeskill;
    }

    public String[] skill2Mode(){
        String[] modeskill = {"menghindar"};
        return modeskill;
    }

    public int getAtt(){
        return att;
    }
}
