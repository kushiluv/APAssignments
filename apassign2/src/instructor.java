import java.util.ArrayList;
import java.util.Scanner;

public class instructor {
    public static final Scanner scan = new Scanner(System.in);
    private int id;
    private static ArrayList<material> materials = new ArrayList<material>();
    private static ArrayList<assessment> assessments = new ArrayList<assessment>();
    private static ArrayList<comments> comments = new ArrayList<comments>();
    private static ArrayList<student> students = menu.students;
    private int assessmentid = 0;

    public instructor(int id) {
        this.id = id;
    }

    public void display() {
        System.out.println("Welcome I" + id);
    }

    public void addmaterial() {
        System.out.println("1. Add Lecture Slide\n" +
                "2. Add Lecture Video");
        int temp = scan.nextInt();
        if (temp == 1) {
            System.out.println("Enter topic of slides");
            scan.nextLine();
            String topic = scan.nextLine();
            System.out.println("Enter number of slides");
            int slides_num = scan.nextInt();
            System.out.println("Enter content of slides");
            ArrayList<String> content = new ArrayList<String>();
            scan.nextLine();
            for (int i = 1; i <= slides_num; i++) {
                System.out.println("Content of slide " + i + " :");
                content.add(scan.nextLine());
            }
            material rial = new material(topic, content,id);
            materials.add(rial);
        } else if (temp == 2) {
            System.out.println("Enter topic of video");
            scan.nextLine();
            String topic = scan.nextLine();
            System.out.println("Enter filename of video");
            String filename = scan.nextLine();
            if(filename.length()<4){
                System.out.println("file is of unsupported type");
                return;
            }
            if(!filename.substring(filename.length()-4).equals(".mp4")){
                System.out.println("file is of unsupported type");
                return;
            }
            material rial = new material(topic, filename,id);
            materials.add(rial);

        } else {
            System.out.println("invalid input");
            return;
        }
    }

    public static ArrayList<material> getMaterials() {
        return materials;
    }
    public static ArrayList<comments> getComments() {
        return comments;
    }


    public void viewmaterials() {
        for (int i = 0; i < materials.size(); i++) {
            materials.get(i).display();
            System.out.println("Uploaded by: I" + materials.get(i).getUploadid());
        }
    }

    public void addassignments() {
        System.out.println("1. Add Assignment\n" +
                "2. Add Quiz");
        int temp = scan.nextInt();
        if (temp == 1) {
            System.out.println("Enter problem statement: ");
            scan.nextLine();
            String question = scan.nextLine();
            ;
            System.out.println("Enter max marks: ");
            int marks = scan.nextInt();
            for(int i =0;i<students.size();i++){
            assessments.add(new assignment(question, marks,id,assessmentid,students.get(i).getId()));}
            assessmentid++;

        } else if (temp == 2) {
            System.out.println("Enter quiz question: ");
            scan.nextLine();
            String question = scan.nextLine();
            for(int i =0;i<students.size();i++){
            assessments.add(new quiz(question,id,assessmentid,students.get(i).getId()));}
            assessmentid++;
        }
    }

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

    public static ArrayList<assessment> getAssessments() {
        return assessments;
    }

    public void gradeassignments() {
        System.out.print("List of assessments");
        System.out.println("");
        viewassessments();
        System.out.println("Enter id of assignment to view submissions: ");
        int temp = scan.nextInt();
        int count = 0;
        System.out.println("Choose ID from these ungraded submissions");
        for (int i = 0; i < assessments.size(); i++) {
            if (assessments.get(i).getId()==temp&&assessments.get(i).getsubmitted()==true) {
                System.out.println(count + ". S" + assessments.get(i).getStudent_id());
                count++;
            }
        }
        if(count==0){
            System.out.println("no submissions found");
            return;
        }
        int sid = scan.nextInt();
        System.out.println("Submissions: \n");
        count=0;
        for (int i = 0; i < assessments.size(); i++) {
            if (assessments.get(i).getId()==temp&&assessments.get(i).getsubmitted()==true) {
                if(count==sid){
                System.out.println("Submission: " + assessments.get(i).getSolution() + "\n------------");
                System.out.println("Max marks : " + assessments.get(i).getMarks());
                System.out.println("Marks scored: " );
                assessments.get(i).setMarksobtained(scan.nextInt());
                assessments.get(i).setInstructor_id(id);
                assessments.get(i).setgradedtrue();
                break;}
            count++;
            }

        }


    }

    public void closeassignment() {
        System.out.println("List of open asssignments");
        int flag = 0;
        for (int i = 0; i < assessments.size(); i++) {
            if(i!=0) {
                if (assessments.get(i).getId() == assessments.get(i - 1).getId()) {
                    continue;
                }
            }
            if(assessments.get(i).getType().equals("assignment")){flag++;
                System.out.println("ID: " + assessments.get(i).getId() + " Assignment: " + assessments.get(i).getQuestion() + " Max Marks: " + assessments.get(i).getMarks() +
                        "\n----------------");}
            else{flag++;
                System.out.println("ID: " + assessments.get(i).getId() + " Question: " + assessments.get(i).getQuestion() +
                        "\n----------------");
            }
        }
        if(flag==0){
            System.out.println("no assessments found");
            return;
        }
        int closeid;
        System.out.println("Enter id of assignment to close: ");
        closeid = scan.nextInt();
        for (int i = 0; i < assessments.size(); i++) {
            if (assessments.get(i).getId() == closeid) {
                assessments.get(i).setclosedtrue();
            }

        }
    }
    public void addcomment(){
        System.out.println("Enter comment: ");
        String comment = scan.nextLine();
        comments.add(new comments(id,comment,"instructor"));
    }
    public void viewcomment(){
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
