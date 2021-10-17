public class assignments {
    private static int count = 0;
    private int id=0;
    private String question;
    private int marks;
    private int marksobtained;
    private boolean closed=false;
    private boolean graded=false;
    private boolean submitted=false;
    private int instructor_id;
    private int student_id;
    private String type;
    private String solution;

    public assignments(String question , int marks){
        this.question = question;
        this.marks = marks;
        id = count;
        type = "assignment";
        count++;
    }
    public assignments(String question){
        this.question = question;
        id = count;
        this.marks = 1;
        type = "quiz";
        count++;
    }
    public int getInstructor_id(){
        return instructor_id;
    }
    public void setStudent_id(int sid){
        student_id=sid;
    }
    public void setSolution(String sol){
        solution=sol;
    }
    public String getSolution(){
        return solution;
    }
    public void setInstructor_id_id(int iid){
        instructor_id=iid;
    }
    public int getId(){
        return id;
    }
    public int getStudent_id(){
        return student_id;
    }

    public String getType(){
        return type;
    }

    public String getQuestion(){
        return question;
    }
    public int getMarks(){
        return marks;
    }
    public boolean getclosed(){
        return closed;
    }
    public boolean getsubmitted(){
        return submitted;
    }
    public boolean getgraded(){
        return graded;
    }
    public void setMarksobtained(int marksobtained){
        this.marksobtained = marksobtained;
    }
    public void setclosedtrue(){
        closed = true;
    }
    public void setgradedtrue(){
        graded = true;
    }
    public void setSubmittedtrue(){
        submitted = true;
    }
}
