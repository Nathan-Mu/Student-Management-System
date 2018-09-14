/**
 * A class to format name.
 * 
 * @author Dongyu Zhao
 * @version 1.0 08 Oct 2013
 */
public class NameFormatting
{
    /**
     * Constructor for objects of class NameFormatting
     */
    public NameFormatting()
    {
    }
    
    /**
     * Rewrite the first letter of a string to upper case.
     * @parma string  The string to be rewritten.
     * @Return the string which has been rewritten.
     */
    private String firstLetterUpperCase(String string)
    {
        return string.replaceFirst(string.substring(0, 1), string.substring(0, 1).toUpperCase());
    }
    
    /**
     * Print the introduction of name formatting.
     */
    public void printIntroduction()
    {
        System.out.println("==> For this step, the user need to input a full name.");
        System.out.println("    which contains first name and last name, separated");
        System.out.println("    by space. Please do not put any sign in the names.");
        System.out.println("    This program trys to correct format mistakes");
        System.out.println("    automatically and it would change the first letter ");
        System.out.println("    of every word to upper case.");
    }
    
    /**
     * Rewrite student name in a specific format.
     * @parma name  The string to be rewritten.
     * @Return the name which has been rewritten.
     */
    public String nameFormat(String name)
    {
        String[] nameArray = name.replaceAll(" +", " ").split(" ");
        StringBuffer nameStringBuffer = new StringBuffer("");
        for(int i = 0; i < nameArray.length; i++)
            nameStringBuffer.append(firstLetterUpperCase(nameArray[i]) + " ");
        String formattedName = nameStringBuffer.toString().trim();
        return formattedName;
    }
}