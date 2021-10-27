public class empty_floor extends game{
    public void change_floorno_point(){
        setPoint(1);
        System.out.println("Player position Floor-"+floor_no);
        System.out.println(name+" has reached an empty floor");
        System.out.println("Total points "+point);
    }
}
