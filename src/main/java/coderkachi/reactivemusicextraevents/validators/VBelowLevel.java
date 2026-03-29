package coderkachi.reactivemusicextraevents.validators;

import coderkachi.reactivemusicextraevents.RMExtrasContext;
import coderkachi.reactivemusicextraevents.RMExtrasValidator;
import coderkachi.reactivemusicextraevents.RMExtrasValue;

public class VBelowLevel implements RMExtrasValidator 
{
    @Override
    public boolean validate(RMExtrasValue value, RMExtrasContext context)
    {
        return context.playerPosition.getY() < (value.intValue != null ? value.intValue : 55);
    }
}