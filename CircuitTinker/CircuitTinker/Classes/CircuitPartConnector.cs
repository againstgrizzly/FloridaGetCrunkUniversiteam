using System;
//System.Collections.Generic contains the List class.
using System.Collections.Generic;

public class CircuitPartConnector
{
    //ParentPart: CircuitPart that the connector is associated with if applicable
    public CircuitPart ParentPart;
    //Connectors: List of other CircuitPartConnectors this is connected with
    public List<CircuitPartConnector> Connectors;

	public CircuitPartConnector(Object parent = null)
	{
        ParentPart = parent;
        Connectors = new List<CircuitPartConnector>();
	}

    public bool Connect(CircuitPartConnector new_connector)
    {
        if (!General.IsInList(new_connector, Connectors))
        {
            Connectors.Add(new_connector);
            return true;
        }
        return false;
    }

    public bool Disconnect(CircuitPartConnector new_connector)
    {
        if (General.IsInList(new_connector, Connectors))
        {
            Connectors.Remove(new_connector);
            return true;
        }
        return false;
    }
}