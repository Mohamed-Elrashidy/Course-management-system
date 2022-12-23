import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Adminstrator extends AdminstratorInterface {

// key is email and value is object of person
static public Map<String,Adminstrator> adminstrators=new HashMap<>();
static public Map<String,Insturctor> instructors=new HashMap<>();
static public Map<String,Student> students=new HashMap<>();


// key is grade , value is list of subjects for this grade
static public Map<String, Vector<String>> gradeSubject=new HashMap<>();

// key is grade ,value list of students
static public Map<String, Vector<Student>> gradeStudents=new HashMap<>();



// key is subject name and value is vector of tasks numbers
static public Map<String,Vector<Integer>> tasks=new HashMap<>();





    @Override
    public void createAccount(Adminstrator adminstrator) {

        if(adminstrators.containsKey(adminstrator.getEmail()))
        {
            System.out.println("Sorry is adminstrator email is already exist");
        }
        else
        {
            adminstrators.put(adminstrator.getEmail(),adminstrator);
            System.out.println("Adminstrator is added succefully");
        }

    }
    public void createAccount(Insturctor insturctor) {

        if(instructors.containsKey(insturctor.getEmail()))
        {
            System.out.println("Sorry is instructor email is already exist");
        }
        else
        {
            instructors.put(insturctor.getEmail(),insturctor);
            System.out.println("Instructor is added successfully");
        }

    }

    public void createAccount(Student student) {

        if(students.containsKey(student.getEmail()))
        {
            System.out.println("Sorry is student email is already exist");
        }
        else
        {
            students.put(student.getEmail(),student);
            System.out.println("Student is added succefully");
        }

    }

    @Override
    public void createCurriculum(String grade ,String subjectName,String subjectCode) {
      if(gradeSubject.containsKey(grade))
      {gradeSubject.get(grade).add(subjectName+','+subjectCode);
          System.out.println("subject added successfully");
      }
      else
      {Vector<String> subjects=new Vector<>();
          subjects.add(subjectName+','+subjectCode);
          gradeSubject.put(grade,subjects);
          System.out.println("Grade is create and subject is added Successfully");

      }
    }

    @Override
    public void assignClassses(String grade,String subject,String instructorEmail) {
        if(instructors.containsKey(instructorEmail))
        {
            Insturctor insturctor=instructors.get(instructorEmail);
            insturctor.classes.put(grade,subject);
            System.out.println("Grade is added succefully");
        }
        else
        {
            System.out.println("There is no such instructor email !!");
        }

    }
}
