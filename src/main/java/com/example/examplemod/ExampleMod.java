package com.example.examplemod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerBlock(new MyBlock(), "myblock");

        customSword();
    }

    public void customSword(){
        Item sword = new MyItem();
        GameRegistry.registerItem(sword, "my_sword");

        GameRegistry.addRecipe(new ItemStack(sword, 1, 50),
                " B ",
                "BAB",
                "B",
                'A',new ItemStack(Items.diamond_sword),
                'B',Items.gunpowder );
    }
}
