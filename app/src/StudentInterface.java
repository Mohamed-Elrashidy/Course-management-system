abstract public class StudentInterface extends Person {
    abstract public void viewCourses();
    abstract public void submitProject(String subject,int projectNum, String ans);
    abstract public void getFeedback(String subject,int projectNum);
}
