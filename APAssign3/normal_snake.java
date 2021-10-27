public class normal_snake extends game {
    public void change_floorno_point(){
        setPoint(-2);
        System.out.println("Player position Floor-"+getFloor_no());
        setFloor_no(3);
        System.out.println(getName()+" has reached normal snake floor");
        System.out.println("Total points "+getPoint());
    }
}
