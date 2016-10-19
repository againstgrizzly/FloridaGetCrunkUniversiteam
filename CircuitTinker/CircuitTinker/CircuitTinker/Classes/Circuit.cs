using System;
//System.Collections.Generic contains the List class.
using System.Collections.Generic;

public class Circuit
{
    public List<CircuitPart> CircuitParts;
    //Default constructor which initializes an empty list
    public Circuit()
    {
        CircuitParts = new List<CircuitPart>();
    }
    //Alternative constructor that initializes the list with a part
    public Circuit(CircuitPart c)
    {
        CircuitParts = new List<CircuitPart>();
        CircuitParts.Add(c);
    }
    //returns true if successful / part was not already in list
    public bool Add(CircuitPart c)
    {
        if (!General.IsInList(c, CircuitParts))
        {
            CircuitParts.Add(c);
            return true;
        }
        return false;
    }
    //returns true if successful / part was found in list
    public bool Remove(CircuitPart c)
    {
        if (General.IsInList(c, CircuitParts))
        {
            CircuitParts.Remove(c);
            return true;
        }
        return false;
    }
}