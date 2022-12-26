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
    abstract protected void createAccount(Adminstrator adminstrator);
    abstract protected void createCurriculum(String grade ,String subjectName,String subjectCode);
    abstract protected void assignClassses(String grade,String subject,String instructorEmail);


}
