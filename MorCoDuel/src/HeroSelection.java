import java.util.*;

public class HeroSelection {

    public static String[] heroes = {"Lynt", "Voaldigard", "Hasan", "Anzen Sebu", "Dolores"};

    public static int[] hero_selection(String player1, String player2, int turn) throws InterruptedException{
        Scanner scan = new Scanner(System.in);

        int hero1 = 0, hero2 = 0;
        boolean valid = true;
        int[] hero_selected = new int[2];

        do {
            HeroList.hero_list();

            do {
                System.out.println("Gunakan angka 1-5 untuk memilih hero!");

                if (turn == 1) {
                    System.out.print(player1 + " silahkan memilih hero : ");
                    hero1 = scan.nextInt();
                    if(hero1 > 5 || hero1 < 1) valid = false;
                    else valid = true;
                } else {
                    System.out.print(player2 + " silahkan memilih hero : ");
                    hero2 = scan.nextInt();
                    if(hero2 > 5 || hero2 < 1) valid = false;
                    else valid = true;
                }


            }while(valid == false);

            valid = true;

            MorCoDuel.ClearScreen();

            HeroList.hero_list();

            do {
                System.out.println("Gunakan angka 1-5 untuk memilih hero!");

                if (turn == 1) {
                    System.out.print(player2 + " silahkan memilih hero : ");
                    hero2 = scan.nextInt();
                    if(hero2 > 5 || hero2 < 1) valid = false;
                    else valid = true;
                } else {
                    System.out.print(player1 + " silahkan memilih hero : ");
                    hero1 = scan.nextInt();
                    if(hero1 > 5 || hero1 < 1) valid = false;
                    else valid = true;
                }
                if (hero2 == hero1) {
                    System.out.println("\nHero Anda telah dipakai oleh lawan! Silahkan pilih kembali!");
                    valid = false;
                }

            }while(valid == false);


            System.out.println("\n\n" + player1 + " telah memilih hero " + heroes[hero1 - 1]);
            System.out.println(player2 + " telah memilih hero " + heroes[hero2 - 1]);
            hero_selected[0] = hero1;
            hero_selected[1] = hero2;
            break;


        }while(true);

        return hero_selected;


    }

}