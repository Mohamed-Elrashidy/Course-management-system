import java.util.*;

public class Insturctor extends InstructorInterface{
 // key is grade ,value is vector of subject
   Map<String,String> classes=new HashMap();




    @Override
    public void submittedProjects(String grade) {
        if(classes.containsKey(grade))
        {
            String subject =classes.get(grade);
            Vector<Student> students = Adminstrator.gradeStudents.get(grade);
            for (Student student :students
                 ) {
                if(student.tasksSubmitted.containsKey(subject))
                {
                    System.out.println("Student mail is : "+student.getEmail());
                    Map<Integer,String> submission= student.tasksSubmitted.get(subject);
                    for(Map.Entry<Integer,String> entry : submission.entrySet())
                    {
                        System.out.println("Task number is : "+entry.getKey()+
                                "  submission link is " + entry.getValue() );
                    }
                }
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
    student.tasksFeedback.get(subject).put(taskNumber,feedback);


    }
}
