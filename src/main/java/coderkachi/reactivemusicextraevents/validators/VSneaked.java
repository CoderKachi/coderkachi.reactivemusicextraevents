package coderkachi.reactivemusicextraevents.validators;

import coderkachi.reactivemusicextraevents.RMExtrasTickable;
import coderkachi.reactivemusicextraevents.RMExtrasValidator;
import coderkachi.reactivemusicextraevents.RMExtrasContext;

/// A example of a Tickable Validator
/// isValid is true when the player has sneaked in the last x seconds
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
    public boolean validate(String value, RMExtrasContext context)
    {
        if (context.world == null || lastSneakTick < 0) return false;
        
        int durationTicks;

        try
        {
            durationTicks = Integer.parseInt(value) * 20;
        }
        catch (NumberFormatException exception)
        {
            durationTicks = 60; // (3 seconds)
        }

        long tickSince = context.world.getTime() - lastSneakTick;
        return tickSince <= durationTicks;
    }
}
