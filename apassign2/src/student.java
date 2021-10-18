import java.util.ArrayList;
import java.util.Scanner;
public class student {
    public static final Scanner scan = new Scanner(System.in);
    private int id;
    private ArrayList<assessment> assessments = instructor.getAssessments();
    public student(int id) {
        this.id = id;
    }
    public void display() {
        System.out.println("Welcome S" + id);
    }

    public void submit_assessments(){
        System.out.println("Pending assessments");
        int flag = 0;
        for(int i = 0 ; i< assessments.size();i++){
            if(!assessments.get(i).getclosed()&& assessments.get(i).getStudent_id()!=id){

                if(assessments.get(i).getType().equals("assignment")){flag++;
                    System.out.println("ID: " + assessments.get(i).getId() + " Assignment: " + assessments.get(i).getQuestion() + " Max Marks: " + assessments.get(i).getMarks() +
                            "\n----------------");}
                else{flag++;
                    System.out.println("ID: " + assessments.get(i).getId() + " Question: " + assessments.get(i).getQuestion() +
                            "\n----------------");
                }
            }
        }
        if(flag==0){
            System.out.println("no assessments found");
            return;
        }
        System.out.println("Enter ID of assessment: ");
        int tempid = scan.nextInt();
        for(int i = 0 ; i<assessments.size();i++){
            if(tempid==assessments.get(i).getId()){
                if(assessments.get(i).getType().equals("assignment")){
                    System.out.println("Enter filename of assignment:");
                    String file = scan.next();
                    if(file.length()<4){
                        System.out.println("file is of unsupported type");
                        return;
                    }
                    if(!file.substring(file.length()-4).equals(".zip")){
                        System.out.println("file is of unsupported type");
                        return;
                    }
                    else{
                        assessments.get(i).setSolution(file);
                        assessments.get(i).setSubmittedtrue();
                    }
                }
                else{
                    System.out.println(assessments.get(i).getQuestion());
                    scan.nextLine();
                    String ans = scan.nextLine();
                    assessments.get(i).setSolution(ans);

                }

            }
        }

        for(int i = 0 ; i<assessments.size();i++){
            if(assessments.get(i).getId()==tempid){
                assessments.get(i).setSubmittedtrue();
                assessments.get(i).setStudent_id(id);
            }
        }

    }
    public void view_grades(){
        System.out.println("Ungraded submissions:");
        for(int i = 0;i< assessments.size();i++){
            if(assessments.get(i).getStudent_id()==id && !assessments.get(i).getgraded()&&assessments.get(i).getSolution()!=null){
                System.out.println("submission: "+assessments.get(i).getSolution()+"\n-----------------");
            }
        }
        System.out.println("Graded submissions:");
        for(int i = 0;i< assessments.size();i++){
            if(assessments.get(i).getStudent_id()==id && assessments.get(i).getgraded()){
                System.out.println("submission: "+assessments.get(i).getSolution()+"\n-----------------");
                System.out.println("Marks scored: "+assessments.get(i).getMarksobtained());
                System.out.println("Graded by: I"+assessments.get(i).getInstructor_id());
            }
        }

    }

}

