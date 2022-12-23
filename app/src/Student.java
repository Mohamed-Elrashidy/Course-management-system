import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Student extends StudentInterface{
    // key is subject ,and value is map of task number and submission url
     public Map< String , Map< Integer , String> > tasksSubmitted=new HashMap<>();
     public Map< String , Map< Integer , String > > tasksFeedback=new HashMap<>();
private String grade;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
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

        if(Adminstrator.tasks.containsKey(subject)&&Adminstrator.tasks.get(subject).contains(projectNum))
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
