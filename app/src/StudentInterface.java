abstract public class StudentInterface extends Person {
    StudentInterface(String email, String password, String name) {
        super(email,password,name);
    }

    StudentInterface()
    {
        super();
    }
    abstract protected void setGrade(String grade);
    abstract protected void viewCourses();
    abstract protected void submitProject(String subject,int projectNum, String ans);
    abstract protected void getFeedback(String subject,int projectNum);
    abstract protected void getTasks();



}
