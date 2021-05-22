public class AnzenSebu implements Hero{
    public static int hp = 800;
    public static int default_att = 50;
    public static int att = 50;
    public static int speed = 70;
    public static String kodemorse_skill1 = MorseCode.randomLetter();
    public static String kodemorse_skill2 = MorseCode.randomLetter();
    public static int skill1_cooldown = 3;
    public static int skill2_cooldown = 5;
    public static int heal = 150;

    public int attack(int hp_musuh){
        return hp_musuh - att;
    }

    public int[] skill1(int hp_musuh, int att_musuh){
        int[] res = new int[1];
        hp += 150 - GameProcess.heal_lifesteal_reduction;
        if(hp > 800){
            hp = 800;
        }
        res[0] = hp;

        return res;
    }

    public int[] skill2(int hp_musuh, int att_musuh){
        System.out.println("Anzen Sebu menggunakan efek bleeding!");
        GameProcess.bleeding_round = 3;
        int[] res = new int[1];
        int bleeding = (int) (hp_musuh * 0.1);
        res[0] = bleeding;

        return res;
    }

    public void status() throws InterruptedException{
        System.out.println("==========================");
        System.out.println("|  Anzen Sebu's Status   |");
        System.out.println("==========================");
        Thread.sleep(1500);
        System.out.println("HP : " + hp);
        System.out.println("Attack : " + att);
        System.out.println("Speed : " + speed);
        System.out.println("Skill 1 : Heal 150 HP");
        System.out.println("Kode morse : " + kodemorse_skill1);
        System.out.println("Cooldown : 3 ronde");
        System.out.println("SKill 2/Ult : Memberi efek 'Bleeding' kepada musuh yang mengurangi HP musuh sebanyak 10% (10% * hp musuh pada waktu skill ini dipakai) selama 3 ronde");
        System.out.println("Kode morse : " + kodemorse_skill2);
        System.out.println("Cooldown : 5 ronde\n");
    }

    public String[] skill1Mode(){
        String[] modeskill = {"hp up"};
        return modeskill;
    }

    public String[] skill2Mode(){
        String[] modeskill = {"bleeding"};
        return modeskill;
    }

    public int getAtt(){
        return default_att;
    }
}
