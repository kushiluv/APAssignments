public class player {
    public static  int floor_no=0;
    public static String name;
    public static int point=1;


    public static void disp(){
        System.out.println("Hit enter to roll the dice");
    }
    public static void end(){
        System.out.println("Game over");
        System.out.println(name+" accumulated "+point+" points");
        System.out.println("---------------------------------------------------------------");
    }

}
