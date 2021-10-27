public class player {
    private static  int floor_no=0;
    private static String name;
    private static int point=1;

    public static int getFloor_no(){
        return floor_no;
    }
    public static void setFloor_no(int num){
        floor_no = num;
    }
    public static int getPoint(){
        return point;
    }
    public static void setPoint(int poin){
        point += poin;
    }
    public static void setPoint1(){
        point =1;
    }

    public static void setName(String nam){
        name = nam;
    }
    public static String getName(){
        return name;
    }

}
