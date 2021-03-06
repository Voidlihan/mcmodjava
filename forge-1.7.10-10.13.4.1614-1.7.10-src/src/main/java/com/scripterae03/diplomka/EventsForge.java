package com.scripterae03.diplomka;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent;

public class EventsForge {
	Minecraft mc;
    EntityPlayer player;
    World world;
	@SubscribeEvent
	public void addDropItem(LivingDropsEvent event) {
		if (!(event.entityLiving instanceof BossEntity)) return; 
		World world = event.entityLiving.worldObj;
		double x = event.entityLiving.posX;      
		double y = event.entityLiving.posY;         
		double z = event.entityLiving.posZ;       
		ItemStack stack = new ItemStack(BaseDiplomka.obsidian_forged_diamond_block, 1);
		ItemStack stack2 = new ItemStack(BaseDiplomka.kumysbucket, 1);
		ItemStack stack3 = new ItemStack(BaseDiplomka.spearofwaterandlava, 1);
		EntityItem item = new EntityItem(world, x, y, z, stack); 
		EntityItem item2 = new EntityItem(world, x, y, z, stack2);
		EntityItem item3 = new EntityItem(world, x, y, z, stack3);
		event.drops.add(item);
		event.drops.add(item2);
		if (world.rand.nextFloat() <= 0.3) event.drops.add(item3);
	}
}
