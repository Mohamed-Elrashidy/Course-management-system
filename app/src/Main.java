import java.util.Scanner;

public class Main {
    public static boolean login(int state, String email, String password) {
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

    public static void dataLoad()
    {
       Adminstrator.adminstrators.put("mohamed.elrashidy354@gmail.com",
               new Adminstrator("mohamed.elrashidy354@gmail.com","123456","Mohamed Elrashidy"));
       Adminstrator.adminstrators.put("Ahmed@gmail.com",
                new Adminstrator("Ahmed@gmail.com","123456","Ahmed Ali"));
       Adminstrator.instructors.put("mohamed@gmail.com",
                new Instructor("mohamed@gmail.com","123456","Mohamed Hossam"));
       Adminstrator.instructors.put("Youssef@gmail.com",
                new Instructor("Youssef@gmail.com","123456","Youssef Waheed"));
       Adminstrator.students.put("Ali@gmail.com",
                new Student("Ali@gmail.com","123456","Ali Alaa","grade1"));
       Adminstrator.students.put("Ibraheem@gmail.com",
                new Student("Ibraheem@gmail.com","123456","Ibraheem mostafa","grade2"));
        new Adminstrator(1).createCurriculum("grade1","Math","m1");

        new Adminstrator(1).createCurriculum("grade1","OOP","o1");
        new Adminstrator(1).createCurriculum("grade1","data structure","d1");
        new Adminstrator(1).createCurriculum("grade2","database","d2");
        new Adminstrator(1).createCurriculum("grade2","Math","m2");
        new Adminstrator(1).createCurriculum("grade2","operating system","o2");
        new Adminstrator(1).createCurriculum("grade3","Math","m3");
        new Adminstrator(1).createCurriculum("grade3","OOD","o3");
        new Adminstrator(1).createCurriculum("grade3","operating system","o4");
        new Adminstrator(1).assignClassses("grade1","Math m1","Youssef@gmail.com");
        new Adminstrator(1).assignClassses("grade2","database d2","Youssef@gmail.com");
        new Adminstrator(1).assignClassses("grade3","operating system o4","mohamed@gmail.com");

            }
    public static void main(String[] args) {
      dataLoad();
      Person person;
while(true)
{
    System.out.println("//////////////////////////////////////////////////////");
    System.out.println("If you are adminstrator press 1 : ");
    System.out.println("If you are instructor press 2 : ");
    System.out.println("If you are sutdent press 3 : ");
    System.out.println("If you want to exist press 4 : ");
    Scanner sc=new Scanner(System.in);
    int state= sc.nextInt();

   if ( state == 1)
   {sc.nextLine();
       System.out.println("Please enter your email : ");
       System.out.println("Please enter your password : ");
       String email=sc.nextLine();
       String password=sc.nextLine();
       boolean flag=   login(state,email,password);

       if(!flag)
       {
           System.out.println("Invalid Email or password");
           continue;
       }
       person =Adminstrator.adminstrators.get(email);
       person.run();

   }
   else if (state == 2 )
   {
       System.out.println("Please enter your email : ");
       System.out.println("Please enter your password : ");
       sc.nextLine();
       String email=sc.nextLine();
       String password=sc.nextLine();
       boolean flag=   login(state,email,password);
       if(!flag)
       {
           System.out.println("Invalid Email or password");
           continue;
       }
       person=Adminstrator.instructors.get(email);
       person.run();

   }
   else if (state == 3 )
   {
       System.out.println("Please enter your email : ");
       System.out.println("Please enter your password : ");
       sc.nextLine();
       String email=sc.nextLine();
       String password=sc.nextLine();
       boolean flag=   login(state,email,password);
       if(!flag)
       {
           System.out.println("Invalid Email or password");
           continue;
       }
       person = Adminstrator.students.get(email);
       person.run();
   }
   else if(state == 4)
   {
       break;
   }
   else {
       System.out.println("Invalid input");
   }
}
    }
}