public class Voaldigard implements Hero{

    public static int default_hp = 700;
    public static int hp = 700;
    public static int att = 75;
    public static int default_att = 75;
    public static int speed = 80;
    public static String kodemorse_skill1 = MorseCode.randomLetter();
    public static String kodemorse_skill2 = MorseCode.randomLetter();
    public static int skill1_cooldown = 2;
    public static int skill2_cooldown = 4;
    public static int heal = 0;

    public int attack(int hp_musuh){
        return hp_musuh - att;
    }

    public int[] skill1(int hp_musuh, int att_musuh) {
        int[] res = new int[2];

        default_att = (int) (default_att + (default_att * 0.3));
        res[1] = default_att;
        return res;
    }

    public int[] skill2(int hp_musuh, int att_musuh) {
        int[] res = new int[2];
        int lifesteal = (int) (att + (att * 0.25));

        if((default_hp - hp) < lifesteal && (default_hp - hp) > 0) lifesteal = (default_hp - hp);

        res[0] = lifesteal;
        res[1] = hp_musuh - att;

        return res;
    }

    public void status() throws InterruptedException{
        System.out.println("==========================");
        System.out.println("|  Voaldigard's Status   |");
        System.out.println("==========================");
        Thread.sleep(1500);
        System.out.println("HP : " + hp);
        System.out.println("Attack : " + att);
        System.out.println("Speed : " + speed);
        System.out.println("Skill 1 : Menambah damage +30% secara permanen");
        System.out.println("Kode morse : " + kodemorse_skill1);
        System.out.println("Cooldown : 2 ronde");
        System.out.println("SKill 2/Ult : Melangsungkan basic attack pada lawan dan Voaldigard mendapat lifesteal sebesar (total attack voaldigard + 25%)");
        System.out.println("Kode morse : " + kodemorse_skill2);
        System.out.println("Cooldown : 4 ronde\n");
    }

    public String[] skill1Mode(){
        String[] modeskill = {"att up"};
        return modeskill;
    }

    public String[] skill2Mode(){
        String[] modeskill = {"attack musuh", "lifesteal"};
        return modeskill;
    }

    public int getAtt(){
        return default_att;
    }
}
