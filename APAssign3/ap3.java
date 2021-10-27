import java.util.Scanner;

public  class ap3 {
    public static final Scanner scan = new Scanner(System.in);
    public static dice dice = new dice();

    public static void main(String[] args) {
        int[] scores = new int[1000];
        game empty_floor = new empty_floor();
        Scanner temps = new Scanner(System.in);
        String[] scores_name = new String[1000];
        int score_temp = 0;
        System.out.println("Enter number of players");
        int player_num = temps.nextInt();
        while (player_num > 0) {
            System.out.println("Enter the player name and hit enter");
            String temp = scan.nextLine();
            game.setName(temp);
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
                            "Player position Floor-0\n" + game.getName() +
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
                if (game.getFloor_no() == 12) {
                    if (roll == 2) {
                        System.out.println("Player cannot move");
                        continue;
                    } else {
                        game.setFloor_no(game.getFloor_no()+roll);
                        empty_floor.change_floorno_point();
                        game.end();
                        scores[score_temp] = game.getPoint();
                        scores_name[score_temp]=game.getName();
                        score_temp++;
                        game.setFloor_no(0);
                        game.setPoint1();
                        break;

                    }
                }
                game.setFloor_no(game.getFloor_no()+roll);
                System.out.println("floor is " + game.getFloor_no());
                int tem = game.floor_type();
                if (tem == 0) {
                    empty_floor.change_floorno_point();
                } else if (tem == 2) {
                    game elevator = new elevator();
                    elevator.change_floorno_point();
                    empty_floor.change_floorno_point();
                } else if (tem == 5) {
                    game normal_snake = new normal_snake();
                    normal_snake.change_floorno_point();
                    empty_floor.change_floorno_point();
                } else if (tem == 8) {
                    game ladder = new ladder();
                    ladder.change_floorno_point();
                    empty_floor.change_floorno_point();
                } else if (tem == 11) {
                    game kingcobra_snake = new kingcobra_snake();
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
