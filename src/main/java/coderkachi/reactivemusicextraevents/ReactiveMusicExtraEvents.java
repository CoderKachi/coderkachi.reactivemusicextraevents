package coderkachi.reactivemusicextraevents;

import coderkachi.reactivemusicextraevents.validators.VSneaked;

public class ReactiveMusicExtraEvents implements RMExtrasEntryPoint
{
    @Override
    public void registerExtras()
    {
        System.out.println("[Reactive Music: Extra Events] Registering my events!");

        // Testing validator object from a dedicated class
        RMExtrasRegistry.register("sneaked", new VSneaked());
    }
}