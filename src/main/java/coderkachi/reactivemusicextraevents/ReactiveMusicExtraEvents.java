package coderkachi.reactivemusicextraevents;

import coderkachi.reactivemusicextraevents.validators.VTest;

public class ReactiveMusicExtraEvents implements RMExtrasEntryPoint
{
    @Override
    public void registerExtras()
    {
        System.out.println("[Reactive Music: Extra Events] Registering my events!");

        // Testing entries with no values
        RMExtrasRegistry.register("testa", value -> 
        {
            // We don't care about any values passed to this event
            return true;
        });

        // Testing entries with a value
        RMExtrasRegistry.register("testb", value -> 
        {
            if (value == null) return false;
            int intValue = Integer.parseInt(value);
            return intValue == 1;
        });

        // Testing validator object from a dedicated class
        RMExtrasRegistry.register("testc", new VTest());
    }
}