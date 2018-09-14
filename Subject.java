/**
 * A class to store a subject.
 * 
 * @author Dongyu Zhao
 * @version 1.0 08 Oct 2013
 */
public class Subject
{
    private String subjectName;
    /**
     * Constructor of Subject class
     */
    public Subject()
    {
    }
    
    /**
     * Get the subject name.
     * @return The name of the subject.
     */
    public String getName()
    {
        return subjectName;
    }
    
    /**
     * Set the subject name.
     * @param name The name of the subject.
     */
    public void setSubject(String name)
    {
        subjectName = name;
    }
}