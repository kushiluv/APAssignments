public class comments {
    private java.util.Date date;
    private int id;
    private String comment;


    public comments(int id, String comment){
        date = new java.util.Date();
        this.id = id;
        this.comment = comment;
    }
    public String getComment(){
        return comment;
    }
    public int getId(){
        return id;
    }
    public java.util.Date getDate(){
        return date;
    }
}
