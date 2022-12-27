import java.util.Scanner;

abstract public class Person  {
    static private int idGenerator=1;
    private String email;
    private String password;
     private String id;
    private String name;
    Person(int state){}
Person() {
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

    public String getEmail() {
        return email;
    }


     abstract  public void run() ;

    private void setEmail(String email) {
        this.email = email;
    }

    protected String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private String getId() {
        return id;
    }

    private void setId() {
        this.id = Integer.toString(idGenerator++);
    }

    private String getName() {
        return name;
    }

    protected void viewData()
    {
        System.out.println("Your Data : ");
        System.out.println("name : " + getName());
        System.out.println("id : " + getId());
        System.out.println("email : "+ getEmail());
    }

    private void setName(String name) {
        this.name = name;
    }
}
