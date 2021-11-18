package toinane.cakeisalie.registry;

import java.lang.reflect.Field;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import toinane.cakeisalie.CakeIsALie;
import toinane.cakeisalie.blocks.FrostedLavaBlock;
import toinane.cakeisalie.utils.Log;

public class ModBlockRegistry {
    public static FrostedLavaBlock frosted_lava = new FrostedLavaBlock();

    public static void registerAll() {
        try {
            for (Field field : ModBlockRegistry.class.getDeclaredFields()) {
                if (!Block.class.isAssignableFrom(field.getType()))
                    return;

                Identifier id = new Identifier(CakeIsALie.MOD_ID, field.getName());

                Registry.register(Registry.BLOCK, id, (Block) field.get(null));
                Registry.register(Registry.ITEM, id, new BlockItem((Block) field.get(null),
                        new Item.Settings().maxCount(1).group(CakeIsALie.CAKEISALIE_GROUP)));

                Log.d("Registered block: " + id);
            }
        } catch (Exception e) {
            Log.printAndPropagate(e);
        }
    }

}
