package coderkachi.reactivemusicextraevents;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.world.GameMode;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/// PURPOSE
/// Cache expensive calculations
/// Hold common lookups for things like ClientPlayerEntity, World, etc
/// 
/// TO DO
/// Storing the number of HostileMobs nearby.
public class RMExtrasContext
{
    long slowTickRate = 20;
    long currentSlowTick = 0;

    public ClientPlayerEntity player;
    public World world;

    public GameMode playerGamemode = GameMode.DEFAULT;
    public BlockPos playerPosition = new BlockPos(0, 0, 0);
    public boolean playerIsUnderground = false;

    public void update(MinecraftClient client)
    {
        this.currentSlowTick++;
        this.player = client.player;
        this.world = client.world;

        if (this.player == null || this.world == null ) return;

        if (this.currentSlowTick > this.slowTickRate)
        {
            this.slowUpdate(client);
            this.currentSlowTick = 0;
        }
    }

    private void slowUpdate(MinecraftClient client)
    {
        this.playerPosition = new BlockPos(player.getBlockPos());
        this.playerIsUnderground = !world.isSkyVisible(this.playerPosition);
        this.playerGamemode = client.interactionManager.getCurrentGameMode();
    }
}
