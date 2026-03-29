package coderkachi.reactivemusicextraevents.validators;

import coderkachi.reactivemusicextraevents.RMExtrasContext;
import coderkachi.reactivemusicextraevents.RMExtrasValidator;
import coderkachi.reactivemusicextraevents.RMExtrasValue;

import net.minecraft.world.GameMode;

import java.util.HashSet;
import java.util.Set;

public class VGamemode implements RMExtrasValidator
{
    private final Set<String> invalidStrings = new HashSet<>();

    @Override
    public boolean validate(RMExtrasValue value, RMExtrasContext context)
    {
        if (context.player == null || context.world == null) return false;

        String tryString = value.stringValue.toUpperCase();
        GameMode targetGamemode;

        try
        {
            targetGamemode = GameMode.valueOf(tryString);
        }
        catch (Exception exception)
        {
            if (invalidStrings.add(tryString))
            {
                System.out.println("[VGamemode] " + tryString + " isn't a gamemode that exists!");
            }
            return false;
        }

        return targetGamemode == context.playerGamemode;
    }
}
