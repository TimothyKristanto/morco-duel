import java.util.*;

public class GameProcess {
    public static int heal_lifesteal_reduction = 0;
    public static int heal_lifesteal = 0;
    public static Hero hero1;
    public static Hero hero2;
    public static int bleeding_round = 0;
    public static int heal_lifesteal_reduce_round = 0;
    public static int round_memantulkan_serangan = 0;

    public static void game_process(String player1, String player2, int turn) throws InterruptedException {
        MorseCode.fillMorsecode();
        Scanner scan = new Scanner(System.in);
        int round = 1, giliran, bleeding = 0, hl_reduction = 0, giliran_temp = 0;
        String input_kodemorse;
        boolean cek_kodemorse, reflect_stats = false, bleeding_stats = false, use_reflect = false, menghindar = false, attup_temp = false;
        int[] pilih = new int[2];
        String[] player = {player1, player2};

        int[] hero_selected = HeroSelection.hero_selection(player1, player2, turn);
        int[][] heroStats = firstStatusAssignment(hero_selected);

        String[] nama_hero = {HeroSelection.heroes[hero_selected[0] - 1], HeroSelection.heroes[hero_selected[1] - 1]};
        int[] hp = {heroStats[0][0], heroStats[1][0]};
        int[] att = {heroStats[0][1], heroStats[1][1]};
        int[] speed = {heroStats[0][2], heroStats[1][2]};
        int[] cooldown_skill1 = {0, 0};
        int[] cooldown_skill2 = {0, 0};
        int[] skill1 = new int[3];
        int[] skill2 = new int[3];
        int[] hl = {heroStats[0][5], heroStats[1][5]};

        Thread.sleep(1500);
        MorCoDuel.pembatas();
        System.out.println("\n▀█████████▄     ▄████████     ███         ███      ▄█          ▄████████         ▄████████  ▄██████▄  ███    █▄  ███▄▄▄▄   ████████▄     ▄████████ \n" +
                "  ███    ███   ███    ███ ▀█████████▄ ▀█████████▄ ███         ███    ███        ███    ███ ███    ███ ███    ███ ███▀▀▀██▄ ███   ▀███   ███    ███ \n" +
                "  ███    ███   ███    ███    ▀███▀▀██    ▀███▀▀██ ███         ███    █▀         ███    ███ ███    ███ ███    ███ ███   ███ ███    ███   ███    █▀  \n" +
                " ▄███▄▄▄██▀    ███    ███     ███   ▀     ███   ▀ ███        ▄███▄▄▄           ▄███▄▄▄▄██▀ ███    ███ ███    ███ ███   ███ ███    ███   ███        \n" +
                "▀▀███▀▀▀██▄  ▀███████████     ███         ███     ███       ▀▀███▀▀▀          ▀▀███▀▀▀▀▀   ███    ███ ███    ███ ███   ███ ███    ███ ▀███████████ \n" +
                "  ███    ██▄   ███    ███     ███         ███     ███         ███    █▄       ▀███████████ ███    ███ ███    ███ ███   ███ ███    ███          ███ \n" +
                "  ███    ███   ███    ███     ███         ███     ███▌    ▄   ███    ███        ███    ███ ███    ███ ███    ███ ███   ███ ███   ▄███    ▄█    ███ \n" +
                "▄█████████▀    ███    █▀     ▄████▀      ▄████▀   █████▄▄██   ██████████        ███    ███  ▀██████▀  ████████▀   ▀█   █▀  ████████▀   ▄████████▀  \n" +
                "                                                  ▀                             ███    ███                                                         ");
        MorCoDuel.pembatas();


        giliran = firstTurn(speed[0], speed[1], nama_hero, player1, player2);

        Thread.sleep(1500);

        do {
            MorCoDuel.pembatas();
            System.out.println("Round " + round);

            for(int i = 0; i < cooldown_skill1.length; i++){
                if(cooldown_skill1[i] > 0){
                    cooldown_skill1[i] -= 1;
                }
            }

            for(int i = 0; i < cooldown_skill2.length; i++){
                if(cooldown_skill2[i] > 0){
                    cooldown_skill2[i] -= 1;
                }
            }

            if(heal_lifesteal_reduce_round > 0){
                heal_lifesteal_reduce_round -= 1;
            }else{
                heal_lifesteal_reduction = 0;
            }

            if(bleeding_round > 0){
                bleeding_round -= 1;
            }

            if(round_memantulkan_serangan > 0){
                round_memantulkan_serangan -= 1;
            }else{
                use_reflect = false;
            }

            for (int i = 0; i < 2; i++) {
                String[] kodemorse_skill = kodemorseAssignment(hero_selected, giliran);
                Thread.sleep(1500);
                System.out.println(nama_hero[giliran - 1] + " (" + player[giliran - 1] + ") : ");

                do {
                    showStats(giliran);
                    System.out.println("==================================");
                    System.out.println("|          ACTION MENU           |");
                    System.out.println("==================================");
                    System.out.println("1. Basic attack");
                    if (cooldown_skill1[giliran - 1] == 0) System.out.println("2. Skill 1 (Ready)");
                    else System.out.println("2. Skill 1 (Cooldown : " + cooldown_skill1[giliran - 1] + ")");
                    if (cooldown_skill2[giliran - 1] == 0) System.out.println("3. Skill 2 (Ready)");
                    else System.out.println("3. Skill 2 (Cooldown : " + cooldown_skill2[giliran - 1] + ")");
                    System.out.print("Silahkan pilih : ");
                    pilih[giliran - 1] = scan.nextInt();

                    if (pilih[giliran - 1] == 1) {
                        break;
                    } else if (pilih[giliran - 1] == 2) {
                        if (cooldown_skill1[giliran - 1] == 0) {
                            MorseCode.showMorsecode();
                            System.out.print("Masukkan kode morse dari huruf '" + kodemorse_skill[0] + "' : ");
                            input_kodemorse = scan.next() + scan.nextLine();
                            cek_kodemorse = MorseCode.checkMorsecode(input_kodemorse, kodemorse_skill[0]);
                            if (cek_kodemorse == false) {
                                System.out.println("Anda salah memasukkan kode morse! Skill akan masuk dalam cooldown!");
                            }
                            cooldown_skill1[giliran - 1] = heroStats[giliran - 1][3];
                            if(cek_kodemorse == true){
                                break;
                            }

                        } else {
                            System.out.println("Skill sedang cooldown!");
                            System.out.println("====================================");
                        }
                    } else if (pilih[giliran - 1] == 3) {
                        if (cooldown_skill2[giliran - 1] == 0) {
                            MorseCode.showMorsecode();
                            System.out.print("Masukkan kode morse dari huruf '" + kodemorse_skill[1] + "' : ");
                            input_kodemorse = scan.next() + scan.nextLine();
                            cek_kodemorse = MorseCode.checkMorsecode(input_kodemorse, kodemorse_skill[1]);
                            if (cek_kodemorse == false) {
                                System.out.println("Anda salah memasukkan kode morse! Skill akan masuk dalam cooldown!");
                            }
                            cooldown_skill2[giliran - 1] = heroStats[giliran - 1][4];
                            if(cek_kodemorse == true){
                                break;
                            }
                        } else {
                            System.out.println("Skill sedang cooldown!");
                        }
                    } else {
                        System.out.println("Pilihan Anda harus berada pada range 1-3! Silahkan dicoba lagi");
                    }

                } while (true);

                if (giliran == 1) giliran = 2;
                else giliran = 1;
                MorCoDuel.ClearScreen();
            }

            for (int i = 0; i < 2; i++) {
                if(giliran == 1){
                    heal_lifesteal = hl[1];
                }else {
                    heal_lifesteal = hl[0];
                }

                if (pilih[giliran - 1] == 1) {
                    System.out.println(nama_hero[giliran - 1] + " (" + player[giliran - 1] + ") menggunakan basic attack!");
                    if (giliran == 1) {
                        hp[1] = hero1.attack(hp[1]);
                    } else {
                        hp[0] = hero2.attack(hp[0]);
                    }
                    reflect_stats = true;
                } else if (pilih[giliran - 1] == 2) {
                    System.out.println(nama_hero[giliran - 1] + " (" + player[giliran - 1] + ") menggunakan Skill 1!");
                    if (giliran == 1) {
                        skill1 = hero1.skill1( hp[1], att[1]);
                        for (String x : hero1.skill1Mode()) {
                            if (x.equals("att up")) {
                                att[0] = skill1[1];

                            } else if (x.equals("hp up") || x.equals("hp down")) {
                                hp[0] = skill1[0];

                            } else if (x.equals("attack musuh")) {
                                hp[1] = skill1[1];
                                reflect_stats = true;
                            } else if(x.equals("att up temp")){
                                att[0] = skill1[2];
                                attup_temp = true;
                                giliran_temp = giliran;
                            }
                        }
                    } else {
                        skill1 = hero2.skill1(hp[0], att[0]);
                        for (String x : hero2.skill1Mode()) {
                            if (x.equals("att up")) {
                                att[1] = skill1[1];
                            } else if (x.equals("hp up") || x.equals("hp down")) {
                                hp[1] = skill1[0];
                            } else if (x.equals("attack musuh")) {
                                hp[0] = skill1[1];
                                reflect_stats = true;
                            } else if(x.equals("att up temp")){
                                att[1] = skill1[2];
                                attup_temp = true;
                                giliran_temp = giliran;
                            }
                        }
                    }

                } else if (pilih[giliran - 1] == 3) {
                    System.out.println(nama_hero[giliran - 1] + " (" + player[giliran - 1] + ") menggunakan Skill 2!");
                    if (giliran == 1) {
                        skill2 = hero1.skill2(hp[1], att[1]);
                        for (String x : hero1.skill2Mode()) {
                            if (x.equals("att up")) {
                                att[0] = skill2[1];
                            } else if (x.equals("hp up") || x.equals("hp down")) {
                                hp[0] = skill2[0];
                            } else if (x.equals("attack musuh")) {
                                hp[1] = skill2[1];
                                reflect_stats = true;
                            } else if (x.equals("menghindar")) {
                                menghindar = true;
                                att[1] = skill2[0];
                            } else if (x.equals("bleeding")) {
                                bleeding = skill2[0];
                                bleeding_stats = true;
                            }else if(x.equals("memantulkan serangan")){
                                use_reflect = true;
                            }else if(x.equals("lifesteal")){
                                hp[0] += skill2[0] - (skill2[0] * hl_reduction/100);
                            }else if(x.equals("hl_reduction")){
                                hl_reduction = skill2[0];
                            }else if(x.equals("att up temp")){
                                att[0] = skill2[2];
                                attup_temp = true;
                                giliran_temp = giliran;
                            }
                        }
                    } else {
                        skill2 = hero2.skill2(hp[0], att[0]);
                        for (String x : hero2.skill2Mode()) {
                            if (x.equals("att up")) {
                                att[1] = skill2[1];
                            } else if (x.equals("hp up") || x.equals("hp down")) {
                                hp[1] = skill2[0];
                            } else if (x.equals("attack musuh")) {
                                hp[0] = skill2[1];
                                reflect_stats = true;
                            } else if (x.equals("menghindar")) {
                                menghindar = true;
                                att[0] = skill2[0];
                            } else if (x.equals("bleeding")) {
                                bleeding = skill2[0];
                                bleeding_stats = true;
                            }else if(x.equals("memantulkan serangan")){
                                use_reflect = true;
                            }else if(x.equals("lifesteal")){
                                hp[1] += skill2[0] - (skill2[0] * hl_reduction/100);
                            }else if(x.equals("hl_reduction")){
                                hl_reduction = skill2[0];
                            }else if(x.equals("att up temp")){
                                att[1] = skill2[2];
                                attup_temp = true;
                                giliran_temp = giliran;
                            }
                        }
                    }

                }

                finalStatusAssignment(hero_selected, hp, att);

                if(giliran == 1){
                    if(hp[1] <= 0){
                        break;
                    }
                }else {
                    if(hp[0] <= 0){
                        break;
                    }
                }

                if (giliran == 1){
                    giliran = 2;
                }
                else{
                    giliran = 1;
                }
            }

            for (int i = 0; i < hero_selected.length; i++) {
                if (hero_selected[i] == 3 && menghindar == true) {
                    if(i == 1) {
                        att[0] = hero1.getAtt();
                    }else{
                        att[1] = hero2.getAtt();
                    }
                    menghindar = false;
                }

                if(hero_selected[i] == 4 && bleeding_stats == true){
                    if(bleeding_round <= 0){
                        bleeding_stats = false;
                    }else {
                        if (i == 0) {
                            hp[1] -= bleeding;
                        } else {
                            hp[0] -= bleeding;
                        }
                    }
                }

                if(hero_selected[i] == 5 && reflect_stats == true && use_reflect == true){
                    if(round_memantulkan_serangan <= 0){
                        use_reflect = false;
                    }else {
                        if (i == 0) {
                            hp[1] -= att[1];
                        } else {
                            hp[0] -= att[0];
                        }
                    }
                    reflect_stats = false;
                }
            }

            if(attup_temp == true){
                attup_temp = false;
                if(giliran_temp == 1) {
                    att[0] = hero1.getAtt();
                }else{
                    att[1] = hero2.getAtt();
                }
            }

            if(hp[0] < 0){

                hp[0] = 0;
            }

            if (hp[1] < 0){
                hp[1] = 0;
            }

            finalStatusAssignment(hero_selected, hp, att);

            showStats(1);
            showStats(2);
            round++;

        }while(hp[0] > 0 && hp[1] > 0);

        System.out.println("=============================================================================");
        System.out.println(" _______  _______  _______  _______    _______           _______  _______ \n" +
                "(  ____ \\(  ___  )(       )(  ____ \\  (  ___  )|\\     /|(  ____ \\(  ____ )\n" +
                "| (    \\/| (   ) || () () || (    \\/  | (   ) || )   ( || (    \\/| (    )|\n" +
                "| |      | (___) || || || || (__      | |   | || |   | || (__    | (____)|\n" +
                "| | ____ |  ___  || |(_)| ||  __)     | |   | |( (   ) )|  __)   |     __)\n" +
                "| | \\_  )| (   ) || |   | || (        | |   | | \\ \\_/ / | (      | (\\ (   \n" +
                "| (___) || )   ( || )   ( || (____/\\  | (___) |  \\   /  | (____/\\| ) \\ \\__\n" +
                "(_______)|/     \\||/     \\|(_______/  (_______)   \\_/   (_______/|/   \\__/");
        System.out.println("=============================================================================");

        if(giliran == 2){
            System.out.println("HP " + nama_hero[0] + "(" + player1 + ")" + " telah habis dahulu! " + player2 + " memenangkan pertandingan ini!");
        }else{
            System.out.println("HP " + nama_hero[1] + "(" + player2 + ")" + " telah habis dahulu! " + player1 + " memenangkan pertandingan ini!");
        }
    }

    public static int[][] firstStatusAssignment(int[] hero_selected){
        int[][] status = new int[2][6];

        for(int i = 0; i < status.length; i++) {
            switch (hero_selected[i]) {
                case 1:
                    if (i == 0) hero1 = new Lynt();
                    else hero2 = new Lynt();
                    status[i][0] = Lynt.hp;
                    status[i][1] = Lynt.att;
                    status[i][2] = Lynt.speed;
                    status[i][3] = Lynt.skill1_cooldown;
                    status[i][4] = Lynt.skill2_cooldown;
                    status[i][5] = Lynt.heal;
                    break;
                case 2:
                    if (i == 0) hero1 = new Voaldigard();
                    else hero2 = new Voaldigard();
                    status[i][0] = Voaldigard.hp;
                    status[i][1] = Voaldigard.att;
                    status[i][2] = Voaldigard.speed;
                    status[i][3] = Voaldigard.skill1_cooldown;
                    status[i][4] = Voaldigard.skill2_cooldown;
                    status[i][5] = Voaldigard.heal;
                    break;
                case 3:
                    if (i == 0) hero1 = new Hasan();
                    else hero2 = new Hasan();
                    status[i][0] = Hasan.hp;
                    status[i][1] = Hasan.att;
                    status[i][2] = Hasan.speed;
                    status[i][3] = Hasan.skill1_cooldown;
                    status[i][4] = Hasan.skill2_cooldown;
                    status[i][5] = Hasan.heal;
                    break;
                case 4:
                    if (i == 0) hero1 = new AnzenSebu();
                    else hero2 = new AnzenSebu();
                    status[i][0] = AnzenSebu.hp;
                    status[i][1] = AnzenSebu.att;
                    status[i][2] = AnzenSebu.speed;
                    status[i][3] = AnzenSebu.skill1_cooldown;
                    status[i][4] = AnzenSebu.skill2_cooldown;
                    status[i][5] = AnzenSebu.heal;
                    break;
                case 5:
                    if (i == 0) hero1 = new Dolores();
                    else hero2 = new Dolores();
                    status[i][0] = Dolores.hp;
                    status[i][1] = Dolores.att;
                    status[i][2] = Dolores.speed;
                    status[i][3] = Dolores.skill1_cooldown;
                    status[i][4] = Dolores.skill2_cooldown;
                    status[i][5] = Dolores.heal;
                    break;
            }
        }
        return status;
    }

    public static void showStats(int giliran) throws InterruptedException{
        switch(giliran){
            case 1:
                hero1.status();
                break;
            case 2:
                hero2.status();
                break;
        }
    }

    public static String[] kodemorseAssignment(int[] hero_selection, int giliran){
        String[] morse = new String[2];

        switch(hero_selection[giliran - 1]){
            case 1:
                morse[0] = Lynt.kodemorse_skill1;
                morse[1] = Lynt.kodemorse_skill2;
                break;
            case 2:
                morse[0] = Voaldigard.kodemorse_skill1;
                morse[1] = Voaldigard.kodemorse_skill2;
                break;
            case 3:
                morse[0] = Hasan.kodemorse_skill1;
                morse[1] = Hasan.kodemorse_skill2;
                break;
            case 4:
                morse[0] = AnzenSebu.kodemorse_skill1;
                morse[1] = AnzenSebu.kodemorse_skill2;
                break;
            case 5:
                morse[0] = Dolores.kodemorse_skill1;
                morse[1] = Dolores.kodemorse_skill2;
                break;
        }
        return morse;
    }

    private static int firstTurn(int speed1, int speed2, String[] heroes, String player1, String player2){
        System.out.println("Speed karakter " + heroes[0] + " --> " + speed1);
        System.out.println("Speed karakter " + heroes[1] + " --> " + speed2);
        if(speed1 > speed2){
            System.out.println(heroes[0] + " memiliki speed yang lebih tinggi, maka " + player1 + " mendapatkan giliran pertama!");
            return 1;
        }
        System.out.println(heroes[1] + " memiliki speed yang lebih tinggi, maka " + player2 + " mendapatkan giliran pertama!");
        return 2;
    }

    public static void finalStatusAssignment(int[] hero_selected, int[] hp, int[] att){
        for(int i = 0; i < hero_selected.length; i++) {
            switch (hero_selected[i]) {
                case 1:
                    Lynt.hp = hp[i];
                    Lynt.att = att[i];
                    break;
                case 2:
                    Voaldigard.hp = hp[i];
                    Voaldigard.att = att[i];
                    break;
                case 3:
                    Hasan.hp = hp[i];
                    Hasan.att = att[i];
                    break;
                case 4:
                    AnzenSebu.hp = hp[i];
                    AnzenSebu.att = att[i];
                    break;
                case 5:
                    Dolores.hp = hp[i];
                    Dolores.att = att[i];
                    break;
            }
        }
    }

}
