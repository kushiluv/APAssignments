public class assignment implements assessment{
    private int id;
    private String question;
    private final int marks;
    private int marksobtained;
    private boolean closed=false;
    private boolean graded=false;
    private boolean submitted=false;
    private int instructor_id;
    private int student_id=-1;
    private String solution;
    private int uploadid;
    private String type = "assignment";

    public assignment(String question , int marks,int uploadid,int id){
        this.question = question;
        this.marks = marks;
        this.id = id;
        this.uploadid = uploadid;
    }
    @Override
    public int getUploadid(){
        return uploadid;
    }
    @Override
    public String getType(){
        return type;
    }
    @Override
    public int getInstructor_id(){
        return instructor_id;
    }
    @Override
    public void setStudent_id(int sid){
        student_id=sid;
    }
    @Override
    public void setSolution(String sol){
        solution=sol;
    }
    @Override
    public String getSolution(){
        return solution;
    }
    @Override
    public void setInstructor_id(int iid){
        instructor_id=iid;
    }
    @Override
    public int getId(){
        return id;
    }
    @Override
    public int getStudent_id(){
        return student_id;
    }

    @Override
    public String getQuestion(){
        return question;
    }
    @Override
    public int getMarks(){
        return marks;
    }
    @Override
    public boolean getclosed(){
        return closed;
    }
    @Override
    public boolean getsubmitted(){
        return submitted;
    }
    @Override
    public boolean getgraded(){
        return graded;
    }
    @Override
    public void setMarksobtained(int marksobtained){
        this.marksobtained = marksobtained;
    }
    @Override
    public int getMarksobtained(){
        return this.marksobtained ;
    }
    @Override
    public void setclosedtrue(){
        closed = true;
    }
    @Override
    public void setgradedtrue(){
        graded = true;
    }
    @Override
    public void setSubmittedtrue(){
        submitted = true;
    }
}
