public class floors extends player {
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

    public static void empty_floor(){
        point++;
        System.out.println("Player position Floor-"+floor_no);
        System.out.println(name+" has reached an empty floor");
        System.out.println("Total points "+point);

    }
    public static void normal_snake(){
        point=point-2;
        System.out.println("Player position Floor-"+floor_no);
        floor_no=1;
        System.out.println(name+" has reached normal snake floor");
        System.out.println("Total points "+point);
        empty_floor();

    }
    public static void kingcobra_snake(){
        System.out.println("Player position Floor-"+floor_no);
        floor_no=3;
        point=point-4;
        System.out.println(name+" has reached king cobra");
        System.out.println("Total points "+point);
        empty_floor();
    }
    public static void ladder(){
        System.out.println("Player position Floor-"+floor_no);
        floor_no=12;
        point = point+2;
        System.out.println(name+" has reached ladder floor");
        System.out.println("Total points "+point);
        empty_floor();
    }

    public static void elevator(){
        System.out.println("Player position Floor-"+floor_no);
        floor_no=10;
        point = point+4;
        System.out.println(name+" has reached the elevator floor");
        System.out.println("Total points "+point);
        empty_floor();
    }


}
