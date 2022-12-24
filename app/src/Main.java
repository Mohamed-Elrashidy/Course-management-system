import java.util.Scanner;

public class Main {
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
        new Adminstrator(1).assignClassses("grade1","Mathm1","Youssef@gmail.com");
        new Adminstrator(1).assignClassses("grade2","databased2","Youssef@gmail.com");
        new Adminstrator(1).assignClassses("grade3","operating systemo4","mohamed@gmail.com");

            }
    public static void main(String[] args) {
      dataLoad();
while(true)
{
    System.out.println("If you are adminstrator press 1 : ");
    System.out.println("If you are instructor press 2 : ");
    System.out.println("If you are sutdent press 3 : ");
    System.out.println("If you wnat to exist press 4 : ");
    Scanner sc=new Scanner(System.in);
    int state= sc.nextInt();

   if ( state == 1)
   {
       Adminstrator currentUser;
       System.out.println("Please enter your email : ");
       System.out.println("Please enter your password : ");
       String email=sc.nextLine();
       String password=sc.nextLine();
       boolean flag=   new Person(state).login(state,email,password);

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

           state = sc.nextInt();
           //sc.nextLine();

           if(state == 1)
           {sc.nextLine();
               currentUser.createAccount(new Adminstrator());
           }
           else if(state==2)
           {sc.nextLine();
               currentUser.createAccount(new Instructor());
           }
          else if(state==3)
           {sc.nextLine();
               currentUser.createAccount(new Student());
           }
          else if(state==4)
           {sc.nextLine();
               System.out.println("Please Enter grade : ");
               String grade=sc.nextLine();
               System.out.println("Please Enter subjectName: ");
               String subjectname=sc.nextLine();
               System.out.println("Please Enter subjectCode:  ");
               String subjectCode=sc.nextLine();
               currentUser.createCurriculum(grade,subjectname,subjectCode);

           }
           else if(state == 5 )
           {sc.nextLine();
               System.out.println("Please Enter grade : ");
               String grade=sc.nextLine();
               System.out.println("Please Enter {\"subjectName\"\"subjectCode\" }}, : ");
               String subjectname=sc.nextLine();
               System.out.println("Please Enter instructor email:  ");
               String instructorEmail=sc.nextLine();
               currentUser.assignClassses(grade,subjectname,instructorEmail);
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
       sc.nextLine();
       String email=sc.nextLine();
       String password=sc.nextLine();
       boolean flag=   new Person(state).login(state,email,password);
       if(!flag)
       {
           System.out.println("Invalid Email or password");
           continue;
       }
       Instructor currentUser=Adminstrator.instructors.get(email);
       while(true)
       {
           System.out.println("If you want  get classes press 1 : ");
           System.out.println("If you want to you want to get sumbitted tasks  press 2 : ");
           System.out.println("If you want to send feedback press 3 : ");
           System.out.println("If you want to add task press 4 : ");

           System.out.println("If you want to exit  press 5 : ");

           state=sc.nextInt();
         //  sc.nextLine();
           if(state==1)
           {
               currentUser.getClasses();
           }
           else if(state==2)
           {
               System.out.println("Please enter the class that you want to get it's submitted tasks : ");
               sc.nextLine();
               currentUser.submittedProjects(sc.nextLine());
           }
           else if(state==3)
           {
               System.out.println("Please Enter feedback : ");
               sc.nextLine();
               String feedback =sc.nextLine();
               System.out.println("Please Enter task number ");


               int taskNumber=sc.nextInt();
               sc.nextLine();
               System.out.println("Please Enter student email ");
               String studntEmail=sc.nextLine();
               currentUser.setFeedback(feedback,taskNumber,studntEmail);
           }
           else if(state==4)
           {sc.nextLine();
               System.out.println("Please Enter task ");
               String task =sc.nextLine();
               System.out.println("Please Enter task number ");
               int taskNumber=sc.nextInt();
               sc.nextLine();
               System.out.println("Please enter grade ");
               String grade=sc.nextLine();
               currentUser.createTask(grade,taskNumber,task);


           }
           else if(state==5)
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
       sc.nextLine();
       String email=sc.nextLine();
       String password=sc.nextLine();
       boolean flag=   new Person(state).login(state,email,password);
       if(!flag)
       {
           System.out.println("Invalid Email or password");
           continue;
       }
       Student currentUser= Adminstrator.students.get(email);
       while(true)
       {
           System.out.println("If you want  to see your courses press 1 : ");
           System.out.println("If you want to submit tasks  press 2 : ");
           System.out.println("If you want to get feedback press 3 : ");
           System.out.println("If you want to see tasks press 4 : ");


           System.out.println("If you want to exit  press 5 : ");
           state=sc.nextInt();
          // sc.nextLine();

           if(state==1)
           {
               currentUser.viewCourses();
           }
           else if(state==2)
           {sc.nextLine();
               System.out.println("Please enter subject name ");
               String subject=sc.nextLine();
               System.out.println("Please enter task number");
               int taskNumber = sc.nextInt();
               sc.nextLine();
               System.out.println("Please Enter your answer");
               String ans =sc.nextLine();


               currentUser.submitProject(subject,taskNumber,ans);
           }
           else if(state==3)
           {sc.nextLine();
               System.out.println("Please enter subject");
               String subject=sc.nextLine();
               System.out.println("Please enter task number");


               int taskNumber=sc.nextInt();

               currentUser.getFeedback(subject,taskNumber);
           }
           else if(state==4)
           {
               currentUser.getTasks();
           }
           else if(state==5)
           {
               break;

           }

           else{
               System.out.println("Invalid input");
           }

       }
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