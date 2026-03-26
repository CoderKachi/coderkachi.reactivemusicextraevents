package coderkachi.reactivemusicextraevents;

public class ReactiveMusicExtraEvents implements RMExtrasEntryPoint
{
    @Override
    public void registerExtras()
    {
        System.out.println("[Reactive Music: Extra Events] Registering my events!");

        RMExtrasRegistry.register("testa", value -> 
        {
            // We don't care about any values passed to this event
            return true;
        });

        RMExtrasRegistry.register("testb", value -> 
        {
            if (value == null) return false;
            int val = Integer.parseInt(value);
            return val == 1;
        });
    }
}