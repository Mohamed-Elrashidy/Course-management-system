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
    Instructor(int state){
        super(state);
    }
void createTask(String grade ,int taskNumber,String task)
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
    public void submittedProjects(String grade) {
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
    public void getClasses()
    {
        System.out.println("Your classes are : ");

        for (Map.Entry<String,String> entry : classes.entrySet()) {

            System.out.println(entry.getKey());

        }
    }

    @Override
    public void setFeedback(String feedback, int taskNumber,String studentEmail) {

    Student student = Adminstrator.students.get(studentEmail);
    String subject = classes.get(student.getGrade());
    if(student.tasksFeedback.containsKey(subject))
    student.tasksFeedback.get(subject).put(taskNumber,feedback);

    else {Map<Integer,String> feed=new HashMap<>();
        feed.put(taskNumber,feedback);student.tasksFeedback.put(subject,feed);}

        System.out.println("Feedback sent successfully");
    }
}
