import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Adminstrator mainAdmin= new Adminstrator();
        Adminstrator.adminstrators.put(mainAdmin.getEmail(),mainAdmin);

while(true)
{
    System.out.println("If you are adminstrator press 1 : ");
    System.out.println("If you are instructor press 2 : ");
    System.out.println("If you are sutdent press 3 : ");
    System.out.println("If you wnat to exist press 4 : ");
    Scanner sc=new Scanner(System.in);
    int state= sc.nextInt();
    sc.nextLine();
   if ( state == 1)
   {
       Adminstrator currentUser;
       System.out.println("Please enter your email : ");
       System.out.println("Please enter your password : ");
       String email=sc.nextLine();
       String password=sc.nextLine();
       boolean flag=   new Person().login(state,email,password);

       if(!flag)
       {
           System.out.println("Invalid Email or password");
           continue;
       }
       currentUser=Adminstrator.adminstrators.get(email);
       while(true)
       {
           System.out.println("If you want to create adminstrator account  press 1 : ");
           System.out.println("If you want to create instructor account press 2 : ");
           System.out.println("If you want to create student account press 3 : ");
           System.out.println("If you want to add Curriculum to specific class press 4 : ");
           System.out.println("If you want to assign class to instructor press 5 : ");
           System.out.println("If you want to exit  press 6");
           state=sc.nextInt();
           sc.nextLine();
           if(state==1)
           {
               currentUser.createAccount(new Adminstrator());
           }
           else if(state==2)
           {
               currentUser.createAccount(new Insturctor());
           }
          else if(state==3)
           {
               currentUser.createAccount(new Student());
           }
          else if(state==4)
           {
               System.out.println("Please Enter grade : ");
               String grade=sc.nextLine();
               System.out.println("Please Enter subjectName: ");
               String subjectname=sc.nextLine();
               System.out.println("Please Enter subjectCode:  ");
               String subjectCode=sc.nextLine();
               currentUser.createCurriculum(grade,subjectname,subjectCode);

           }
           else if(state == 5 )
           {
               System.out.println("Please Enter grade : ");
               String grade=sc.nextLine();
               System.out.println("Please Enter {\"subjectName\"\"subjectCode\" }}, : ");
               String subjectname=sc.nextLine();
               System.out.println("Please Enter instructor email:  ");
               String instructorEmail=sc.nextLine();
               currentUser.createCurriculum(grade,subjectname,instructorEmail);
           }
           else if(state==6)
           {
               break;
           }
           else{
               System.out.println("Invalid input");
           }
       }
   }
   else if (state == 2 )
   {
       System.out.println("Please enter your email : ");
       System.out.println("Please enter your password : ");
       String email=sc.nextLine();
       String password=sc.nextLine();
       boolean flag=   new Person().login(state,email,password);
       if(!flag)
       {
           System.out.println("Invalid Email or password");
           continue;
       }
       Insturctor currentUser=Adminstrator.instructors.get(email);
       while(true)
       {
           System.out.println("If you want  get classes press 1 : ");
           System.out.println("If you want to you want to get sumbitted tasks  press 2 : ");
           System.out.println("If you want to send feedback press 3 : ");
           System.out.println("If you want to exit  press 4 : ");
           state=sc.nextInt();
           sc.nextLine();
           if(state==1)
           {
               currentUser.getClasses();
           }
           else if(state==2)
           {
               System.out.println("Please enter the class that you want to get it's submitted tasks : ");
               currentUser.submittedProjects(sc.nextLine());
           }
           else if(state==3)
           {
               System.out.println("Please Enter feedback : ");
               currentUser.setFeedback();
           }
           else if(state==4)
           {
               System.out.println("Please Enter grade : ");
               String grade=sc.nextLine();
               System.out.println("Please Enter subjectName: ");
               String subjectname=sc.nextLine();
               System.out.println("Please Enter subjectCode:  ");
               String subjectCode=sc.nextLine();
               currentUser.createCurriculum(grade,subjectname,subjectCode);

           }
           else if(state == 5 )
           {
               System.out.println("Please Enter grade : ");
               String grade=sc.nextLine();
               System.out.println("Please Enter {\"subjectName\"\"subjectCode\" }}, : ");
               String subjectname=sc.nextLine();
               System.out.println("Please Enter instructor email:  ");
               String instructorEmail=sc.nextLine();
               currentUser.createCurriculum(grade,subjectname,instructorEmail);
           }
           else if(state==6)
           {
               break;
           }
           else{
               System.out.println("Invalid input");
           }
       }
   }
   else if (state == 3 )
   {
       System.out.println("Please enter your email : ");
       System.out.println("Please enter your password : ");
       String email=sc.nextLine();
       String password=sc.nextLine();
       boolean flag=   new Person().login(state,email,password);
       if(!flag)
       {
           System.out.println("Invalid Email or password");
           continue;
       }
       while(true)
       {

       }
   }
   else if(state ==4)
   {
       break;
   }
   else {
       System.out.println("Invalid input");
   }


}
    }
}