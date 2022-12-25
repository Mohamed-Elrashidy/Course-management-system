import java.util.Scanner;

public class Person implements PersonInterface {
    static private int idGenerator=1;
    private String email;
    private String password;
     private String id;
    private String name;
    Person(int state){}
Person()
{
    Scanner sc=new Scanner(System.in);
    System.out.println("Please Enter Email : ");
    setEmail(sc.nextLine());
    System.out.println("Please Enter Name : ");
    setName(sc.nextLine());
    System.out.println("Please Enter Password : ");
    setPassword(sc.nextLine());
    setId();


}
Person(String email,String password,String name){
   setEmail(email);
   setPassword(password);
   setName(name);
   setId();
}
    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    protected String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    @Override
    public void setId() {
        this.id = Integer.toString(idGenerator++);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Boolean login(int state, String email, String password) {


     if(state==1
             &&Adminstrator.adminstrators.containsKey(email)
             &&Adminstrator.adminstrators.get(email).getPassword().equals(password))
     {

             return Boolean.TRUE;

     }
     else if(state ==2
     &&Adminstrator.instructors.containsKey(email)
     &&Adminstrator.instructors.get(email).getPassword().equals(password))
     {
         return Boolean.TRUE;
     }
     else if(state ==3
             &&Adminstrator.students.containsKey(email)
             &&Adminstrator.students.get(email).getPassword().equals(password))
     {
         return Boolean.TRUE;
     }

     else
     {
         return Boolean.FALSE;
     }

    }

    @Override
    public void viewData() {
        System.out.println("Your Data : ");
        System.out.println("name : " + getName());
        System.out.println("id : " + getId());
        System.out.println("email : "+ getEmail());
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
