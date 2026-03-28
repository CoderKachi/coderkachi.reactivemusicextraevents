package coderkachi.reactivemusicextraevents;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.world.World;

/// PURPOSE
/// Cache expensive calculations
/// Hold common lookups for things like ClientPlayerEntity, World, etc
/// 
/// TO DO
/// Storing the number of HostileMobs nearby.
public class RMExtrasContext
{
    public ClientPlayerEntity player;
    public World world;

    public void update(MinecraftClient client)
    {
        this.player = client.player;
        this.world = client.world;
    }
}
