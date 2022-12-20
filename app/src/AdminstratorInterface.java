public abstract class AdminstratorInterface extends Person {
    abstract public void createAccount(String email,String password);
    abstract public void createCurriculum(String name,String code,String grade);
    abstract public void assignClassses(String grade,String subject,String instructorEmail);


}
