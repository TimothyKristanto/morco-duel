public class HeroList {

    public static void hero_list() throws InterruptedException {
        System.out.println("=================================");
        System.out.println("|         PEMILIHAN HERO        |");
        System.out.println("=================================\n");

        System.out.println("1. Lynt");
        System.out.println("Attack : 40");
        System.out.println("HP : 1000");
        System.out.println("Speed : 60");
        System.out.println("Skill 1 : Mengurangi HP Lynt sebanyak 10%, namun attack Lynt bertambah sebanyak 50% secara permanen");
        System.out.println("Cooldown : 3 ronde");
        System.out.println("Skill 2/Ult : Jika HP habis, Lynt akan tetap hidup dengan jumlah HP tersisa 40%. Lalu, melakukan attack sebesar (basic attack +300%) pada ronde itu");
        System.out.println("Cooldown : 6 ronde\n");

        System.out.println("2. Voaldigard");
        System.out.println("Attack : 75");
        System.out.println("HP : 700");
        System.out.println("Speed : 80");
        System.out.println("Skill 1 : Menambah damage +30% secara permanen");
        System.out.println("Cooldown : 2 ronde");
        System.out.println("SKill 2/Ult : Melangsungkan basic attack pada lawan dan Voaldigard mendapat lifesteal sebesar (total attack voaldigard + 25%)");
        System.out.println("Cooldown : 4 ronde\n");

        System.out.println("3. Hasan");
        System.out.println("Attack : 90");
        System.out.println("HP : 750");
        System.out.println("Speed : 100");
        System.out.println("Skill 1 : Melakukan basic attack dengan kemungkinan 'critical hit' (basic attack +100%) sebesar 20%");
        System.out.println("Cooldown : 2 ronde");
        System.out.println("SKill 2/Ult : Memiliki 100% kemungkinan untuk menghindari serangan musuh pada ronde itu");
        System.out.println("Cooldown : 3 ronde\n");

        System.out.println("4. Anzen Sebu");
        System.out.println("Attack : 50");
        System.out.println("HP : 800");
        System.out.println("Speed : 70");
        System.out.println("Skill 1 : Heal 150 HP");
        System.out.println("Cooldown : 3 ronde");
        System.out.println("SKill 2/Ult : Memberi efek 'Bleeding' kepada musuh yang mengurangi HP musuh sebanyak 10% (10% * hp musuh pada waktu skill ini dipakai) selama 3 ronde");
        System.out.println("Cooldown : 5 ronde\n");

        System.out.println("5. Dolores");
        System.out.println("Attack : 80");
        System.out.println("HP : 850");
        System.out.println("Speed : 75");
        System.out.println("Skill 1 : Melakukan attack sebesar (total attack + 20%) pada ronde itu.\nMengurangi efek 'Heal' dan 'Lifesteal' musuh sebanyak 50% selama 2 ronde");
        System.out.println("Cooldown : 3 ronde");
        System.out.println("SKill 2/Ult : Dolores akan terkena serangan musuh (kecuali serangan musuh berbentuk efek seperti bleeding), namun Dolores akan memantulkan serangan musuh sebesar 100% selama 2 ronde jika HP Dolores belum habis");
        System.out.println("Cooldown : 5 ronde\n");
    }

}
