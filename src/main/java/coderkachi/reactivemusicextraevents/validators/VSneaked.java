package coderkachi.reactivemusicextraevents.validators;

import coderkachi.reactivemusicextraevents.RMExtrasTickable;
import coderkachi.reactivemusicextraevents.RMExtrasValidator;
import coderkachi.reactivemusicextraevents.RMExtrasValue;
import coderkachi.reactivemusicextraevents.RMExtrasContext;

/// An example of a Tickable Validator
/// isValid is true when the player has sneaked in the last [Integer] seconds
public class VSneaked implements RMExtrasValidator, RMExtrasTickable 
{
    boolean isValid = false;
    boolean printed = false;

    private long lastSneakTick = -1;

    @Override
    public void tick(RMExtrasContext context)
    {
        if (context.player == null || context.world == null) return;

        if (context.player.isSneaking())
        {
            lastSneakTick = context.world.getTime();
        }
    }

    @Override
    public boolean validate(RMExtrasValue value, RMExtrasContext context)
    {
        if (context.world == null || lastSneakTick < 0) return false;
        
        int durationTicks = value.intValue != null ? value.intValue * 20 : 60; /// (3 seconds by default)

        long tickSince = context.world.getTime() - lastSneakTick;
        return tickSince <= durationTicks;
    }
}
