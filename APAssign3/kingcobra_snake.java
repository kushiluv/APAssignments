public class kingcobra_snake extends game {
    public void change_floorno_point(){
        System.out.println("Player position Floor-"+floor_no);
        setFloor_no(3);
        setPoint(-4);
        System.out.println(name+" has reached king cobra");
        System.out.println("Total points "+point);
    }
}
