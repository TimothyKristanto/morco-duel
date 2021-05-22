import java.util.*;

public class MorCoDuel {

    public static int sleep = 1000;

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);

        String paham, player1, player2;
        int turn;

        String banner = "███╗   ███╗ ██████╗ ██████╗  ██████╗ ██████╗ ██████╗ ██╗   ██╗███████╗██╗     \n" +
                "████╗ ████║██╔═══██╗██╔══██╗██╔════╝██╔═══██╗██╔══██╗██║   ██║██╔════╝██║     \n" +
                "██╔████╔██║██║   ██║██████╔╝██║     ██║   ██║██║  ██║██║   ██║█████╗  ██║     \n" +
                "██║╚██╔╝██║██║   ██║██╔══██╗██║     ██║   ██║██║  ██║██║   ██║██╔══╝  ██║     \n" +
                "██║ ╚═╝ ██║╚██████╔╝██║  ██║╚██████╗╚██████╔╝██████╔╝╚██████╔╝███████╗███████╗\n" +
                "╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═╝ ╚═════╝ ╚═════╝ ╚═════╝  ╚═════╝ ╚══════╝╚══════╝";

        String[] banner1 = banner.split("\n");
        pembatas();
        for(String x : banner1){
            System.out.println(x);
            Thread.sleep(300);
        }
        pembatas();
        Thread.sleep(sleep);

        do {
            GameRule.game_rule();
            System.out.print("Apakah Anda sudah paham mengenai peraturan permainannya (sudah/belum)? ");
            paham = scan.next().toLowerCase();
        }while(paham.equals("belum"));

        pembatas();

        System.out.print("Silahkan masukkan username player 1 : ");
        player1 = scan.next() + scan.nextLine();

        System.out.print("Silahkan masukkan username player 2 : ");
        player2 = scan.next() + scan.nextLine();

        pembatas();

        turn = randomFirstTurn();
        System.out.println("Sedang dalam proses pemilihan player yang akan mendapatkan giliran pertama untuk memilih hero, harap bersabar");
        loading();

        if(turn == 1) {
            System.out.println("Player " + turn + " (" + player1 + ") mendapatkan giliran pertama untuk memilih hero");
        }
        else {
            System.out.println("Player " + turn + " (" + player2 + ") mendapatkan giliran pertama untuk memilih hero");
        }
        Thread.sleep(sleep);

        pembatas();

        GameProcess.game_process(player1, player2, turn);



    }
    public static void pembatas(){
        System.out.println("=============================================================================================================================");
    }

    public static void ClearScreen(){
        for(int i = 0; i < 50; i++){
            System.out.println("");
        }
    }

    private static int randomFirstTurn(){
        Random randint = new Random();

        int turn = randint.nextInt(2) + 1;

        return turn;
    }

    private static void loading() throws InterruptedException{
        Thread.sleep(1000);
        for(int i = 0; i < 3; i++){
            System.out.print(".");
            Thread.sleep(1000);
        }
        System.out.println("");
    }

}
