import java.util.ArrayList;

public class material {
    private String topic;
    private ArrayList<String> content = new ArrayList<String>();
    private String filename;

    public material(String topic , ArrayList<String> content){
        this.content = content;
        this.topic = topic;
    }
    public material(String topic, String filename){
        this.topic = topic;
        this.filename = filename;
    }

}
