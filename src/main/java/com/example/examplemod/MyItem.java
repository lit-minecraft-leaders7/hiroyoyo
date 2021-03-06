package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;

/**
 * Created by k014c1139 on 2016/02/11.
 */
public class MyItem extends ItemSword {

    public MyItem(){
        super(EnumHelper.addToolMaterial("Original_Sword", 4, 2000, 16.0f, 1.0f,  22));
        setTextureName(ExampleMod.MODID + ":Original_Sword");
        setTextureName(ExampleMod.MODID + "Original_Sword");
    }

    @Override
    public boolean hitEntity(ItemStack item, EntityLivingBase enemy, EntityLivingBase attacker){

        if(item == null){
            return true;
        }

        if(!(attacker instanceof EntityPlayer)){
            return true;
        }

        enemy.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1200, 1));
        return true;
    }
}
