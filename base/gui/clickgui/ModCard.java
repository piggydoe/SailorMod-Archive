package base.gui.clickgui;

import java.awt.Color;

import base.gui.hud.mod.HudMod;
import base.util.ui.RoundedUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class ModCard {
	
	public int x;
    public int y;
    public int w;
    public int h;
    public int outlineColor;
    public int xPosition;
    public int yPosition;
    public static Minecraft mc;
    public HudMod m;
    
    
    
    public ModCard(final int x, final int y, final int w, final int h, final HudMod m) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.m = m;
        
    }
	
	
	
	
	private void draw() {
		
		RoundedUtils.drawRoundedRect(200, 200, 200+200, 200+200, 5, -1);
		Minecraft.getMinecraft().fontRendererObj.drawString(this.m.name, this.x + 2, this.y + 2, -1);

	}

}
