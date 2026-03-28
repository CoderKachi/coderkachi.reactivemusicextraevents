package coderkachi.reactivemusicextraevents.validators;

import coderkachi.reactivemusicextraevents.RMExtrasContext;
import coderkachi.reactivemusicextraevents.RMExtrasTickable;
import coderkachi.reactivemusicextraevents.RMExtrasValidator;

public class VUndergroundLevel implements RMExtrasValidator, RMExtrasTickable 
{
    @Override
    public void tick(RMExtrasContext context)
    {
        
    }

    @Override
    public boolean validate(String value, RMExtrasContext context)
    {
        return true;
    }
}
