package base.gui.hud.mod.impl;

import java.awt.Color;

import base.Client;
import base.gui.hud.mod.HudMod;
import base.util.font.FontUtil;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.item.EntityItemFrame;

public class SessionInfo extends HudMod{
	
	EntityLivingBase target;

	public SessionInfo() {
		super("Session Info", 857, 56);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw() {
		Gui.drawRect(getX(),getY() - 10, getX() + 100, getY() + 33, new Color(0, 0, 0,210).getRGB());
		FontUtil.normal.drawSmoothString(mc.thePlayer.getName(), getX() + FontUtil.normal.getStringWidth(mc.thePlayer.getName()) - 44, getY() - 5, -1);
		FontUtil.normal.drawSmoothString("SailorMod " + Client.INSTANCE.VERSION, getX() + FontUtil.normal.getStringWidth("SailorMod " + Client.INSTANCE.VERSION) - 45, getY() + 8, -1);
		FontUtil.normal.drawSmoothString("1.8.9", getX() + FontUtil.normal.getStringWidth("1.8.9") + 20, getY() + 20, -1);
		//Gui.drawRect(getX()-2, getY()-2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 0/*170*/).getRGB());
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		
		Gui.drawRect(getX(),getY() - 10, getX() + 100, getY() + 33, new Color(0,0,0,190).getRGB());
		
		
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return 100;
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT * 2 + 4;
	}
	
	
}
