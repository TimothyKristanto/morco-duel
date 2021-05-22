public class Dolores implements Hero{
    public static int hp = 850;
    public static int default_att = 80;
    public static int att = 80;
    public static int speed = 75;
    public static String kodemorse_skill1 = MorseCode.randomLetter();
    public static String kodemorse_skill2 = MorseCode.randomLetter();
    public static int skill1_cooldown = 3;
    public static int skill2_cooldown = 5;
    public static int heal = 0;

    public int attack(int hp_musuh){
        return hp_musuh - att;
    }

    public int[] skill1(int hp_musuh, int att_musuh){
        GameProcess.heal_lifesteal_reduce_round = 2;
        int[] res = new int[2];

        int att_up = 0;
        att_up = (int) (att + (att * 0.2));
        hp_musuh -= att_up;
        GameProcess.heal_lifesteal_reduction = (int) (0.5 * GameProcess.heal_lifesteal);
        System.out.println("Dolores menggunakan efek mengurangi lifesteal dan heal!");

        res[0] = 50;
        res[1] = hp_musuh;
        return res;
    }

    public int[] skill2(int hp_musuh, int att_musuh){
        GameProcess.round_memantulkan_serangan = 2;
        int[] res = new int[2];

        res[1] = att_musuh;
        System.out.println("Dolores menggunakan efek memantulkan serangan!");

        return res;
    }

    public void status() throws InterruptedException{
        System.out.println("==========================");
        System.out.println("|     Dolores's Status   |");
        System.out.println("==========================");
        Thread.sleep(1500);
        System.out.println("HP : " + hp);
        System.out.println("Attack : " + att);
        System.out.println("Speed : " + speed);
        System.out.println("Skill 1 : Melakukan attack sebesar (total attack + 20%) pada ronde itu.\nMengurangi efek 'Heal' dan 'Lifesteal' musuh sebanyak 50% selama 2 ronde");
        System.out.println("Kode morse : " + kodemorse_skill1);
        System.out.println("Cooldown : 3 ronde");
        System.out.println("SKill 2/Ult : Dolores akan terkena serangan musuh (kecuali serangan musuh berbentuk efek seperti bleeding), namun Dolores akan memantulkan serangan musuh sebesar 100% selama 2 ronde");
        System.out.println("Kode morse : " + kodemorse_skill2);
        System.out.println("Cooldown : 5 ronde\n");
    }

    public String[] skill1Mode(){
        String[] modeskill = {"attack musuh", "hl_reduction"};
        return modeskill;
    }

    public String[] skill2Mode(){
        String[] modeskill = {"memantulkan serangan"};
        return modeskill;
    }

    public int getAtt(){
        return default_att;
    }
}
