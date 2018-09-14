/**
 * A class to store student object.
 * 
 * @author Dongyu Zhao
 * @version 1.0 08 Oct 2013
 */
public class Student
{
    private String name;
    private String telephone;
    private SubjectCollection subjectCollection = new SubjectCollection();
    /**
     * Constructor of Student class
     */
    public Student()
    {
    }
    
    /**
     * Get one of subjects of the student.
     * @param i The sequence number of subjects in the collection.
     * @return The name of the subject.
     */
    public String getASubject(int i)
    {
        return subjectCollection.getSubjectName(i);
    }
    
    /**
     * Get the student name.
     * @return The name of the student.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Get the number of subject(s) of the student.
     * @return The number of subject(s).
     */
    public int getNumberOfSubjects()
    {
        return subjectCollection.getNumberOfSubjects();
    }
    
    /**
     * Get the details of the student.
     * @return All information recorded in the program of the student.
     */
    public String getStudentInfoLine()
    {
        StringBuffer studentInfoLine = new StringBuffer("");
        return studentInfoLine.append(name + ", " + telephone + ", " + getSubjectList()).toString();
    }
    
    /**
     * Get one of all subjects of the student.
     * @return The all subjects' name of the student.
     */
    public String getSubjectList()
    {
        return subjectCollection.getSubjectList();
    }
    
    /**
     * Get the student's telephone number.
     * @return The telephone number of the student.
     */
    public String getTelephone()
    {
        return telephone;
    }
    
    /**
     * Set name of the student.
     * @param newName The name of the new student.
     */
    public void setName(String newName)
    {
        name = newName;
    }
    
    /**
     * Set subject(s) of the student.
     * @param subjects The string array which only contains the subject(s) that the student has enrolled in.
     */
    public void setSubject(String[] newSubjects)
    {
        subjectCollection.addSubjects(newSubjects);
    }
    
    /**
     * Set telephone number of the student.
     * @param newTelephone The telephone number of the new student.
     */
    public void setTelephone(String newTelephone)
    {
        telephone = newTelephone;
    }
}
