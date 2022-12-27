import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class Adminstrator extends Person {
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

    private void createAccount(Adminstrator adminstrator) {

        if(adminstrators.containsKey(adminstrator.getEmail()))
        {
            System.out.println("Sorry  administrator email is already exist");
        }
        else
        {
            adminstrators.put(adminstrator.getEmail(),adminstrator);
            System.out.println("Administrator is added successfully");
        }

    }

    private void createAccount(Instructor instructor) {

        if(instructors.containsKey(instructor.getEmail()))
        {
            System.out.println("Sorry instructor email is already exist");
        }
        else
        {
            instructors.put(instructor.getEmail(),instructor);
            System.out.println("Instructor is added successfully");
        }

    }

    private void createAccount(Student student) {

        if(students.containsKey(student.getEmail()))
        {
            System.out.println("Sorry student email is already exist");
        }
        else
        {
            students.put(student.getEmail(),student);
            System.out.println("Student is added successfully");
        }

    }

    protected void createCurriculum(String grade ,String subjectName,String subjectCode) {
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

    protected void assignClassses(String grade,String subject,String instructorEmail) {
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

    @Override
    public void run() {
        Scanner sc= new Scanner(System.in);
        while(true)
        {    System.out.println("//////////////////////////////////////////////////////");

            System.out.println("If you want to create adminstrator account  press 1 : ");
            System.out.println("If you want to create instructor account press 2 : ");
            System.out.println("If you want to create student account press 3 : ");
            System.out.println("If you want to add Curriculum to specific class press 4 : ");
            System.out.println("If you want to assign class to instructor press 5 : ");
            System.out.println("If you want to get your data press 6 : ");
            System.out.println("If you want to exit  press 7");

            int state = sc.nextInt();
            //sc.nextLine();

            if(state == 1)
            {sc.nextLine();
                createAccount(new Adminstrator());
            }
            else if(state==2)
            {sc.nextLine();
                createAccount(new Instructor());
            }
            else if(state==3)
            {sc.nextLine();
                createAccount(new Student());
            }
            else if(state==4)
            {sc.nextLine();
                System.out.println("Please Enter grade : ");
                String grade=sc.nextLine();
                System.out.println("Please Enter subjectName: ");
                String subjectname=sc.nextLine();
                System.out.println("Please Enter subjectCode:  ");
                String subjectCode=sc.nextLine();
                createCurriculum(grade,subjectname,subjectCode);

            }
            else if(state == 5 )
            {sc.nextLine();
                System.out.println("Please Enter grade : ");
                String grade=sc.nextLine();
                System.out.println("Please Enter {\"subjectName\"\"subjectCode\" }}, : ");
                String subjectname=sc.nextLine();
                System.out.println("Please Enter instructor email:  ");
                String instructorEmail=sc.nextLine();
                assignClassses(grade,subjectname,instructorEmail);
            }
            else if(state==6)
            {
                viewData();
            }
            else if(state==7)
            {
                break;
            }
            else{
                System.out.println("Invalid input");
            }
        }
    }
}
