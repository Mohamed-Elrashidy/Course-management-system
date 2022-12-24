public abstract class AdminstratorInterface extends Person {
    AdminstratorInterface(String email, String password, String name) {
        super(email,password,name);
    }
    AdminstratorInterface()
    {
        super();
    }
    AdminstratorInterface(int state)
    {
        super(state);
    }
    abstract public void createAccount(Adminstrator adminstrator);
    abstract public void createCurriculum(String grade ,String subjectName,String subjectCode);
    abstract public void assignClassses(String grade,String subject,String instructorEmail);


}
