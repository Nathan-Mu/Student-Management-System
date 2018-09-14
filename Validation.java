import java.util.ArrayList;
/**
 * A class of validation.
 * 
 * @author Dongyu Zhao
 * @version 1.0 08 Oct 2013
 */
public class Validation
{
    /**
     * Constructor for objects of class Validation
     */
    public Validation()
    {
    }
    
    /**
     * Determine whether the input string is in name format.
     * @parma stringCheck 
     * @Return true if the the string is in name format.
     */
    public boolean isName(String stringCheck)
    {
        if (stringCheck.trim().matches("[a-zA-Z\\s]+") && stringCheck.trim().contains(" "))
            return true;
        return false;
    }
    
    /**
     * Determine whether the input string is numeric.
     * @parma stringCheck 
     * @Return true if the the string is numeric.
     */
    public boolean isNumeric(String stringCheck)
    {
        if (stringCheck.isEmpty())
            return false;
        else
        {
            for (int i = 0; i < stringCheck.length(); i++)
            {
                if (!Character.isDigit(stringCheck.charAt(i)) || stringCheck.isEmpty())
                    return false;
            }
            return true;
        }
    }
    
    /**
     * Determine whether the input string is in subject format.
     * @parma stringCheck 
     * @Return true if the the string is in subject format.
     */
    public boolean isSubjects(String[] arrayCheck)
    {
        if (!isUnique(arrayCheck))
            return false;
        else
        {
            for (int i = 0; i < arrayCheck.length; i++)
            {
                if (!arrayCheck[i].trim().equalsIgnoreCase("English") && !arrayCheck[i].trim().equalsIgnoreCase("Computing") && !arrayCheck[i].trim().equalsIgnoreCase("Maths"))
                    return false;
            }
            return true;
        }
    }
    
    /**
     * Determine whether the input string is in telephone format.
     * @parma stringCheck 
     * @Return true if the the string is in telephone format.
     */
    public boolean isTelephone(String stringCheck)
    {
        if (isNumeric(stringCheck) && stringCheck.length() == 9 && stringCheck.charAt(0) == '9')
            return true;
        else
            return false;
    }

    /**
     * Determine whether the components of string array is unique.
     * @parma check
     * @Return true if the components of string array is unique.
     */
    public boolean isUnique(String[] check)
    {
        ArrayList<String> checkArrayList = new ArrayList<String>();
        for (int i = 0; i < check.length; i++)
        {
            if (checkArrayList.contains(check[i]))
                return false;
            else
                checkArrayList.add(check[i]);
        }
        return true;
    }
}