public class ladder extends game {
    public void change_floorno_point(){
        System.out.println("Player position Floor-"+getFloor_no());
        setFloor_no(12);
        setPoint(2);
        System.out.println(getName()+" has reached ladder floor");
        System.out.println("Total points "+getPoint());
    }

}
