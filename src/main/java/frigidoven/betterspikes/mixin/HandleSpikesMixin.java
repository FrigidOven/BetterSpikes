package frigidoven.betterspikes.mixin;

import net.minecraft.core.block.BlockSpikes;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.core.entity.Entity;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static turniplabs.halplibe.HalpLibe.LOGGER;

@Mixin(value = BlockSpikes.class, remap = false)
public abstract class HandleSpikesMixin {
	@Inject(
		method = "Lnet/minecraft/core/block/BlockSpikes;onEntityCollidedWithBlock(Lnet/minecraft/core/world/World;IIILnet/minecraft/core/entity/Entity;)V",
		at = @At("HEAD"),
		cancellable = true,
		remap = false
	)
	private void handleSpikesAlternative(World world, int x, int y, int z, Entity entity, CallbackInfo ci) {
		int metaData = world.getBlockMetadata(x, y, z);
		if (BlockSpikes.isSpikesUp(metaData) && entity instanceof EntityLiving) {
			if (entity.fallDistance > 1.5F) {
				entity.hurt((Entity)null, MathHelper.floor_double((double)entity.fallDistance) * 2 + 1, DamageType.COMBAT);
				entity.stuck = true;
			} else if (!entity.isSneaking()) {
				entity.hurt((Entity)null, 1, DamageType.COMBAT);
			}
		}
		ci.cancel();
	}
}
