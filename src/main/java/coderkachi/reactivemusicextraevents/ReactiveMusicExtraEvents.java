package coderkachi.reactivemusicextraevents;

import coderkachi.reactivemusicextraevents.validators.VSneaked;
import coderkachi.reactivemusicextraevents.validators.VAboveLevel;
import coderkachi.reactivemusicextraevents.validators.VBelowLevel;
import coderkachi.reactivemusicextraevents.validators.VGamemode;
import coderkachi.reactivemusicextraevents.validators.VOvergroundLevel;
import coderkachi.reactivemusicextraevents.validators.VUndergroundLevel;

public class ReactiveMusicExtraEvents implements RMExtrasEntryPoint
{
    @Override
    public void registerExtras()
    {
        System.out.println("[Reactive Music: Extra Events] Registering my events!");

        RMExtrasRegistry.register("sneaked", new VSneaked());

        RMExtrasRegistry.register("abovelevel", new VAboveLevel());
        RMExtrasRegistry.register("belowlevel", new VBelowLevel());
        RMExtrasRegistry.register("overgroundlevel", new VOvergroundLevel());
        RMExtrasRegistry.register("undergroundlevel", new VUndergroundLevel());

        RMExtrasRegistry.register("gamemode", new VGamemode());
    }
}