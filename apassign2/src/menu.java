import java.util.ArrayList;
import java.util.Scanner;

public class menu {
    public static final Scanner scan = new Scanner(System.in);
    static int instructid;
    static ArrayList<instructor> instructors = new ArrayList<instructor>();
    static ArrayList<material> materials = new ArrayList<material>();
    public static void add_instructors(){
        instructor i0 = new instructor(0);
        instructors.add(i0);
        instructor i1 = new instructor(1);
        instructors.add(i1);
        System.out.println("Instructors:");
        for(int i = 0 ;i<instructors.size();i++){
            System.out.println(i+" - I"+i);
        }
        System.out.println("Choose id: ");
        instructid = scan.nextInt();
        instructors.get(instructid).display();
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
                        instructors.get(instructid).viewmaterials();
                    }
                }
            }
            else if(mainmenu==2){
                while(true){
                    menu.student_menu();
                    studentmenu = scan.nextInt();
                    if(studentmenu==7){
                        break;
                    }
                }
            }
            else{
                break;
            }


        }
    }
}
