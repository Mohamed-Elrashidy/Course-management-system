import java.util.Scanner;

public class Person implements PersonInterface {
    private String email;
    private String password;
    private String id;
    private String name;
Person()
{
    Scanner sc=new Scanner(System.in);
    System.out.println("Please Enter Email : ");
    setEmail(sc.nextLine());
    System.out.println("Please Enter Name : ");
    setName(sc.nextLine());
    System.out.println("Please Enter Password : ");
    setPassword(sc.nextLine());
    System.out.println("Please Enter Id : ");
    setId(sc.nextLine());


}
    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Boolean login(int state , String email, String password) {
     if(state==1
             &&Adminstrator.adminstrators.containsKey(email)
             &&Adminstrator.adminstrators.get(email).getPassword()==password)
     {

             return Boolean.TRUE;

     }
     else if(state ==2
     &&Adminstrator.instructors.containsKey(email)
     &&Adminstrator.instructors.get(email).getPassword()==password)
     {
         return Boolean.TRUE;
     }
     else if(state ==3
             &&Adminstrator.students.containsKey(email)
             &&Adminstrator.students.get(email).getPassword()==password)
     {
         return Boolean.TRUE;
     }

     else
     {
         return Boolean.FALSE;
     }

    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}