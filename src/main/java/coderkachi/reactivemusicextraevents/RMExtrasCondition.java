package coderkachi.reactivemusicextraevents;

public class RMExtrasCondition
{
    public final String key;
    public final String value;
    public final RMExtrasValidator validator;

    public RMExtrasCondition(String key, String value, RMExtrasValidator validator)
    {
        this.key = key;
        this.value = value;
        this.validator = validator;
    }

    /// TO DO
    /// Create an object that holds the parsed version of a value, e.g.
    /// RMExtrasValue.intValue
    /// RMExtrasValue.boolValue
    /// RMExtrasValue.stringValue
    /// Then Validators won't need to constantly do things like "Integer.parseInt(value)"

    public boolean evaluate()
    {
        return validator.validate(value, RMExtrasRegistry.getContext());
    }
}