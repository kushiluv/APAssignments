package com.company;


import java.util.Scanner;

public class Main {
    static vaccine[] vac = new vaccine[1000];
    static citizen[] zen=new citizen[1000];
    static hospital[] hos = new hospital[1000];
    static int i=0,j=0,k=0,huniqueid=100001;
    public static final Scanner scan = new Scanner(System.in);


    public static void display_menu() {
        System.out.println("CoWin Portal initialized....\n---------------------------------\n1. Add Vaccine\n2. Register Hospital\n3. Register Citizen\n" +
                "4. Add Slot for Vaccination\n" +
                "5. Book Slot for Vaccination\n" +
                "6. List all slots for a hospital\n" +
                "7. Check Vaccination Status\n" +
                "8. Exit\n" +
                "---------------------------------");
    }
    public static void vaccineadd_menu(){
        String vname ;
        int num , gap = 0;
        System.out.println("Vaccine name: ");
        vname = scan.next();
        System.out.println("Number of Doses: ");
        num = scan.nextInt();
        if(num>1){
            System.out.println("Gap between Doses: ");
            gap = scan.nextInt();
        }
        vac[i] = new vaccine(vname,num,gap);
        vac[i].display();
        i++;
    }
    public static void hospitaladd_menu(){
        String hname ;
        int pincode ;
        System.out.println("Hospital name: ");
        hname = scan.next();
        System.out.println("Pincode: ");
        pincode = scan.nextInt();
        hos[j] = new hospital(hname,pincode,huniqueid++);
        hos[j].display();
        j++;
    }

    public static void citizenadd_menu() {
        String cname;
        long cuniqueid;int age;
        System.out.println("Citizen name: ");
        cname = scan.next();
        System.out.println("age: ");
        age = scan.nextInt();
        System.out.println("Unique ID: ");
        cuniqueid = scan.nextLong();
        if (age >= 18) {
            zen[k] = new citizen(cname, age, cuniqueid);
            zen[k].display();
            k++;
        } else {
            System.out.println("Only above 18 are allowed");
        }
    }

    public static void main(String[] args) {
        int index;

        while (true) {

            Scanner scan = new Scanner(System.in);
            display_menu();
            index = scan.nextInt();
            if (index==1){
                    vaccineadd_menu();
            }
            else if(index==2){
                hospitaladd_menu();
            }
            else if(index==3){
                citizenadd_menu();
            }
            else{
                break;
            }

//            vaccine[] vac=new vaccine[100];
//            vac[0] = new vaccine("voc", 1);
//            System.out.println(vac[0].getName());




            // write your code here
        }
    }
}
