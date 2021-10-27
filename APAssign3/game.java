public abstract class game extends player{

    abstract public void change_floorno_point();

    public static int floor_type(){
        if (floor_no==0||floor_no==1||floor_no==3||floor_no==4||floor_no==6||floor_no==7||floor_no==9||floor_no==10||floor_no==12||floor_no==13){
            return 0;
        }
        else if(floor_no==2){
            return 2;
        }
        else if(floor_no==5){
            return 5;
        }
        else if(floor_no==8){
            return 8;
        }
        else {
            return 11;
        }

    }
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
    public static void setName(String nam){
        name = nam;
    }
    public static String getName(){
        return name;
    }
}
