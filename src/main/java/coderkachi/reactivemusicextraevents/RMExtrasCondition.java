package coderkachi.reactivemusicextraevents;

public class RMExtrasCondition
{
    public final String key;
    public final RMExtrasValue value;
    public final RMExtrasValidator validator;

    public RMExtrasCondition(String key, String rawValue, RMExtrasValidator validator)
    {
        this.key = key;
        this.value = new RMExtrasValue(rawValue);
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