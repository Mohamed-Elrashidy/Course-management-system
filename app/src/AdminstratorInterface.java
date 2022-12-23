public abstract class AdminstratorInterface extends Person {
    abstract public void createAccount(Adminstrator adminstrator);
    abstract public void createCurriculum(String grade ,String subjectName,String subjectCode);
    abstract public void assignClassses(String grade,String subject,String instructorEmail);


}
