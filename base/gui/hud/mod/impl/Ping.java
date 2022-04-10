package base.gui.hud.mod.impl;

import java.awt.Color;

import base.gui.hud.mod.HudMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

//authors: eric golde/quickdaffy


public class Ping extends HudMod{
	
	//§

	public Ping() {
		super("Ping", 895, 492);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw() {
		
		 Gui.drawRect(this.getX() - 1, this.getY() - 1, this.getX() + 55, this.getY() + this.getHeight(), new Color(0, 0, 0, 170).getRGB());
		 if (mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID()) != null) {
	            fr.drawStringWithShadow("§6[§ePing§6] §f" + mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID()).getResponseTime(), getX() + 1, getY() + 1, -1);
	        } else {
	            fr.drawStringWithShadow("§6[§ePing§6] §f0", getX() + 1, getY() + 1, -1);
	        }
	     super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		Gui.drawRect(this.getX() - 1, this.getY() - 1, this.getX() + 60, this.getY() + this.getHeight(), new Color(0, 0, 0, 170).getRGB());
		if (mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID()) != null) {
            fr.drawStringWithShadow("§6[§ePing§6] §f" + mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID()).getResponseTime(), getX() + 1, getY() + 1, -1);
        } else {
            fr.drawStringWithShadow("§6[§ePing§6] §f0", getX() + 1, getY() + 1, -1);
        }
        super.renderDummy(mouseX, mouseY);
}
	
	
	@Override
	public int getWidth() {
		return fr.getStringWidth("[Ping] 100");
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}

}

