public interface assessment {
    public int getUploadid();
    public int getInstructor_id();
    public void setStudent_id(int sid);
    public void setSolution(String sol);
    public String getSolution();
    public void setInstructor_id(int iid);
    public int getId();
    public int getStudent_id();
    public String getQuestion();
    public int getMarks();
    public String getType();
    public boolean getclosed();
    public boolean getsubmitted();
    public boolean getgraded();
    public void setMarksobtained(int marksobtained);
    public int getMarksobtained();
    public void setclosedtrue();
    public void setgradedtrue();
    public void setSubmittedtrue();
}
