import java.util.ArrayList;
import java.util.Scanner;

public class instructor {
    public static final Scanner scan = new Scanner(System.in);
    private int id;
    private static ArrayList<material> materials = new ArrayList<material>();
    private static ArrayList<assignments> assignments = new ArrayList<assignments>();

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
            assignments ments = new assignments(question, marks,id);
            assignments.add(ments);

        } else if (temp == 2) {
            System.out.println("Enter quiz question: ");
            scan.nextLine();
            String question = scan.nextLine();
            assignments ments = new assignments(question,id);
            assignments.add(ments);
        }
    }

    public void viewassignments() {
        for (int i = 0; i < assignments.size(); i++) {
            if(assignments.get(i).getType().equals("assignment")){
            System.out.println("ID: " + assignments.get(i).getId() + " Assignment: " + assignments.get(i).getQuestion() + " Max Marks: " + assignments.get(i).getMarks() +
                    "\n----------------");}
            else{
                System.out.println("ID: " + assignments.get(i).getId() + " Question: " + assignments.get(i).getQuestion() +
                        "\n----------------");
            }
        }
    }

    public static ArrayList<assignments> getAssignments() {
        return assignments;
    }

    public void gradeassignments() {
        System.out.print("List of assignments");
        viewassignments();
        System.out.println("Enter id of assignment to view submissions: ");
        int temp = scan.nextInt();
        int count = 0;
        System.out.println("Choose ID from these ungraded submissions");
        for (int i = 0; i < assignments.size(); i++) {
            if (assignments.get(i).getsubmitted()&&assignments.get(i).getId()==temp) {
                System.out.println(count + ". S" + assignments.get(i).getStudent_id());
                count++;
            }
        }
        if(count==0){
            System.out.println("no submissions found");
            return;
        }
        int sid = scan.nextInt();
        System.out.println("Submissions: \n");
        for (int i = 0; i < assignments.size(); i++) {
            if (assignments.get(i).getsubmitted() && assignments.get(i).getStudent_id() == sid) {
                System.out.println("Submission: " + assignments.get(i).getSolution() + "\n------------");
                System.out.println("Max marks : " + assignments.get(i).getMarks());
                System.out.println("Marks scored: " );
                assignments.get(i).setMarksobtained(scan.nextInt());
                assignments.get(i).setInstructor_id(id);
                assignments.get(i).setgradedtrue();
            }
        }


    }

    public void closeassignment() {
        System.out.println("List of open asssignments");
        int flag = 0;
        for (int i = 0; i < assignments.size(); i++) {
            if(assignments.get(i).getType().equals("assignment")){flag++;
                System.out.println("ID: " + assignments.get(i).getId() + " Assignment: " + assignments.get(i).getQuestion() + " Max Marks: " + assignments.get(i).getMarks() +
                        "\n----------------");}
            else{flag++;
                System.out.println("ID: " + assignments.get(i).getId() + " Question: " + assignments.get(i).getQuestion() +
                        "\n----------------");
            }
        }
        if(flag==0){
            System.out.println("no assignments found");
            return;
        }
        int closeid;
        System.out.println("Enter id of assignment to close: ");
        closeid = scan.nextInt();
        for (int i = 0; i < assignments.size(); i++) {
            if (assignments.get(i).getId() == closeid) {
                assignments.get(i).setclosedtrue();
            }

        }
    }
}
