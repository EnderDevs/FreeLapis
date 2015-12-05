package com.enderdevs.freelapis;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.material.Dye;
import org.bukkit.plugin.java.JavaPlugin;

public class FreeLapis extends JavaPlugin{

	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(new Listener(){

			@EventHandler
			public void onOpen(InventoryOpenEvent e){
				if(e.getInventory().getType().equals(InventoryType.ENCHANTING)){
					Dye dye = new Dye();
					dye.setColor(DyeColor.BLUE);
					e.getInventory().setItem(1, dye.toItemStack(10));
				}
			}

			@EventHandler
			public void onClick(InventoryClickEvent e){
				if(e.getInventory().getType().equals(InventoryType.ENCHANTING)){
					if(e.getSlot() == 1) e.setCancelled(true);
				}
			}

			@EventHandler
			public void onEnchant(EnchantItemEvent e){
				Dye dye = new Dye();
				dye.setColor(DyeColor.BLUE);
				e.getInventory().setItem(1, dye.toItemStack(10));
			}

		}, this);
	}

}
