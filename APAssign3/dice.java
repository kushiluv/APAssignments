import java.util.Random;

public class dice {
    private Random rand = new Random();
    private final int numFaces;
    private int faceValue;
    public dice() {
        numFaces = 2;
        roll();
    }

    public int roll() {
        int curr_faceValue = 1 + rand.nextInt(numFaces);
        setFaceValue(curr_faceValue);
        return faceValue;
    }

    private void setFaceValue(int value) {
        if (value <= numFaces)
            faceValue = value;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public int getNumFaces() {
        return numFaces;
    }

    public String toString() {
        return "number of Faces " + numFaces + "current face value " + faceValue;
    }
}


