import java.util.ArrayList;
import java.util.Scanner;
public class student implements interface1{
    public static final Scanner scan = new Scanner(System.in);
    private int id;
    private ArrayList<assessment> assessments = instructor.getAssessments();
    private ArrayList<material> materials = instructor.getMaterials();
    public student(int id) {
        this.id = id;
    }
    public void display() {
        System.out.println("Welcome S" + id);
    }

    public int getId(){
        return id;
    }
    @Override
    public void getmenu(){
        System.out.println("STUDENT MENU\n" +
                "1. View lecture materials\n" +
                "2. View assessments\n" +
                "3. Submit assessment\n" +
                "4. View grades\n" +
                "5. View comments\n" +
                "6. Add comments\n" +
                "7. Logout");
    }
    public void submit_assessments(){
        System.out.println("Pending assessments");
        int flag = 0;
        for(int i = 0 ; i< assessments.size();i++){
            if(!assessments.get(i).getclosed() && assessments.get(i).getsubmitted()==false &&assessments.get(i).getStudent_id()==id){

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
            if(tempid==assessments.get(i).getId()&&assessments.get(i).getStudent_id()==id){
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
                    assessments.get(i).setSubmittedtrue();

                }

            }
        }

//        for(int i = 0 ; i<assessments.size();i++){
//            if(assessments.get(i).getId()==tempid){
//                assessments.get(i).setSubmittedtrue();
//                assessments.get(i).setStudent_id(id);
//            }
//        }

    }
    @Override
    public void viewmaterials() {
        for (int i = 0; i < materials.size(); i++) {
            materials.get(i).display();
            System.out.println("Uploaded by: I" + materials.get(i).getUploadid());
        }
    }
    @Override
    public void viewassessments() {
        for (int i = 0; i < assessments.size(); i++) {
            if(i!=0) {
                if (assessments.get(i).getId() == assessments.get(i - 1).getId()) {
                    continue;
                }
            }
            if(assessments.get(i).getType().equals("assignment")){

                System.out.println("ID: " + assessments.get(i).getId() + " Assignment: " + assessments.get(i).getQuestion() + " Max Marks: " + assessments.get(i).getMarks() +
                        "\n----------------");}
            else{
                System.out.println("ID: " + assessments.get(i).getId() + " Question: " + assessments.get(i).getQuestion() +
                        "\n----------------");
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
                System.out.println("submission: "+assessments.get(i).getSolution());
                System.out.println("Marks scored: "+assessments.get(i).getMarksobtained());
                System.out.println("Graded by: I"+assessments.get(i).getInstructor_id()+"\n-----------------");
            }
        }

    }
    @Override
    public void addcomment(ArrayList<comments> comments){
        System.out.println("Enter comment: ");
        Scanner scantext = new Scanner(System.in);
        String comment = scantext.nextLine();
        comments.add(new comments(id,comment,"student"));
    }
    @Override
    public void viewcomment(ArrayList<comments> comments){
        for(int i=0;i< comments.size();i++){
            if(comments.get(i).getType()=="instructor"){
                System.out.println(comments.get(i).getComment()+" I"+comments.get(i).getId());
                System.out.println(comments.get(i).getDate()+"\n");
            }
            else if(comments.get(i).getType()=="student"){
                System.out.println(comments.get(i).getComment()+" S"+comments.get(i).getId());
                System.out.println(comments.get(i).getDate()+"\n");
            }
        }
    }

}

