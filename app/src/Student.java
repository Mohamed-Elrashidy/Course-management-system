import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class Student extends Person{

    Student(String email,String password ,String name,String grade)
    {
        super(email,password,name);
        setGrade(grade);
    }

    Student()
    {
        super();
        System.out.println("Please Enter grade");
        Scanner sc=new Scanner(System.in);
        String grade=sc.nextLine();
        setGrade(grade);
    }


    private String grade;

    // key is subject ,and value is map of task number and submission url
     public Map< String , Map< Integer , String> > tasksSubmitted=new HashMap<>();
     public Map< String , Map< Integer , String > > tasksFeedback=new HashMap<>();

    protected String getGrade() {
        return grade;
    }

    private void setGrade(String grade) {
        if( !Adminstrator.gradeStudents.containsKey(grade))
        {
            Adminstrator.gradeStudents.put(grade,new Vector<Student>() );
        }


            Adminstrator.gradeStudents.get(grade).add(this);


        this.grade = grade;
    }

    // key is subject value is map it's key is task number and value string of assignment

    private void viewCourses() {
        Vector<String> courses= Adminstrator.gradeSubject.get(grade);
        if(courses.size()==0)
            System.out.println("Courses not determined till now");
        else{
        System.out.println("Your Courses are : ");
        for (String i:courses)
        {
            System.out.println(i+',');
        }}

    }

    private void submitProject(String subject, int projectNum,String ans) {
        //check if subject has tasks and has task with the same projectNum
        if(Adminstrator.tasks.containsKey(subject)&&Adminstrator.tasks.get(subject).containsKey(projectNum))
        {
         if(tasksSubmitted.containsKey(subject))
         {
             tasksSubmitted.get(subject).put(projectNum,ans);
         }
         else
         {
             Map<Integer,String> currentTask=new HashMap<>();
             currentTask.put(projectNum,ans);
             tasksSubmitted.put(subject,currentTask);
         }
            System.out.println("Submission successful");
        }
        else
        {
            System.out.println("Task is not found , submission failed");
        }


    }



    private void getFeedback(String subject, int projectNum) {
        if(tasksFeedback.containsKey(subject)&&tasksFeedback.get(subject).containsKey(projectNum))
        {
            System.out.println("Your Feedback is : ");
            System.out.println(tasksFeedback.get(subject).get(projectNum));
        }
        else {
            System.out.println("No feedback exist.");
        }

    }

    private void getTasks(){
        Vector<String> subjects=Adminstrator.gradeSubject.get(getGrade());
        for (String i:subjects)
        {
            Map<Integer,String> tasks=Adminstrator.tasks.get(i);

            if(tasks.size()==0)
                System.out.println("for subject "+i+" There is no tasks");
            else
                for(Map.Entry<Integer,String> entry: tasks.entrySet())

                {
                    System.out.println("subject is "+i+", task number is "+entry.getKey()+ ",  task is "+entry.getValue());
                }
        }
    }
    @Override
    public void viewData()
    {
        super.viewData();
        System.out.println("Your grade is : " +getGrade());
        viewCourses();
    }
    @Override
    public void run()
    {
            Scanner sc=new Scanner(System.in);

            while(true)
            {    System.out.println("//////////////////////////////////////////////////////");

                System.out.println("If you want  to see your courses press 1 : ");
                System.out.println("If you want to submit tasks  press 2 : ");
                System.out.println("If you want to get feedback press 3 : ");
                System.out.println("If you want to see tasks press 4 : ");
                System.out.println("If you want to get your data press 5: ");
                System.out.println("If you want to exit  press 6 : ");
                int state=sc.nextInt();
                // sc.nextLine();

                if(state==1)
                {
                    viewCourses();
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


                    submitProject(subject,taskNumber,ans);
                }
                else if(state == 3)
                {sc.nextLine();
                    System.out.println("Please enter subject");
                    String subject=sc.nextLine();
                    System.out.println("Please enter task number");


                    int taskNumber=sc.nextInt();

                    getFeedback(subject,taskNumber);
                }
                else if(state==4)
                {
                    getTasks();
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
