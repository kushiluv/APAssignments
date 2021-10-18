import java.util.ArrayList;
import java.util.Scanner;

public class menu {
    public static final Scanner scan = new Scanner(System.in);
    static int instructid;
    static int stuid;
    static ArrayList<instructor> instructors = new ArrayList<instructor>();
    static ArrayList<student> students = new ArrayList<student>();

    public static void initialize_instructors(){
        instructor i0 = new instructor(0);
        instructors.add(i0);
        instructor i1 = new instructor(1);
        instructors.add(i1);}
    public static void add_instructors(){
        System.out.println("Instructors:");
        for(int i = 0 ;i<instructors.size();i++){
            System.out.println(i+" - I"+i);
        }
        System.out.println("Choose id: ");
        instructid = scan.nextInt();
        instructors.get(instructid).display();
    }
    public static void initialize_students(){
        student s0 = new student(0);
        students.add(s0);
        student s1 = new student(1);
        students.add(s1);
        student s2 = new student(2);
        students.add(s2);}
    public static void add_students(){
        System.out.println("Students:");
        for(int i = 0 ;i<students.size();i++){
            System.out.println(i+" - S"+i);
        }
        System.out.println("Choose id: ");
        stuid = scan.nextInt();
        students.get(stuid).display();
    }

    public static void display_menu(){
        System.out.println("Welcome to Backpack\n" +
                "1. Enter as instructor\n" +
                "2. Enter as student\n" +
                "3. Exit");

    }
    public static void instructor_menu(){
        System.out.println("INSTRUCTOR MENU\n" +
                "1. Add class material\n" +
                "2. Add assessments\n" +
                "3. View lecture materials\n" +
                "4. View assessments\n" +
                "5. Grade assessments\n" +
                "6. Close assessment\n" +
                "7. View comments\n" +
                "8. Add comments\n" +
                "9. Logout");
    }
    public static void student_menu(){
        System.out.println("STUDENT MENU\n" +
                "1. View lecture materials\n" +
                "2. View assessments\n" +
                "3. Submit assessment\n" +
                "4. View grades\n" +
                "5. View comments\n" +
                "6. Add comments\n" +
                "7. Logout");
    }
    public static void instructorprofile(){

    }
    public static void add_class_material(){


    }
    public static void main (String[] args) {
        int mainmenu;
        int instructormenu;
        int studentmenu;
        menu.initialize_students();
        menu.initialize_instructors();
        while(true){
            menu.display_menu();
            mainmenu = scan.nextInt();
            if(mainmenu==1){
                menu.add_instructors();
                while(true){
                    menu.instructor_menu();
                    instructormenu = scan.nextInt();
                    if(instructormenu==9){
                        break;
                    }
                    else if(instructormenu==1){
                        instructors.get(instructid).addmaterial();
                    }
                    else if(instructormenu==2){
                        instructors.get(instructid).addassignments();
                    }
                    else if(instructormenu==3){
                        instructors.get(instructid).viewmaterials();
                    }
                    else if(instructormenu==4){
                        instructors.get(instructid).viewassessments();
                    }
                    else if(instructormenu==5){
                        instructors.get(instructid).gradeassignments();
                    }
                    else if(instructormenu==6){
                        instructors.get(instructid).closeassignment();
                    }
                }
            }
            else if(mainmenu==2){
                menu.add_students();
                while(true){
                    menu.student_menu();
                    studentmenu = scan.nextInt();
                    if(studentmenu==7){
                        break;
                    }
                    else if(studentmenu==1){
                        instructors.get(0).viewmaterials();
                    }
                    else if(studentmenu==2){
                        instructors.get(0).viewassessments();
                    }
                    else if(studentmenu==3){
                        students.get(stuid).submit_assessments();
                    }
                    else if(studentmenu==4){
                        students.get(stuid).view_grades();
                    }

                }
            }
            else{
                break;
            }


        }
    }
}
