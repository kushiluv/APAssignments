import java.util.ArrayList;
import java.util.Scanner;
public class student {
    public static final Scanner scan = new Scanner(System.in);
    private int id;
    private ArrayList<assignments> assignments = instructor.getAssignments();
    public student(int id) {
        this.id = id;
    }

    public void submit_assignments(){
        System.out.println("Pending Assignments");
        for(int i = 0 ; i< assignments.size();i++){
            if(!assignments.get(i).getclosed()&&!assignments.get(i).getsubmitted()){
                System.out.println("ID: " + assignments.get(i).getId() + " Assignment: " + assignments.get(i).getQuestion() + " Max Marks: " + assignments.get(i).getMarks());
            }
        }
        System.out.println("Enter ID of assessment: ");
        int tempid = scan.nextInt();
        for(int i = 0 ; i<assignments.size();i++){
            if(tempid==assignments.get(i).getId()){
                if(assignments.get(i).getType().equals("assignment")){
                    System.out.println("Enter filename of assignment:");
                    String file = scan.next();
                    if(!file.substring(file.length()-4).equals(".zip")){
                        System.out.println("file is of unsupported type");
                        return;
                    }
                    else{
                        assignments.get(i).setSolution(file);
                    }
                }
                else{
                    System.out.println(assignments.get(i).getQuestion());
                    scan.nextLine();
                    String ans = scan.nextLine();
                    assignments.get(i).setSolution(ans);

                }

            }
        }

        for(int i = 0 ; i<assignments.size();i++){
            if(assignments.get(i).getId()==tempid){
                assignments.get(i).setSubmittedtrue();
                assignments.get(i).setStudent_id(id);
            }
        }

    }

}

