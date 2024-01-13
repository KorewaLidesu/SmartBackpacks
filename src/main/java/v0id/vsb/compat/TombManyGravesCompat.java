package v0id.vsb.compat;

import com.m4thg33k.tombmanygraves2api.api.ISpecialInventory;
import com.m4thg33k.tombmanygraves2api.api.SpecialInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import v0id.api.vsb.capability.IBackpack;
import v0id.api.vsb.capability.IVSBPlayer;
import v0id.vsb.Tags;
import v0id.vsb.handler.VSBEventHandler;
import v0id.vsb.item.upgrade.UpgradeSoulbound;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpecialInventory(
    id = Tags.MOD_ID,
    name = Tags.MOD_NAME,
    overridable = true,
    reqMod = Tags.MOD_ID
)
public class TombManyGravesCompat implements ISpecialInventory
{
    public TombManyGravesCompat() {
        VSBEventHandler.tmbCompatInitialized = true;
    }

    @Override
    public NBTBase getNbtData(EntityPlayer player)
    {
        IVSBPlayer ivsbPlayer = IVSBPlayer.of(player);
        if (ivsbPlayer != null)
        {
            ItemStack backpack = ivsbPlayer.getCurrentBackpack();
            if (!backpack.isEmpty())
            {
                if (Arrays.stream(IBackpack.of(backpack).createWrapper().getReadonlyUpdatesArray()).anyMatch(w -> w != null && w.getUpgrade() instanceof UpgradeSoulbound))
                {
                    return null;
                }

                return backpack.serializeNBT();
            }
        }

        return null;
    }

    @Override
    public void insertInventory(EntityPlayer player, NBTBase compound, boolean shouldForce)
    {
        if (compound instanceof NBTTagCompound)
        {
            ItemStack backpack = new ItemStack((NBTTagCompound) compound);
            if (IBackpack.of(backpack) != null)
            {
                IVSBPlayer ivsbPlayer = IVSBPlayer.of(player);
                if (ivsbPlayer != null)
                {
                    if (ivsbPlayer.getCurrentBackpack().isEmpty())
                    {
                        ivsbPlayer.setCurrentBackpack(backpack);
                        ivsbPlayer.sync();
                    }
                    else
                    {
                        if (shouldForce)
                        {
                            if (!player.addItemStackToInventory(ivsbPlayer.getCurrentBackpack().copy()))
                            {
                                player.dropItem(ivsbPlayer.getCurrentBackpack().copy(), false);
                            }

                            ivsbPlayer.setCurrentBackpack(backpack);
                            ivsbPlayer.sync();
                        }
                        else
                        {
                            if (!player.addItemStackToInventory(backpack))
                            {
                                player.dropItem(backpack, false);
                            }
                        }
                    }
                }
            }
        }
    }

    @Nonnull
    @Override
    public List<ItemStack> getDrops(NBTBase compound)
    {
        if (compound instanceof NBTTagCompound)
        {
            ItemStack is = new ItemStack((NBTTagCompound) compound);
            if (IBackpack.of(is) != null)
            {
                NonNullList<ItemStack> lst = NonNullList.create();
                lst.add(is);
                return lst;
            }
        }

        return Collections.emptyList();
    }
}
