package coderkachi.reactivemusicextraevents;

import net.minecraft.client.MinecraftClient;

import java.util.*;

public class RMExtrasRegistry
{
    private static final Map<String, RMExtrasValidator> registry = new HashMap<>();
    private static final List<RMExtrasTickable> tickables = new ArrayList<>();
    private static final RMExtrasContext context = new RMExtrasContext();

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

    public static void updateTickables(MinecraftClient client)
    {
        context.update(client);

        for (RMExtrasTickable tickable : tickables)
        {
            tickable.tick(context);
        }
    }

    public static RMExtrasContext getContext()
    {
        return RMExtrasRegistry.context;
    }
}
