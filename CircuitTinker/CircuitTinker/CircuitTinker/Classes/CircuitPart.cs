using System;
//System.Collections.Generic contains the List class.
using System.Collections.Generic;

public class CircuitPart
{
    //Connectors: List of CircuitPartConnectors attached to this CircuitPart
    public List<CircuitPartConnector> Connectors;
    //ConsumptionRate: This is the power consumed in watts by this circuit part, if applicable
    public float ConsumptionRate;
	public CircuitPart(float cr = 0.0f)
	{
        Connectors = new List<CircuitPartConnector>();
        ConsumptionRate = cr;
	}
}

public class Switch : CircuitPart
{
    public bool switch_on;
    public Switch(bool s = false)
    {
        switch_on = s;
    }

    public void Toggle()
    {
        switch_on = !switch_on;
    }
}

public class Resistor : CircuitPart
{
    public float resistance;
    public Resistor(float r = 1000)
    {
        resistance = r;
    }
}

public class LED : CircuitPart
{
    public List<string> Colors;
    public string ActiveColor;
    public LED()
    {

    }
    //ChangeColor: returns boolean for whether or not it successfully
    //changed the color (if the color was found in the list of options)
    //Accepts an integer (key) or a string (value)
    //Both arguments are optional, n takes priority
    public bool ChangeColor(int n = -1, string s = "")
    {
        if (n >= 0 && n < Colors.Count)
        {
            ActiveColor = Colors[n];
            return true;
        }
        else if (s.CompareTo("") != 0)
        {
            if (General.IsInList(s, Colors))
            {
                ActiveColor = s;
                return true;
            }
        }
        return false;
    }
}

public class Sensor : CircuitPart
{
    //threshold: This is the threshold which the detected value must exceed
    //for the sensor to have a high output
    public float threshold;
    //activated: whether or not the sensor is currently emitting high output
    public bool activated;
    public Sensor()
    {
        threshold = 0.0f;
        activated = false;
    }
}

public class TemperatureSensor : Sensor
{
    //Custom constructor: default threshold set to 50 degrees celsius
    public TemperatureSensor(float t = 50.0f)
    {
        //always store temp in SI units: Celsius
        if (General.TemperatureUnit != 'c')
        {
            threshold = General.ConvertTemp(t, General.TemperatureUnit);
        }
        else
        {
            threshold = t;
        }
        activated = false;
    }
}

public class LightSensor : Sensor
{
    //Custom constructor: default threshold set to 1000 lumens
    public LightSensor(float t = 1000.0f)
    {
        threshold = t;
    }
}