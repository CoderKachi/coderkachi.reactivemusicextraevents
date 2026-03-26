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

    public boolean evaluate()
    {
        return validator.validate(value);
    }
}