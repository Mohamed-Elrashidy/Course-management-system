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
    abstract public void submittedProjects(String grade);
    abstract public void setFeedback(String feedback,int taskNumber,String studentEmail);
    abstract public void createTask(String grade ,int taskNumber,String task);


}
