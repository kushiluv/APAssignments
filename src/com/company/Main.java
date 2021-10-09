package com.company;


import java.util.Scanner;

public class Main {
    public static class vaccine {
        private String name;
        private int doses_num;
        private int doses_gap;

        public vaccine(String name, int doses_num,int doses_gap){
            this.name = name;
            this.doses_num = doses_num;
            this.doses_gap = doses_gap;
        }
        public String getName() {

            return name;
        }
        public int getDoses_num() {

            return doses_num;
        }
        public void display(){
            System.out.println("Vaccine Name: "+name+", Number of Doses: "+doses_num+", Gap Between Doses: "+doses_gap);
        }

    }
    public static class  hospital {
        private String name;
        private int pincode;
        private int uniqueid;

        public hospital(String name, int pincode,int uniqueid) {
            this.name = name;
            this.pincode = pincode;
            this.uniqueid=uniqueid;
        }

        public String getName() {
            return name;
        }

        public int getPincode() {
            return pincode;
        }

        public void display(){
            System.out.println("Hospital Name: "+name+", Pincode: "+pincode+", Unique ID: "+uniqueid);
        }
    }
    public static class  citizen {
        private String name;
        private int age;
        private long uniqueid;

        public citizen(String name, int age, long uniqueid) {
            this.name = name;
            this.age = age;
            this.uniqueid = uniqueid;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public long getUniqueid() {
            return uniqueid;
        }
        public void display(){
            System.out.println("Citizen Name: "+name+", Age: "+age+", Unique ID: "+uniqueid);
        }
    }
    public static class  slots {
        private int hid;
        private int num_slots;
        private int day;
        private int quantity;
        private int vac_no;
        public slots(int hid, int num_slots,int day,int quantity,int vac_no){
            this.hid = hid;
            this.num_slots = num_slots;
            this.day = day ;
            this.quantity=quantity;
            this.vac_no=vac_no;
        }

        public int getHid() {
            return hid;
        }

        public int getDay() {
            return day;
        }

        public int getQuantity() {
            return quantity;
        }

        public void display(){
            System.out.println("Slot added by hospital "+hid+" for Day "+day+", Available quantity:"+quantity+" of Vaccine "+Main.vac[vac_no].getName());
        }
        public void hospital_display(int Hospid){

            for(int i = 0;i<Main.l;i++){
                if(Main.slots[i].getHid()==Hospid){
                    System.out.println("Day: "+Main.slots[i].getDay()+" Vaccine: "+Main.vac[i].getName()+"Available Qty: "+Main.slots[i].getQuantity());
                }
            }
        }
    }
    static vaccine[] vac = new vaccine[1000];
    static citizen[] zen=new citizen[1000];
    static hospital[] hos = new hospital[1000];
    static slots[] slots = new slots[1000];
    static int i=0,j=0,k=0,l=0,huniqueid=100001;
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
    public static void createslots_menu(){
        int hid,quantity,day,vac_no,num_slots;
        System.out.println("Enter Hospital ID: ");
        hid = scan.nextInt();
        System.out.println("Enter number of Slots to be added: ");
        num_slots= scan.nextInt();
        System.out.println("Enter Day number: ");
        day = scan.nextInt();
        System.out.println("Enter Quantity: ");
        quantity= scan.nextInt();
        System.out.println("Select Vaccine");
        for(int m =0;m<vac.length;m++){
            System.out.println(m+". "+vac[m].getName());
        }
        vac_no= scan.nextInt();
        slots[l] = new slots(hid,num_slots,day,quantity,vac_no);
        l++;
        slots[l].display();
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
            else if(index==4){
                createslots_menu();
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
