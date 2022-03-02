package shadowmaster435.omnipillars;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import shadowmaster435.omnipillars.block.OmnipillarBase;

public class Omnipillars implements ModInitializer {
    public static final OmnipillarBase QUARTZ = new OmnipillarBase(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).nonOpaque());

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier("omnipillars", "quartzomnipillar"), QUARTZ);
        Registry.register(Registry.ITEM, new Identifier("omnipillars", "quartzomnipillar"), new BlockItem(QUARTZ, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

    }
}
