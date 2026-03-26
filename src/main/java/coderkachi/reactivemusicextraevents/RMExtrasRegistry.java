package coderkachi.reactivemusicextraevents;

import java.util.*;

public class RMExtrasRegistry
{
    private static final Map<String, RMExtrasValidator> registry = new HashMap<>();

    public static void register(String key, RMExtrasValidator validator)
    {
        registry.put(key.toLowerCase(), validator);
    }

    public static RMExtrasValidator getValidator(String key)
    {
        return registry.get(key.toLowerCase());
    }
}
