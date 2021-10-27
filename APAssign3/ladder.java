public class ladder extends game {
    public void change_floorno_point(){
        System.out.println("Player position Floor-"+floor_no);
        setFloor_no(12);
        setPoint(2);
        System.out.println(name+" has reached ladder floor");
        System.out.println("Total points "+point);
    }

}
