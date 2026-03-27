package coderkachi.reactivemusicextraevents;

import java.util.*;

public class RMExtrasRegistry
{
    private static final Map<String, RMExtrasValidator> registry = new HashMap<>();
    private static final List<RMExtrasTickable> tickables = new ArrayList<>();

    /// TO DO
    /// Add a context holder (RMExtrasContext) to cache expensive calculations on a tick basis, not a validator basis
    /// It should also hold common lookups for things like MinecraftClient, ClientPlayerEntity and World
    /// EXAMPLE
    /// Storing the number of HostileMobs nearby.

    public static void register(String key, RMExtrasValidator validator)
    {
        System.out.println("[Reactive Music: Extra Events] Registered extra event: " + key);
        registry.put(key.toLowerCase(), validator);

        if (validator instanceof RMExtrasTickable tickable)
        {
            tickables.add(tickable);
        }
    }

    public static RMExtrasValidator getValidator(String key)
    {
        return registry.get(key.toLowerCase());
    }

    /// TO DO
    /// Look making RMExtrasTickable store an internal tickCount and tickRate value
    /// then add incrementTickCounter(), when tickCount >= tickRate allow .tick() to be called
    /// WHY
    /// To allow tickables to fine control how often they tick for performance
    public static void updateTickables()
    {
        for (RMExtrasTickable tickable : tickables)
        {
            tickable.tick();
        }
    }
}
