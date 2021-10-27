import java.util.Scanner;

public  class ap3 {
    public static final Scanner scan = new Scanner(System.in);
    public static dice dice = new dice();
    public static player player = new player();

    public static void main(String[] args) {
        int[] scores = new int[1000];
        game ladder = new ladder();
        game empty_floor = new empty_floor();
        game normal_snake = new normal_snake();
        game kingcobra_snake = new kingcobra_snake();
        game elevator = new elevator();
        Scanner temps = new Scanner(System.in);
        String[] scores_name = new String[1000];
        int score_temp = 0;
        System.out.println("Enter number of players");
        int player_num = temps.nextInt();
        while (player_num > 0) {
            System.out.println("Enter the player name and hit enter");
            String temp = scan.nextLine();
            player.name = temp;
            System.out.println("The game setup is ready");
            int roll;
            while (true) {
                game.disp();
                scan.nextLine();
                roll = dice.roll();
                System.out.println("Dice gave " + roll);
                if (roll != 1) {
                    System.out.println("Game cannot start until you get 1");
                } else {
                    System.out.println("Dice gave 1\n" +
                            "Player position Floor-0\n" + game.name +
                            " has reached an Empty Floor\n" +
                            "Total points 1");
                    break;
                }


            }
            while (true) {
                game.disp();
                scan.nextLine();
                roll = dice.roll();
                System.out.println("Dice gave " + roll);
                if (game.floor_no == 12) {
                    if (roll == 2) {
                        System.out.println("Player cannot move");
                        continue;
                    } else {
                        game.floor_no += roll;
                        empty_floor.change_floorno_point();
                        game.end();
                        scores[score_temp] = game.point;
                        scores_name[score_temp]=game.name;
                        score_temp++;
                        break;

                    }
                }
                game.floor_no += roll;
                int tem = game.floor_type();
                if (tem == 0) {
                    empty_floor.change_floorno_point();
                } else if (tem == 2) {
                    elevator.change_floorno_point();
                    empty_floor.change_floorno_point();
                } else if (tem == 5) {
                    normal_snake.change_floorno_point();
                    empty_floor.change_floorno_point();
                } else if (tem == 8) {
                    ladder.change_floorno_point();
                    empty_floor.change_floorno_point();
                } else if (tem == 11) {
                    kingcobra_snake.change_floorno_point();
                    empty_floor.change_floorno_point();
                }

            }

        player_num--;
        }
        System.out.println("The scores of the players were as follows:");
        int max=-1000;
        String temp="user";
        for(int i=0;i<score_temp;i++){
            System.out.println(scores_name[i]+"'s score: "+scores[i]);
            if(max<scores[i]){
                temp = scores_name[i];
                max = scores[i];
            }
        }
        System.out.println(temp+" won with a total of "+max+" points.");

    }
    }
