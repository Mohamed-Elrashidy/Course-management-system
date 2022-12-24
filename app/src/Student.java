import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class Student extends StudentInterface{

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
    Student(int state)
    {
        super( state);
    }


    // key is subject ,and value is map of task number and submission url
     public Map< String , Map< Integer , String> > tasksSubmitted=new HashMap<>();
     public Map< String , Map< Integer , String > > tasksFeedback=new HashMap<>();
private String grade;

    public String getGrade() {
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


    @Override
    public void viewCourses() {
        Vector<String> courses= Adminstrator.gradeSubject.get(grade);
        System.out.println("Your Courses are : ");
        for (String i:courses)
        {
            System.out.println(i+',');
        }

    }

    @Override
    public void submitProject(String subject, int projectNum,String ans) {

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
            System.out.println("Submission succeful!!");
        }
        else
        {
            System.out.println("Task is not found , submmission failed");
        }


    }
    public void getTasks(){
        Vector<String> subjects=Adminstrator.gradeSubject.get(getGrade());
        for (String i:subjects)
        {
            Map<Integer,String> tasks=Adminstrator.tasks.get(i);

            if(tasks.size()==0)
                System.out.println("for subject "+i+" There is no tasks");
            else
            for(Map.Entry<Integer,String> entry: tasks.entrySet())

            {
                System.out.println("subject is "+i+" task number is "+entry.getKey()+ "  task is "+entry.getValue());
            }
        }
    }

    @Override
    public void getFeedback(String subject, int projectNum) {
        if(tasksFeedback.containsKey(subject)&&tasksFeedback.get(subject).containsKey(projectNum))
        {
            System.out.println("Your Feedback is : ");
            System.out.println(tasksFeedback.get(subject).get(projectNum));
        }
        else {
            System.out.println("No feedback exist.");
        }

    }
}
