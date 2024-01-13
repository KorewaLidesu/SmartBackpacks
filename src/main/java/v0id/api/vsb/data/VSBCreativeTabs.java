package v0id.api.vsb.data;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import v0id.vsb.Tags;

import javax.annotation.Nonnull;

public class VSBCreativeTabs
{
    public static final CreativeTabs TAB_VSB = new CreativeTabs(Tags.MOD_ID)
    {
        @Override
        @Nonnull
        public ItemStack createIcon()
        {
            return new ItemStack(VSBItems.BASIC_BACKPACK);
        }
    };
}
