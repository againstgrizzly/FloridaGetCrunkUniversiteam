using System;
//System.Collections.Generic contains the List class.
using System.Collections.Generic;

//This class is static because there will only ever be one instance of this class; the definition
//It will be used to store objects globally without worrying about duplicating names
//To access a global variable, simply use General.<name>
public static class General
{
    //Note that there is no constructor because this class is never instantiated
    //Window settings
    public static bool BuildMode = true;
    public static bool PlayMode = false;

    //Environment Settings
    //Light measured in lux
    public static float Light = 5000.0f;
    public static char TemperatureUnit = 'c'; //Either c or f, Celsius or Fahrenheit
    public static float Temperature = 60.0f;

    //t is the temperature
    //c is the unit the temperature is in
    public static float ConvertTemp(float t, char c)
    {
        if (c == 'c')
        {
            //if the temperature passed was in celsius, return the
            //equivalent fahrenheit temperature
            return (t * 9 / 5) + 32;
        }
        else
        {
            //we only support Celsius and Fahrenheit, so if the temperature passed is not celsius
            //assume it is fahrenheit and return the equivalent celsius temperature
            return (t - 32) * 5 / 9;
        }
    }
    //returns false if object is not in list
    //This method call accepts a list of circuitparts
    public static bool IsInList(CircuitPart a, List<CircuitPart> list)
    {
        foreach (CircuitPart b in list)
        {
                if (a == b)
                {
                    return true;
                }
        }
        return false;
    }

    //returns false if object is not in list
    //This method call accepts a list of strings
    public static bool IsInList(string a, List<string> list)
    {
        foreach (string b in list)
        {
            if (a == b)
            {
                return true;
            }
        }
        return false;
    }

    //returns false if object is not in list
    //This method call accepts a list of CircuitPartConnectors
    public static bool IsInList(CircuitPartConnector a, List<CircuitPartConnector> list)
    {
        foreach (CircuitPartConnector b in list)
        {
            if (a == b)
            {
                return true;
            }
        }
        return false;
    }
}