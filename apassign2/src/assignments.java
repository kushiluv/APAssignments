public class assignments {
    private static int count = 0;
    private int id=0;
    private String question;
    private int marks;
    private int marksobtained;
    public boolean assign=false;

    public assignments(String question , int marks){
        this.question = question;
        this.marks = marks;
        id = count;
        count++;
    }
    public assignments(String question){
        this.question = question;
        id = count;
        count++;
    }
    public int getId(){
        return id;
    }
    public String getQuestion(){
        return question;
    }
    public int getMarks(){
        return marks;
    }
    public void setMarksobtained(int marksobtained){
        this.marksobtained = marksobtained;
    }
    public void setassigntrue(){
        assign = true;
    }
}
