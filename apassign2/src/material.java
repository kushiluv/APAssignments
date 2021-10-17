import java.util.ArrayList;

public class material {
    private String topic;
    private ArrayList<String> content = new ArrayList<String>();
    private String filename;
    private String type;
    private java.util.Date date;

    public material(String topic, ArrayList<String> content) {
        this.content = content;
        this.topic = topic;
        this.type = "slide";
        date = new java.util.Date();
    }

    public material(String topic, String filename) {
        this.topic = topic;
        this.filename = filename;
        this.type = "video";
        date = new java.util.Date();
    }

    public void display() {
        if (type.equals("slide")) {
            System.out.println("Title: " + topic);
            for (int i = 1; i <= content.size(); i++) {
                System.out.println("Slide "+i+": " + content.get(i-1));
            }
            System.out.println("Number of slides: " + content.size());
            System.out.println("Date of upload: " + date);


        }
        else if(this.type.equals("video")){
            System.out.println("\nTitle: " + topic);
            System.out.println("Video file: "+filename);
            System.out.println("Date of upload: " + date);
        }

    }
}
