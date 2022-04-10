package base.gui.clickgui;

import java.awt.Color;

import base.gui.hud.mod.HudMod;
import base.util.ui.RoundedUtils;

public class ToggleButton {
	
	public int x;
    public int y;
    public int w;
    public int h;
    public HudMod m;
    public int xPosition;
    public int yPosition;
    
    public ToggleButton(final int x, final int y, final int w, final int h, final HudMod m) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.m = m;
    }
	
	public void ToggleButtonEnabled() {
	        RoundedUtils.drawRoundedRect(this.x + this.w - 40, this.y + y - 2, this.x + this.w - 20, this.y + y + 6, 5, new Color(114, 137, 218, 255).getRGB());
	        RoundedUtils.drawRoundedRect(this.x + this.w - 30, this.y + y - 2,
	                this.x + this.w - 20, this.y + y + 6, 5, new Color(255, 255, 255, 255).getRGB());

	    // OUTLINE
	        RoundedUtils.drawRoundedOutline(this.x + 140, this.y + y - 8, this.x + this.w - 10,
	                this.y + y + 13 + this.yPosition, 10, 1, new Color(73, 131, 245, 255).getRGB());
	
	        
	}
	public void ToggleButtonDisabled() {
		RoundedUtils.drawRoundedRect(this.x + this.w - 40, this.y + y - 2,
                this.x + this.w - 20, this.y + y + 6, 5, new Color(114, 118, 125, 255).getRGB());
        RoundedUtils.drawRoundedRect(this.x + this.w - 40, this.y + y - 2,
                this.x + this.w - 30, this.y + y + 6, 5, new Color(255, 255, 255, 255).getRGB());
	}
}
