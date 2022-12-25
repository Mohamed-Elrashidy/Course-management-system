abstract public class StudentInterface extends Person {
    StudentInterface(String email, String password, String name) {
        super(email,password,name);
    }

    StudentInterface()
    {
        super();
    }
    StudentInterface(int state)
    {
        super(state);
    }

    abstract protected void setGrade(String grade);
    abstract public void viewCourses();
    abstract public void submitProject(String subject,int projectNum, String ans);
    abstract public void getFeedback(String subject,int projectNum);
    abstract public void getTasks();



}
