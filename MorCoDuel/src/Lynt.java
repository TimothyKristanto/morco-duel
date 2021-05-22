class Lynt implements Hero{

    public static int hp = 1000;
    public static int att = 40;
    public static int default_att = 40;
    public static int speed = 60;
    public static String kodemorse_skill1 = MorseCode.randomLetter();
    public static String kodemorse_skill2 = MorseCode.randomLetter();
    public static int skill1_cooldown = 3;
    public static int skill2_cooldown = 6;
    public static int heal = 300;

    public int attack(int hp_musuh){
        return hp_musuh - att;
    }

    public int[] skill1(int hp_musuh, int att_musuh) {
        int[] res = new int[2];

        hp -= 0.1 * hp;
        default_att = (int) (default_att + (0.5 * default_att));
        res[0] = hp;
        res[1] = default_att;

        return res;
    }

    public int[] skill2(int hp_musuh, int att_musuh){
        int[] res = new int[3];
        int att_up = 0;

        hp += 300 - GameProcess.heal_lifesteal_reduction;
        if(hp > 1000){
            hp = 1000;
        }
        att_up = 3 * att;

        hp_musuh -= att_up;

        res[0] = hp ;
        res[1] = hp_musuh;
        res[2] = att_up;
        return res;
    }

    public void status() throws InterruptedException{
        System.out.println("==========================");
        System.out.println("|     Lynt's Status      |");
        System.out.println("==========================");
        Thread.sleep(1500);
        System.out.println("HP : " + hp);
        System.out.println("Attack : " + att);
        System.out.println("Speed : " + speed);
        System.out.println("Skill 1 : Mengurangi HP Lynt sebanyak 10%, namun attack Lynt bertambah sebanyak 50% secara permanen");
        System.out.println("Kode morse : " + kodemorse_skill1);
        System.out.println("Cooldown : 3 ronde");
        System.out.println("Skill 2/Ult : Lynt akan melakukan heal sebesar 300 (HP + 300). Lalu, melakukan attack sebesar (basic attack +300%) pada ronde itu");
        System.out.println("Kode morse : " + kodemorse_skill2);
        System.out.println("Cooldown : 6 ronde\n");
    }

    public String[] skill1Mode(){
        String[] modeSkill = {"hp down", "att up"};
        return modeSkill;
    }

    public String[] skill2Mode(){
        String[] modeSkill = {"hp up", "attack musuh", "att up temp"};
        return modeSkill;
    }

    public int getAtt(){
        return default_att;
    }
}
