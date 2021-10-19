package com.company;

import java.util.Scanner;

public class Main {
    public static final Scanner scan = new Scanner(System.in);

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
        public int getDoses_gap() {

            return doses_gap;
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

        public int getUniqueid() {

            return uniqueid;
        }

        public void display(){
            System.out.println("Hospital Name: "+name+", Pincode: "+pincode+", Unique ID: "+uniqueid);
        }

    }
    public static class  citizen {
        private String name;
        private int age;
        private long uniqueid;
        private String status;
        private String vac_name;
        private int gap;
        private int dayoflastvaccine;
        private int doses_no=0;
        private int doses_total;

        public citizen(String name, int age, long uniqueid,String status) {
            this.name = name;
            this.status = status;
            this.age = age;
            this.uniqueid = uniqueid;
        }
        public void setStatus(String status){
            this.status = status;
        }
        public int getDayoflastvaccine(){
            return dayoflastvaccine;
        }
        public String getVac_name(){
            return vac_name;
        }
        public int getGap(){
            return gap;
        }
        public String getStatus(){
            return this.status;
        }
        public void setVac_name(String vac_name){
            this.vac_name = vac_name;
        }
        public void setGap(int gap){
            this.gap = gap;
        }
        public void setDoses_total(int doses_total){
            this.doses_total = doses_total;
        }
        public void increasedoses(){
            this.doses_no+=1;
        }
        public void setDayoflastvaccine(int dayoflastvaccine){
            this.dayoflastvaccine = dayoflastvaccine;
        }

        public String getName() {

            return name;
        }

        public int getAge() {

            return age;
        }
        public int getDoses_no() {

            return doses_no;
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
        private int slot_num;
        private int day;
        private int quantity;
        private int vac_no;
        private String vac_name;
        public slots(int hid, int slot_num,int day,int quantity,int vac_no,String vac_name){
            this.hid = hid;
            this.slot_num = slot_num;
            this.day = day ;
            this.quantity=quantity;
            this.vac_no=vac_no;
            this.vac_name=vac_name;
        }

        public int getHid() {
            return hid;
        }

        public String getVac_name() {
            return vac_name;
        }

        public int getSlot_num() {
            return slot_num;
        }

        public int getDay() {
            return day;
        }

        public int getQuantity() {
            return quantity;
        }

        public int getVac_no() {
            return vac_no;
        }

        public void DecreaseQuantity(){
            quantity=quantity-1;
        }

        public void display(){
            System.out.println("Slot added by hospital "+hid+" for Day "+day+", Available quantity:"+quantity+" of Vaccine "+Menu.vac[vac_no].getName());
        }
        public static void hospital_display(int Hospid){
            int flag=0;
            for(int p = 0;p<Menu.j;p++){
                if(Hospid==Menu.hos[p].getUniqueid()){
                    flag=1;
                    break;
                }

            }
            if(flag==0){
                System.out.println("Enter valid id");
                return;
            }


            for(int i = 0;i<Menu.l;i++){
                if(Menu.slots[i].getHid()==Hospid){
                    System.out.println("Day: "+Menu.slots[i].getDay()+" Vaccine: "+Menu.slots[i].getVac_name()+" Available Qty: "+Menu.slots[i].getQuantity());
                }
            }
        }
    }
    public class Menu {
        static vaccine[] vac = new vaccine[10000];
        static citizen[] zen = new citizen[10000];
        static hospital[] hos = new hospital[10000];
        static slots[] slots = new slots[10000];
        static int i = 0, j = 0, k = 0, l = 0, huniqueid = 100001;


        public static void display_menu() {
            System.out.println("---------------------------------\n1. Add Vaccine\n2. Register Hospital\n3. Register Citizen\n" +
                    "4. Add Slot for Vaccination\n" +
                    "5. Book Slot for Vaccination\n" +
                    "6. List all slots for a hospital\n" +
                    "7. Check Vaccination Status\n" +
                    "8. Exit\n" +
                    "---------------------------------");
        }

        public static void vaccineadd_menu() {
            String vname;
            int num, gap = 0;
            System.out.println("Vaccine name: ");
            vname = scan.next();
            System.out.println("Number of Doses: ");
            num = scan.nextInt();
            if (num > 1) {
                System.out.println("Gap between Doses: ");
                gap = scan.nextInt();
            }
            vac[i] = new vaccine(vname, num, gap);
            vac[i].display();
            i++;
        }

        public static void hospitaladd_menu() {
            String hname;
            int pincode;
            System.out.println("Hospital name: ");
            hname = scan.next();
            System.out.println("Pincode: ");
            pincode = scan.nextInt();
            hos[j] = new hospital(hname, pincode, huniqueid++);
            hos[j].display();
            j++;
        }

        public static void citizenadd_menu() {
            String cname;
            long cuniqueid;
            int age;
            System.out.println("Citizen name: ");
            cname = scan.next();
            System.out.println("age: ");
            age = scan.nextInt();
            System.out.println("Unique ID: ");
            cuniqueid = scan.nextLong();

            for(int p=0;p<k;p++){
                {
                    if(zen[p].getUniqueid()==cuniqueid) {
                        System.out.println("ID not unique: " + zen[p].getUniqueid());
                        return;
                    }
                }
            }
            if (age >= 18) {
                zen[k] = new citizen(cname, age, cuniqueid, "REGISTERED");
                zen[k].display();
                k++;
            } else {
                System.out.println("Only above 18 are allowed");
            }
        }

        public static void createslots_menu() {
            int hid, quantity, day, vac_no, num_slots, temp = 0;
            String vname;
            System.out.println("Enter Hospital ID: ");
            hid = scan.nextInt();
            int flag=0;
            for(int p = 0;p<j;p++){
                if(hid==hos[p].getUniqueid()){
                    flag=1;
                    break;
                }

            }
            if(flag==0){
                System.out.println("Enter valid id");
                return;
            }
            System.out.println("Enter number of Slots to be added: ");
            num_slots = scan.nextInt();
            while (num_slots != 0) {
                System.out.println("Enter Day number: ");
                day = scan.nextInt();
                System.out.println("Enter Quantity: ");
                quantity = scan.nextInt();
                System.out.println("Select Vaccine");
                for (int m = 0; m < i; m++) {
                    System.out.println(m + ". " + vac[m].getName());
                }
                vac_no = scan.nextInt();
                slots[l] = new slots(hid, temp, day, quantity, vac_no, vac[vac_no].getName());
                slots[l].display();
                l++;
                temp++;
                num_slots--;

            }
        }

        public static void bookaslot() {
            long temp;
            int f = 0;
            int temp1, temp3, hopid=0,duedate;
            String temp2;
            int pincode;
            int cday = -1;
            String vname = "doesntexist";
            System.out.println("Enter patient Unique ID: ");
            temp = scan.nextLong();
            int flag=0;
            for(int p = 0;p<k;p++){
                if(temp==zen[p].getUniqueid()){
                    flag=1;
                    break;
                }

            }
            if(flag==0){
                System.out.println("Enter valid id");
                return;
            }
            System.out.println("1. Search by area\n" +
                    "2. Search by Vaccine\n" +
                    "3. Exit\n" +
                    "Enter option: ");
            temp1 = scan.nextInt();
            int flag2=0;
            if (temp1 == 1) {
                System.out.println("Enter PinCode: ");
                pincode = scan.nextInt();
                for (int p = 0; p < Menu.j; p++) {
                    if (pincode == Menu.hos[p].getPincode()) {
                        flag2=1;
                        System.out.println(Menu.hos[p].getUniqueid() + " " + Menu.hos[p].getName());
                    }
                }
                if(flag2==0){
                    System.out.println("No hospitals in this pincode");
                    return;
                }
                System.out.println("Enter hospital id: ");
                hopid = scan.nextInt();
                for (int p = 0; p < l; p++) {
                    if (hopid == Menu.slots[p].getHid()) {
                        for (int o = 0; o < k; o++) {
                            if (temp == Menu.zen[o].getUniqueid()) {
                                if (zen[o].getStatus().equals("REGISTERED")&&Menu.slots[p].getQuantity()!=0) {
                                    f=1;
                                    System.out.println(Menu.slots[p].getSlot_num() + "-> Day: " + Menu.slots[p].getDay() + " Available Qty:" + Menu.slots[p].getQuantity() + " Vaccine:" + Menu.slots[p].getVac_name());
                                }
                                else if (zen[o].getStatus().equals("PARTIALLY VACCINATED")&&zen[o].getVac_name().equals(Menu.slots[p].getVac_name())){
                                    duedate = zen[o].getDayoflastvaccine()+zen[o].getGap();
                                    if(slots[p].getDay()>=duedate){
                                        f=1;
                                        System.out.println(Menu.slots[p].getSlot_num() + "-> Day: " + Menu.slots[p].getDay() + " Available Qty:" + Menu.slots[p].getQuantity() + " Vaccine:" + Menu.slots[p].getVac_name());
                                    }

                                }
                                else if(zen[o].getStatus().equals("FULLY VACCINATED")){
                                    System.out.println("Already Fully vaccinated");
                                    return;
                                }

                            }
                        }
                    }
                }
                if(f==0){
                    System.out.println("No slots available");
                    return;
                }
            }
            else if (temp1 == 2) {
                System.out.println("Enter vaccine name:");
                temp2 = scan.next();
                for (int p = 0; p < j; p++) {
                    for (int o = 0; o < l; o++) {
                        if (Menu.slots[o].getVac_name().equals(temp2) && slots[o].getHid() == hos[p].getUniqueid()) {
                            System.out.println(Menu.hos[p].getUniqueid() + " " + Menu.hos[p].getName());
                            break;
                        }
                    }

                }
                System.out.println("Enter hospital id: ");
                hopid = scan.nextInt();

                for (int p = 0; p < l; p++) {
                    if (hopid == Menu.slots[p].getHid() && temp2.equals(slots[p].getVac_name())) {
                        for (int o = 0; o < k; o++) {
                            if (temp == Menu.zen[o].getUniqueid()) {
                                if (zen[o].getStatus().equals("REGISTERED")&&Menu.slots[p].getQuantity()!=0) {
                                    f=1;
                                    System.out.println(Menu.slots[p].getSlot_num() + "-> Day: " + Menu.slots[p].getDay() + " Available Qty:" + Menu.slots[p].getQuantity() + " Vaccine:" + Menu.slots[p].getVac_name());
                                }
                                else if (zen[o].getStatus().equals("PARTIALLY VACCINATED")&&zen[o].getVac_name().equals(Menu.slots[p].getVac_name())){
                                    duedate = zen[o].getDayoflastvaccine()+zen[o].getGap();
                                    if(slots[p].getDay()>=duedate){
                                        f=1;
                                        System.out.println(Menu.slots[p].getSlot_num() + "-> Day: " + Menu.slots[p].getDay() + " Available Qty:" + Menu.slots[p].getQuantity() + " Vaccine:" + Menu.slots[p].getVac_name());
                                    }

                                }
                                else if(zen[o].getStatus().equals("FULLY VACCINATED")){
                                    System.out.println("Already Fully vaccinated");
                                    return;
                                }

                            }
                        }
                    }
                }
                if(f==0){
                    System.out.println("No slots available");
                    return;
                }
            }


            else if(temp1==3){
                return;
            }

            System.out.println("Choose Slot");
            temp3 = scan.nextInt();
            for (int p = 0; p < l; p++) {
                if (hopid == Menu.slots[p].getHid() && temp3 == Menu.slots[p].getSlot_num()) {
                    if(Menu.slots[p].getQuantity()==0){
                        System.out.println("Not enough quantity");
                        return;
                    }
                    Menu.slots[p].DecreaseQuantity();
                    vname = Menu.slots[p].getVac_name();
                    cday = Menu.slots[p].getDay();
                }
            }

            for (int p = 0; p < k; p++) {
                if (temp == Menu.zen[p].getUniqueid()) {
                    if (zen[p].getStatus().equals("REGISTERED")) {
                        zen[p].setVac_name(vname);
                        for (int o = 0; o < i; o++) {
                            if (vname.equals(vac[o].getName())) {
                                zen[p].setGap(vac[o].getDoses_gap());
                                zen[p].setDoses_total(vac[o].getDoses_num());
                                zen[p].setVac_name(vname);
                                zen[p].setDayoflastvaccine(cday);
                                zen[p].increasedoses();
                                System.out.println(zen[p].getName() + " vaccinated with " + vname);
                                if (vac[o].getDoses_num() == 1) {
                                    zen[p].setStatus("FULLY VACCINATED");
                                } else {
                                    zen[p].setStatus("PARTIALLY VACCINATED");
                                }
                            }
                        }
                    }
                    else if (zen[p].getStatus().equals("PARTIALLY VACCINATED")) {
                        if(!zen[p].getVac_name().equals(vname)){
                            System.out.println("vaccine needed: "+zen[p].getVac_name());
                            System.out.println("Vaccine selected"+ vname);
                            System.out.println("vaccine cant be mixed");
                            break;
                        }
                        duedate = zen[p].getDayoflastvaccine()+zen[p].getGap();
                        if(cday<duedate){
                            System.out.println("cday:"+cday);
                            System.out.println("due: "+ duedate);
                            break;
                        }
                        zen[p].setDayoflastvaccine(cday);
                        zen[p].increasedoses();

                        if(zen[p].doses_no==zen[p].doses_total){
                            zen[p].setStatus("FULLY VACCINATED");
                        }

                        System.out.println(zen[p].getName() + " vaccinated with " + vname);


                    }
                    else{
                        System.out.println("already FULLY VACCINATED");
                    }

                }

            }
        }
        public static void checkstatus(){
            long temp;
            System.out.println("Enter unique ID");
            temp = scan.nextLong();
            int flag=0;
            for(int p = 0;p<k;p++){
                if(temp==zen[p].getUniqueid()){
                    flag=1;
                    break;
                }

            }
            if(flag==0){
                System.out.println("Enter valid id");
                return;
            }
            for(int j = 0; j<k;j++){
                if(temp == zen[j].getUniqueid()){
                    if(zen[j].getStatus().equals("REGISTERED")){
                        System.out.println("CITIZEN REGISTERED");
                    }
                    else if(zen[j].getStatus().equals("PARTIALLY VACCINATED")){
                        System.out.println("PARTIALLY VACCINATED");
                        System.out.println("Vaccine Given: "+zen[j].getVac_name());
                        System.out.println("Number of doses given:"+zen[j].getDoses_no());
                        int tempd = zen[j].getDayoflastvaccine()+zen[j].getGap();
                        System.out.println("Next dose due date: "+tempd);
                    }
                    else{
                        System.out.println("FULLY VACCINATED");
                        System.out.println("Vaccine Given: "+zen[j].getVac_name());
                        System.out.println("Number of doses given:"+zen[j].getDoses_no());
                    }
                }
            }

        }
    }

    public static void main (String[] args) {
        int index;
        System.out.println("CoWin Portal initialized....");
        while (true) {


            Menu.display_menu();
            index = scan.nextInt();
            if (index==1){
                Menu.vaccineadd_menu();
            }
            else if(index==2){
                Menu.hospitaladd_menu();
            }
            else if(index==3){
                Menu.citizenadd_menu();
            }
            else if(index==5){
                Menu.bookaslot();
            }
            else if(index==4){
                Menu.createslots_menu();
            }
            else if(index==6){
                int temp;
                System.out.println("Enter Hospital Id:");
                temp = scan.nextInt();
                slots.hospital_display(temp);
            }
            else if(index==7){
                Menu.checkstatus();
            }
            else if(index==8){
                break;
            }

        }
    }
}
