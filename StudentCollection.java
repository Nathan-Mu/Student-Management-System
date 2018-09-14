import java.util.ArrayList;
/**
 * A class to store student collection.
 * 
 * @author Dongyu Zhao
 * @version 1.0 08 Oct 2013
 */
public class StudentCollection
{
    private ArrayList<Student> students;
    /**
     * Constructor of StudentCollection class
     */
    public StudentCollection()
    {
        students = new ArrayList<Student>();
    }

    /**
     * Add a new student as an object of Student class.
     * @param name,telephone,subjects
     */
    public void addStudent(String name, String telephone, String[] subjects)
    {
        Student student = new Student();
        student.setName(name);
        student.setTelephone(telephone);
        student.setSubject(subjects); 
        students.add(student);    
    }
    
    /**
     * Find a student by name.
     * @param name Student name.
     * @return an object of Student class.
     */
    public Student findStudent(String name)
    {
        for (int i = 0; i < getNumberOfStudents(); i++)
        {
            if (getAStudentName(i).equalsIgnoreCase(name))
                 return students.get(i);
        }
        return null;
    }
    
    /**
     * Display a student details.
     * @param i The sequence number of student in the collection.
     * @return Details of the student.
     */
    public String getAStudentInfoLine(int i)
    {
        if (i >= 0 && i < students.size())
            return students.get(i).getStudentInfoLine();
        else
            return null;
    } 
    
    /**
     * Display a student name.
     * @param i The sequence number of student in the collection.
     * @return The name of the subjects.
     */
    public String getAStudentName(int i)
    {
        return students.get(i).getName();
    }
    
    public ArrayList getAllStudentsInfoLineArrayList()
    {
        ArrayList<String> studentsArrayList = new ArrayList<String>();
        for (int i = 0; i < students.size(); i++)
        {
            studentsArrayList.add(getAStudentInfoLine(i));
        }
        return studentsArrayList;
    }
    
    /**
     * Count the number of all students.
     * @return The number of all students.
     */
    public int getNumberOfStudents()
    {
        return students.size();
    }
     
    /**
     * Determine whether the name exists in the system.
     * @parma stringCheck 
     * @Return true if the name has existed in the system.
     */
    public boolean isNameExist(String stringCheck)
    {
        boolean isNameExist = false;
        if (findStudent(stringCheck) != null)
            isNameExist = true;
        return isNameExist;
    }
    
    /**
     * Get an arraylist of students whose subjects match the search exactly.
     * @param subjects The string array which only contains subjects to search.
     * @return An arraylist of the found student(s).
     */
    public ArrayList<String> listStudentBySubjectsContains(String[] subjects)
    {
        ArrayList<String> foundStudents = new ArrayList<String>();
        for (int i = 0; i < students.size(); i++)
        {
            boolean isContains = false;
            for (int j = 0; j < subjects.length; j++)
            {
                for (int k = 0; k < students.get(i).getNumberOfSubjects(); k++)
                {
                    if (subjects[j].equalsIgnoreCase(students.get(i).getASubject(k)))
                    {
                        isContains = true;
                        break;
                    }
                    else
                        isContains = false;
                }      
                if (!isContains)
                    break;
            }
            if (isContains)
                foundStudents.add(students.get(i).getStudentInfoLine());
        }
        return foundStudents;
    }
    
    /**
     * Get an arraylist of students whose subjects match the search exactly.
     * @param subjects The string array which only contains subjects to search.
     * @return An arraylist of the found student(s).
     */
    public ArrayList<String> listStudentBySubjectsExactly(String[] subjects)
    {
        ArrayList<String> foundStudents = new ArrayList<String>();
        for (int i = 0; i < students.size(); i++)
        {
            boolean isContains = false;
            if (students.get(i).getNumberOfSubjects() != subjects.length)
                continue;
            else
                for (int j = 0; j < subjects.length; j++)
                {
                    for (int k = 0; k < students.get(i).getNumberOfSubjects(); k++)
                    {
                        if (subjects[j].equalsIgnoreCase(students.get(i).getASubject(k)))
                        {
                            isContains = true;
                            break;
                        }
                        else
                            isContains = false;
                    }      
                    if (!isContains)
                        break;
                }
            if (isContains)
                foundStudents.add(students.get(i).getStudentInfoLine());
        }
        return foundStudents;
    }
    
    /**
     * Print all students' details.
     */
    public void printAllStudentsInfoLines()
    {
        for (int i = 0; i < students.size(); i++)
            printAStudentInfoLine(i);
    }
    
    /**
     * Print student details.
     * @param i The number of student in the collection.
     */
    public void printAStudentInfoLine(int i)
    {
        if (i >= 0 && i < students.size())
            System.out.println(students.get(i).getStudentInfoLine());
    }

    /**
     * Remove a student.
     * @param i The sequence number of student in the collection.
     */
    public void removeAStudent (int i)
    {
        if (i >= 0 && i < students.size())
            students.remove(i);
    }
    
    /**
     * Remove a student.
     * @param student The object that contains the student to be removed.
     */
    public void removeStudent(Student student)
    {
        if (student != null)
            students.remove(student);
    }
}