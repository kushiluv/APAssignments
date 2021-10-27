public abstract class game extends player{

    abstract public void change_floorno_point();

    public static void disp(){
        System.out.println("Hit enter to roll the dice");
    }

    public static void end(){
        System.out.println("Game over");
        System.out.println(getName()+" accumulated "+getPoint()+" points");
        System.out.println("---------------------------------------------------------------");
    }
    public static int floor_type(){
        if (getFloor_no()==0||getFloor_no()==1||getFloor_no()==3||getFloor_no()==4||getFloor_no()==6||getFloor_no()==7||getFloor_no()==9||getFloor_no()==10||getFloor_no()==12||getFloor_no()==13){
            return 0;
        }
        else if(getFloor_no()==2){
            return 2;
        }
        else if(getFloor_no()==5){
            return 5;
        }
        else if(getFloor_no()==8){
            return 8;
        }
        else {
            return 11;
        }

    }

}
