import java.util.Scanner;

public class ap3 extends floors{
    public static final Scanner scan = new Scanner(System.in);
    public static dice dice = new dice();

    public static void main(String[] args) {
        int[] scores = new int[1000];
        Scanner temps = new Scanner(System.in);
        String[] scores_name = new String[1000];
        int score_temp = 0;
        System.out.println("Enter number of players");
        int player_num = temps.nextInt();
        while (player_num > 0) {
            System.out.println("Enter the player name and hit enter");
            String temp = scan.nextLine();
            name = temp;
            System.out.println("The game setup is ready");
            int roll;
            while (true) {
                disp();
                scan.nextLine();
                roll = dice.roll();
                System.out.println("Dice gave " + roll);
                if (roll != 1) {
                    System.out.println("Game cannot start until you get 1");
                } else {
                    System.out.println("Dice gave 1\n" +
                            "Player position Floor-0\n" + name +
                            " has reached an Empty Floor\n" +
                            "Total points 1");
                    break;
                }


            }
            while (true) {
                disp();
                scan.nextLine();
                roll = dice.roll();
                System.out.println("Dice gave " + roll);
                if (floor_no == 12) {
                    if (roll == 2) {
                        System.out.println("Player cannot move");
                        continue;
                    } else {
                        floor_no += roll;
                        empty_floor();
                        end();
                        scores[score_temp] = point;
                        scores_name[score_temp]=name;
                        score_temp++;
                        break;

                    }
                }
                floor_no += roll;
                int tem = floor_type();
                if (tem == 0) {
                    empty_floor();
                } else if (tem == 2) {
                    elevator();
                } else if (tem == 5) {
                    normal_snake();

                } else if (tem == 8) {
                    ladder();
                } else if (tem == 11) {
                    kingcobra_snake();
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
        System.out.println(temp+"won with a total of "+max+" points.");

    }
    }
