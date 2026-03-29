package coderkachi.reactivemusicextraevents;

public class RMExtrasValue
{
    public final String stringValue;
    public final Integer intValue;
    public final Float floatValue;
    public final Boolean boolValue;

    public RMExtrasValue(String rawValue)
    {
        this.stringValue = rawValue;

        Integer tryInt = null;
        Float tryFloat = null;
        Boolean tryBool = null;

        if (rawValue != null)
        {
            try {tryInt = Integer.parseInt(rawValue); } catch (Exception exception) {}
            try {tryFloat = Float.parseFloat(rawValue); } catch (Exception exception) {}
            try {tryBool = Boolean.parseBoolean(rawValue); } catch (Exception exception) {} 
        }

        this.intValue = tryInt;
        this.floatValue = tryFloat;
        this.boolValue = tryBool;
    }
}
