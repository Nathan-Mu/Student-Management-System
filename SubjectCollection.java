import java.util.ArrayList;
/**
 * A class to store subject objects.
 * 
 * @author Dongyu Zhao
 * @version 1.0 08 Oct 2013
 */
public class SubjectCollection
{
    private ArrayList<Subject> subjects;
    /**
     * Constructor of SubjectCollection class
     */
    public SubjectCollection()
    {
        subjects = new ArrayList<Subject>();
    }
    
    /**
     * Add subjects.
     * @param subjectArray The subject array which only contains the subjects to be added.
     */
    public void addSubjects(String[] subjectArray)
    {
        for (int i = 0; i < subjectArray.length; i++)
        {
            Subject subject = new Subject();
            subject.setSubject(subjectArray[i].trim());
            subjects.add(subject);
        }
    }
    
    /**
     * Get the number of all subjects in the collection.
     * @return The number of the subjects.
     */
    public int getNumberOfSubjects()
    {
        return subjects.size();
    }
    
    /**
     * Get all subjects in the collection.
     * @return The name of the all subjects.
     */
    public String getSubjectList()
    {
        StringBuffer subjectListStringBuffer = new StringBuffer("");
        for (int i = 0; i < subjects.size(); i++)
        {
            if (subjects.get(i).getName().equals("Computing"))
                subjectListStringBuffer.append("Computing ");
        }
        for (int i = 0; i < subjects.size(); i++)
        {
            if (subjects.get(i).getName().equals("English"))
                subjectListStringBuffer.append("English ");
        }
        for (int i = 0; i < subjects.size(); i++)
        {
            if (subjects.get(i).getName().equals("Maths"))
                subjectListStringBuffer.append("Maths ");
        }
        String subjectList = subjectListStringBuffer.toString().trim().replace(" ", "/");
        return subjectList;
    }
    
    /**
     * Get a subject name.
     * @param i The sequence number of subject in the collection.
     * @return The name of the subject.
     */
    public String getSubjectName(int i)
    {
        if (i < subjects.size())
            return subjects.get(i).getName();
        return null;
    }
}