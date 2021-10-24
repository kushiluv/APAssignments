import java.util.Scanner;

public class ap3 extends floors{
    public static final Scanner scan = new Scanner(System.in);
    public static dice dice = new dice();

    public static void main(String[] args) {
        System.out.println("Enter the player name and hit enter");
        String temp = scan.nextLine();
        name = temp;
        System.out.println("The game setup is ready");
        int roll;

        while(true){
            disp();
            scan.nextLine();
            roll = dice.roll();
            System.out.println("Dice gave "+roll);
            if(roll!=1){
                System.out.println("Game cannot start until you get 1");
            }
            else {
                System.out.println("Dice gave 1\n" +
                        "Player position Floor-0\n" +name+
                        " has reached an Empty Floor\n" +
                        "Total points 1");
                break;
            }


        }
        while(true){
            disp();
            scan.nextLine();
            roll = dice.roll();
            System.out.println("Dice gave "+roll);
            if(floor_no==12){
                if(roll==2){
                    System.out.println("Player cannot move");
                }
                else{
                    empty_floor();
                    end();
                    break;

                }
            }
            floor_no+=roll;
            int tem = floor_type();
            if(tem==0){
                empty_floor();
            }
            else if(tem==2){
                elevator();
            }
            else if(tem==5){
                normal_snake();

            }
            else if(tem==8){
                ladder();
            }
            else if(tem==11){
                kingcobra_snake();
            }

        }

    }
    }
