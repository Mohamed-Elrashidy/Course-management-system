import java.util.*;

public class Instructor extends InstructorInterface{
 // key is grade ,value is vector of subject
   Map<String,String> classes=new HashMap();
    Instructor(String email, String password, String name) {
        super(email,password,name);
    }
    Instructor()
    {
        super();
    }


    @Override
   protected void createTask(String grade ,int taskNumber,String task)
   {
    String subject =classes.get(grade);
    Map<Integer,String> tasks=Adminstrator.tasks.get(subject);
    if(tasks!=null&&tasks.containsKey(taskNumber))
        System.out.println("Task number is already exist");
        else
    {tasks.put(taskNumber,task);
        System.out.println("Task is added successfully");
    }
}

    @Override
    protected void submittedProjects(String grade) {
        if(classes.containsKey(grade))
        {String subject =classes.get(grade);
            if(!Adminstrator.tasks.containsKey(subject))
            {
                System.out.println("No tasks found for this grade");
            }

            else {
                boolean flag=false;
            Vector<Student> students = Adminstrator.gradeStudents.get(grade);
            for (Student student :students
                 ) {
                if(student.tasksSubmitted.containsKey(subject))
                {
                    flag=true;
                    System.out.println("Student mail is : "+student.getEmail());
                    Map<Integer,String> submission= student.tasksSubmitted.get(subject);
                    for(Map.Entry<Integer,String> entry : submission.entrySet())
                    {
                        System.out.println("Task number is : "+entry.getKey()+
                                "  submission link is " + entry.getValue() );
                    }
                }
            }
            if(!flag)
                System.out.println("No submission exist");
            }
        }
        else
        {
            System.out.println("This is not your class");
        }

    }
@Override
    protected void getClasses()
    {
        System.out.println("Your classes are : ");

        for (Map.Entry<String,String> entry : classes.entrySet()) {

            System.out.println("class is : "+entry.getKey()+ ", subject is: "+entry.getValue());

        }
    }

    @Override
    protected void setFeedback(String feedback, int taskNumber,String studentEmail) {

    Student student = Adminstrator.students.get(studentEmail);
    if(student==null)
    {
        System.out.println("No such student");
    }
    else{
    String subject = classes.get(student.getGrade());
    if(student.tasksFeedback.containsKey(subject))
    student.tasksFeedback.get(subject).put(taskNumber,feedback);

    else {Map<Integer,String> feed=new HashMap<>();
        feed.put(taskNumber,feedback);student.tasksFeedback.put(subject,feed);}

        System.out.println("Feedback sent successfully");}
    }
    @Override
    public void viewData()
    {
        super.viewData();
        getClasses();
    }
    @Override
    public void run()
    {
        Scanner sc=new Scanner(System.in);

        while(true)
        {
            System.out.println("//////////////////////////////////////////////////////");
            System.out.println("If you want  get classes press 1 : ");
            System.out.println("If you want to you want to get sumbitted tasks  press 2 : ");
            System.out.println("If you want to send feedback press 3 : ");
            System.out.println("If you want to add task press 4 : ");
            System.out.println("If you want to get your data press 5 : ");
            System.out.println("If you want to exit  press 6 : ");

            int state=sc.nextInt();
            //  sc.nextLine();
            if(state==1)
            {
                getClasses();
            }
            else if(state==2)
            {
                System.out.println("Please enter the class that you want to get it's submitted tasks : ");
                sc.nextLine();
                submittedProjects(sc.nextLine());
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
                setFeedback(feedback,taskNumber,studntEmail);
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
                createTask(grade,taskNumber,task);


            }
            else if(state==5)
            {
                viewData();
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
}
