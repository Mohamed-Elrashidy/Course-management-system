import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Adminstrator extends AdminstratorInterface {
    Adminstrator(String email, String password, String name) {
        super(email,password,name);
    }
    Adminstrator()
    {
        super();
    }
    Adminstrator(int state)
    {
        super(state);
    }

// key is email and value is object of person
static public Map<String,Adminstrator> adminstrators=new HashMap<>();
static public Map<String,Instructor> instructors=new HashMap<>();
static public Map<String,Student> students=new HashMap<>();


// key is grade , value is list of subjects for this grade
static public Map<String, Vector<String>> gradeSubject=new HashMap<>();

// key is grade ,value list of students
static public Map<String, Vector<Student>> gradeStudents=new HashMap<>();



// key is subject name and value is vector of tasks numbers
static public Map<String,Map<Integer,String>> tasks=new HashMap<>();



    @Override
    public void createAccount(Adminstrator adminstrator) {

        if(adminstrators.containsKey(adminstrator.getEmail()))
        {
            System.out.println("Sorry is administrator email is already exist");
        }
        else
        {
            adminstrators.put(adminstrator.getEmail(),adminstrator);
            System.out.println("Administrator is added successfully");
        }

    }
    public void createAccount(Instructor instructor) {

        if(instructors.containsKey(instructor.getEmail()))
        {
            System.out.println("Sorry is instructor email is already exist");
        }
        else
        {
            instructors.put(instructor.getEmail(),instructor);
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
            System.out.println("Student is added successfully");
        }

    }

    @Override
    public void createCurriculum(String grade ,String subjectName,String subjectCode) {
        String newSubject=subjectName+" "+subjectCode;
        if(tasks.containsKey(newSubject))
        {
            System.out.println("Subject is already exist");
        }

        else{
            Map<Integer, String> task = new HashMap<>();
            tasks.put(newSubject, task);
            if (!gradeStudents.containsKey(grade))
                gradeStudents.put(grade, new Vector<Student>());
            if (gradeSubject.containsKey(grade)) {
                if (gradeSubject.get(grade).contains(newSubject)) {
                    System.out.println("subject is already exist");
                } else {
                    gradeSubject.get(grade).add(newSubject);
                    System.out.println("subject added successfully");
                }
            } else {
                Vector<String> subjects = new Vector<>();
                subjects.add(newSubject);
                gradeSubject.put(grade, subjects);
                System.out.println("Grade is create and subject is added Successfully");

            }
        }

    }

    @Override
    public void assignClassses(String grade,String subject,String instructorEmail) {
        if(instructors.containsKey(instructorEmail))
        {
            Instructor instructor=instructors.get(instructorEmail);
            instructor.classes.put(grade,subject);
            System.out.println("Grade is added successfully");
        }
        else
        {
            System.out.println("There is no such instructor email ");
        }

    }

}
