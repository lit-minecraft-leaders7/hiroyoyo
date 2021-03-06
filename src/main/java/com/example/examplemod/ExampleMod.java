package com.example.examplemod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.minecart.MinecartCollisionEvent;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";
    public static final Block RAINBOW = new RainbowBlock();
    public static final Block blocksound = new BlockSound();
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerBlock(new MyBlock(), "myblock");
        GameRegistry.addShapelessRecipe(new ItemStack(RAINBOW), new ItemStack(Blocks.dirt));
        GameRegistry.registerBlock(blocksound, "BlockSound");

        MinecraftForge.EVENT_BUS.register(new BlockBreakEventHandler());


        customSword();
        customFood();

        GameRegistry.registerBlock(new BlockRedstoneInput(), "redstone_input");
        GameRegistry.registerBlock(new BlockRedstoneClock(), "redstone_clock");
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

    public void customFood(){

        PotionEffect[] onigiri ={
                new PotionEffect(Potion.regeneration.id, 1200, 1),
                new PotionEffect(Potion.damageBoost.id, 1200, 1),
                new PotionEffect(Potion.moveSpeed.id, 1200, 1),
                new PotionEffect(Potion.jump.id, 600, 1)
        };
        GameRegistry.registerItem(new ItemModFood("Onigiri", 1, 0.5f, false, onigiri).setAlwaysEdible(), "Onigiri");
    }
}
