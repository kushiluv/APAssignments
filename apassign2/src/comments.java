public class comments {
    private java.util.Date date;
    private int id;
    private String comment;
    private String type;


    public comments(int id, String comment,String type){
        date = new java.util.Date();
        this.id = id;
        this.comment = comment;
        this.type = type;
    }
    public String getComment(){
        return comment;
    }
    public String getType(){
        return type;
    }
    public int getId(){
        return id;
    }
    public java.util.Date getDate(){
        return date;
    }
}
