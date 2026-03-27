package coderkachi.reactivemusicextraevents.validators;

import coderkachi.reactivemusicextraevents.RMExtrasTickable;
import coderkachi.reactivemusicextraevents.RMExtrasValidator;

public class VTest2 implements RMExtrasValidator, RMExtrasTickable 
{
    @Override
    public void tick()
    {
        
    }

    @Override
    public boolean validate(String value)
    {
        if (value == null) return true;
        int intValue = Integer.parseInt(value);
        return intValue == 1;
    }
}
