import java.util.Scanner;
/**
 * A class to excute student management system
 * This programme allows users to add and delete students, list students by name or subject(s) and list all students.
 * 
 * @author Dongyu Zhao
 * @version 1.0 08 Oct 2013
 */
public class ManagementSystem
{
    private StudentCollection studentCollection = new StudentCollection();
    /**
     * Constructor of ManagementSystem class
     */
    public ManagementSystem()
    {
    }
    
    /**
     * Add a student (name, telephone, subjects)
     * Users need to enter student name, telephone and subject(s).
     * This method would constrain users input.
     * Users can exit this method by specific input.
     */
    private void addStudent()
    {
        Validation validation = new Validation();
        NameFormatting format = new NameFormatting();
        for (int i = 0; i < 1; i++)
        {
            Scanner response = new Scanner(System.in);
            System.out.println("");
            System.out.println("------------------Very Important Note-------------------");
            format.printIntroduction();
            System.out.println("==> You can type q! exactly to go back to main menu."); 
            System.out.println("    Meanwhile, it will not save any changes this time.");
            System.out.println("---------------------------------------------------------");
            System.out.println("");
            System.out.print("Student name: ");
            String studentName = response.nextLine().trim();
            while (!validation.isName(studentName) && !studentName.equals("q!") || studentCollection.isNameExist(studentName))
            {
                if (studentCollection.isNameExist(studentName))
                    System.out.println("* Sorry! The name has already existed. Please try again.");
                if (!validation.isName(studentName))
                    System.out.println("* Sorry! Invalid name input. Please try again.");
                System.out.print("Student name: ");
                studentName = response.nextLine().trim();
            }
            if (studentName.equals("q!"))
                break;
            studentName = format.nameFormat(studentName);
            System.out.print("Student telephone number: ");
            String studentTelephone = response.nextLine().trim();
            while (!validation.isTelephone(studentTelephone) && !studentTelephone.equals("q!"))
            {
                System.out.println("* Sorry! Invalid telephone number input. Pleast try again.");
                System.out.print("Student telephone number: ");
                studentTelephone = response.nextLine().trim();
            }
            if (studentTelephone.equals("q!"))
                break;
            System.out.println("Please choose one or multiple option(s) and separated by comma: ");
            System.out.println("(1) Computing  (2) English  (3) Maths");
            System.out.print("Subject number(s): ");
            String studentSubject = response.nextLine().trim();
            studentSubject = studentSubject.replace("1", "Computing").replace("2", "English").replace("3", "Maths");
            String[] subjects = studentSubject.split(",");
            while (!validation.isSubjects(subjects) && !studentSubject.equals("q!"))
            {
                System.out.println("* Sorry! Invalid subject input. Pleast try again.");
                System.out.println("Please choose one or multiple option(s) and separated by comma: ");
                System.out.println("(1) Computing  (2) English  (3) Maths");
                System.out.print("Subject number(s): ");
                studentSubject = response.nextLine().trim();
                studentSubject = studentSubject.replace("1", "Computing").replace("2", "English").replace("3", "Maths");
                subjects = studentSubject.split(",");
            }
            if (studentSubject.equals("q!"))
                break;
            System.out.println("");
            System.out.println("==> A new student has been added successfully!");
            System.out.println("");
            studentCollection.addStudent(studentName, studentTelephone, subjects);
        }
    }
    
    /**
     * Delete a student
     * Users need to enter a student name.
     * This method would constrain users input.
     * Users can exit this method by specific input.
     */
    private void deleteStudent()
    {
        Validation validation = new Validation();
        Scanner response = new Scanner(System.in);
        System.out.println("");
        System.out.println("-------------------------Note----------------------------");
        System.out.println("==> You can type q! exactly to go back to main menu."); 
        System.out.println("    Meanwhile, it will not save any changes this time.");
        System.out.println("---------------------------------------------------------");
        System.out.print("Name of the student to be deleted: ");
        String studentName = response.nextLine().trim();
        while (!validation.isName(studentName) && !studentName.equals("q!"))
        {
            System.out.println("* Sorry! Invalid name input. Please try again.");
            System.out.print("Student name: ");
            studentName = response.nextLine().trim();
        }
        if (studentCollection.findStudent(studentName) != null && !studentName.equals("q!"))
        {
            studentCollection.removeStudent(studentCollection.findStudent(studentName));
            System.out.println("==> The student has been removed successfully!");
            System.out.println("");
        }
        else
        {
            if (!studentName.equals("q!"))
            {
                System.out.println("");    
                System.out.println("* The student (" + studentName + ") can not be found! Please try again.");
                System.out.println("");
            }
        }
    }
    
    /**
     * Find student(s) by name
     * Users need to enter a student name.
     * This method would constrain users input.
     * Users can exit this method by specific input.
     */
    private void findStudentByName()
    {
        Validation validation = new Validation();
        Scanner response = new Scanner(System.in);
        System.out.println("");
        System.out.println("-------------------------Note----------------------------");
        System.out.println("==> You can type q! exactly to go back to main menu."); 
        System.out.println("    Meanwhile, it will not save any changes this time.");
        System.out.println("---------------------------------------------------------");
        System.out.print("Please input a student name: ");
        String studentName = response.nextLine().trim();
        while (!validation.isName(studentName) && !studentName.equals("q!"))
        {
            System.out.println("* Sorry! Invalid name input. Please try again.");
            System.out.print("Student name: ");
            studentName = response.nextLine().trim();
        }
        if (studentCollection.findStudent(studentName) != null && !studentName.equals("q!"))
        {
            System.out.println("");
            System.out.println("======================Search Result======================");
            System.out.println(studentCollection.findStudent(studentName).getStudentInfoLine());
            System.out.println("");
        }
        else
        {  
            System.out.println("* The student (" + studentName + ") can not be found! Please try again.");
            System.out.println("");
        }
    }
    
    /**
     * Read the text file which contains student info when the system starts.
     */
    private void initialization()
    {
        FileIO fileIO = new FileIO();
        for (int i = 0; i < fileIO.getFileLineArray().size(); i++)
        {
            String line = fileIO.getFileLineArray().get(i).toString();
            String[] content =line.split(",");
            String studentName = content[0].trim();
            String studentTelephone = content[1].trim();
            String[] subjects = content[2].trim().split("/");
            studentCollection.addStudent(studentName, studentTelephone, subjects);
        }
    }
    
    /**
     * List all students
     */
    private void listAllStudent()
    {
        System.out.println("");
        if (studentCollection.getNumberOfStudents() > 0)
        {
            System.out.println("==================List All Student(s)====================");
            studentCollection.printAllStudentsInfoLines();
            System.out.println("");
        }
        else
            System.out.println("==> Sorry! No student has been recorded.");
    }
    
    /**
     * Find student(s) by subject(s)
     * Users need to enter subject number.
     * This method would constrain users input.
     * Users can exit this method by specific input.
     */
    private void listStudentBySubject()
    {
        Validation validation = new Validation();
        Scanner response = new Scanner(System.in);
        boolean matchExactly;
        System.out.println("");
        System.out.println("-------------------------Note----------------------------");
        System.out.println("==> You can type q! exactly to go back to main menu."); 
        System.out.println("    Meanwhile, it will not save any changes this time.");
        System.out.println("==> This programme would match the students who are"); 
        System.out.println("    enrolled in multiple subjects. But you can type a");
        System.out.println("    \"?\" sign at the beginning of the line to find");
        System.out.println("    student(s) which maybe not only enrolled in the");
        System.out.println("    searching subjects.");
        System.out.println("---------------------------------------------------------");
        System.out.println("Please choose one or multiple option(s) and separated by comma: ");
        System.out.println("(1) Computing  (2) English  (3) Maths");
        System.out.print("Please input subject(s) name: ");
        String subjectName = response.nextLine().trim();
        subjectName = subjectName.replace("1", "Computing").replace("2", "English").replace("3", "Maths");
        if (subjectName.charAt(0) != '?')
            matchExactly = true;
        else
        {
            matchExactly = false;
            subjectName = subjectName.replaceFirst("[?]", "");
        }
        String[] subjects = subjectName.replaceAll(" +", "").split(",");
        while (validation.isSubjects(subjects) == false && !subjectName.equals("q!"))
        {
            System.out.println("* Sorry! Invalid subject name input. Pleast try again.");
            System.out.print("Subject(s) name: ");
            subjectName = response.nextLine().trim();
            if (subjectName.charAt(0) != '?')
                matchExactly = true;
            else
            {
                matchExactly = false;
                subjectName = subjectName.replaceFirst("[?]", "");
            }
            subjectName = subjectName.replace("1", "Computing").replace("2", "English").replace("3", "Maths");
            subjects = subjectName.replaceAll(" +", "").split(",");
        }
        if (!subjectName.equals("q!"))
        {
            if (matchExactly)
            {
                if (studentCollection.listStudentBySubjectsExactly(subjects).size() == 0)
                {
                    System.out.println("");
                    System.out.println("==> Sorry! No items matched.");
                }
                else
                {
                    System.out.println("");
                    System.out.println("======================Search Result======================");
                    for (int i = 0; i < studentCollection.listStudentBySubjectsExactly(subjects).size(); i++)
                    {
                        System.out.println(studentCollection.listStudentBySubjectsExactly(subjects).get(i)); 
                    }
                }
            }
            else
            {
                if (studentCollection.listStudentBySubjectsContains(subjects).size() == 0)
                {
                    System.out.println("");
                    System.out.println("==> Sorry! No items matched.");
                }
                else
                {
                    System.out.println("");
                    System.out.println("======================Search Result======================");
                    for (int i = 0; i < studentCollection.listStudentBySubjectsContains(subjects).size(); i++)
                    {
                        System.out.println(studentCollection.listStudentBySubjectsContains(subjects).get(i)); 
                    }
                }
            }
        }
        System.out.println("");
    }
    
    /**
     * Write the student info in the text file.
     */
    private void outputFile()
    {
        FileIO fileIO = new FileIO();
        fileIO.writeFile(studentCollection.getAllStudentsInfoLineArrayList());
    }
    
    /**
     * Start student management system
     */
    public void start()
    {
        initialization();
        int i = 1;
        while (i == 1)
        {
            Scanner response = new Scanner(System.in);
            systemInterface();
            System.out.print("Please choose an option:  ");
            String optionChosen = response.nextLine();
            switch (optionChosen)
            {
                case "1": addStudent();
                          break;
                case "2": deleteStudent();
                          break;
                case "3": findStudentByName();
                          break;
                case "4": listStudentBySubject();
                          break;
                case "5": listAllStudent();
                          break;
                case "6": System.out.println("");
                          System.out.println("Thank you!");
                          outputFile();
                          i = 0;
                          System.exit(0);
                          break;
                default: System.out.println("* Please choose an option from 1 to 6.");
                         System.out.println("");
                         break;
            }
        }
    }
    
    /**
     * Interface of student management system
     */
    private void systemInterface()
    {
        System.out.println("------------------------Main Menu------------------------");
        System.out.println("(1) Add new student");
        System.out.println("(2) Delete a student");
        System.out.println("(3) Find Student By Name");
        System.out.println("(4) List Students By Subject");
        System.out.println("(5) List All Students");
        System.out.println("(6) Exit System");
        System.out.println("---------------------------------------------------------");
        System.out.println("");
    }
}