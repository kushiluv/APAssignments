public class elevator extends game{
    public void change_floorno_point(){
        System.out.println("Player position Floor-"+getFloor_no());
        setFloor_no(10);
        setPoint(4);
        System.out.println(getName()+" has reached the elevator floor");
        System.out.println("Total points "+getPoint());
    }
}
