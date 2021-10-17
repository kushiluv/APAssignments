import java.util.ArrayList;
import java.util.Scanner;

public class instructor {
    public static final Scanner scan = new Scanner(System.in);
    private int id;
    private ArrayList<material> materials = new ArrayList<material>();

    public instructor(int id){
        this.id = id;
    }
    public void display(){
        System.out.println("Welcome I"+id);
    }
    public void addmaterial(){
        System.out.println("1. Add Lecture Slide\n" +
                "2. Add Lecture Video");
        int temp = scan.nextInt();
        if (temp==1){
            System.out.println("Enter topic of slides");
            String topic = scan.nextLine();
            System.out.println("Enter number of slides");
            int slides_num = scan.nextInt();
            System.out.println("Enter content of slides");
            ArrayList<String> content = new ArrayList<String>();
            for(int i =0;i<slides_num;i++){
                System.out.println("Content of slide "+i+1+" :");
                content.add(scan.nextLine());
            }
            material rial = new material(topic , content);
            materials.add(rial);
        }
        else if (temp==2){
            System.out.println("Enter topic of video");
            String topic = scan.nextLine();
            System.out.println("Enter filename of video");
            String filename = scan.nextLine();
            material rial = new material(topic,filename);
            materials.add(rial);
        }
        else{
            System.out.println("invalid input");
            return;
        }



    }


}
