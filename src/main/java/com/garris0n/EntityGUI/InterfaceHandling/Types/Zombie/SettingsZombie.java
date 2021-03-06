package com.garris0n.EntityGUI.InterfaceHandling.Types.Zombie;

import com.garris0n.EntityGUI.GUI.GUIItemStack;
import com.garris0n.EntityGUI.GUI.Runnables.GUIRunnable;
import com.garris0n.EntityGUI.GUI.Runnables.NormalClickType;
import com.garris0n.EntityGUI.InterfaceHandling.SettingsAgeable;
import com.garris0n.EntityGUI.Main;
import com.garris0n.EntityGUI.Util.EZItemStack;
import com.garris0n.EntityGUI.Util.Util;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class SettingsZombie extends SettingsAgeable{

    private boolean villager = false;

    public boolean getVillager(){

        return villager;

    }

    public void setVillager(boolean villager){

        this.villager = villager;

    }

    @Override
    public void draw(GUIItemStack[] items){

        super.draw(items);

        items[20] = new GUIItemStack(new EZItemStack(Material.MONSTER_EGG, 1, (short) 120)
                .name(Util.redGreen(villager) + "Villager")
                .lore(ChatColor.DARK_PURPLE + "Click to toggle."),
                new GUIRunnable(){

                    @Override
                    public void click(Player player, NormalClickType type, boolean shift){

                        if(Main.interfaceHandler.getPageType(player) != null)
                            ((SettingsZombie) Main.interfaceHandler.getSettings(player)).setVillager(!((SettingsZombie) Main.interfaceHandler.getSettings(player)).getVillager());
                        Main.interfaceHandler.reDraw(player);

                    }

                    @Override
                    public void doubleClick(Player player){}

                    @Override
                    public void numberKeyClick(Player player, int key){}
                });

    }

}
