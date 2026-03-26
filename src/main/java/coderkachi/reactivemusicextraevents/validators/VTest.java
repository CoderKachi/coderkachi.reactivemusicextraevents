package coderkachi.reactivemusicextraevents.validators;

import coderkachi.reactivemusicextraevents.RMExtrasValidator;

public class VTest implements RMExtrasValidator 
{
    @Override
    public boolean validate(String value)
    {
        if (value == null) return true;
        int intValue = Integer.parseInt(value);
        return intValue == 1;
    }
}
