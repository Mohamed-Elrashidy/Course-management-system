abstract public class InstructorInterface extends Person{
    InstructorInterface(String email, String password, String name) {
        super(email,password,name);
    }
    InstructorInterface()
    {
        super();
    }
    InstructorInterface(int state){
        super( state);
    }
    abstract protected void submittedProjects(String grade);
    abstract protected void setFeedback(String feedback,int taskNumber,String studentEmail);
    abstract protected void createTask(String grade ,int taskNumber,String task);
    abstract protected void getClasses();

}
