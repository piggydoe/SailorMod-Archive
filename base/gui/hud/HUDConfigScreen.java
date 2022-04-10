package base.gui.hud;

import java.io.IOException;

import base.Client;
import base.gui.clickgui.ClickGUI;
import base.gui.hud.mod.HudMod;
import base.gui.hud.mod.impl.WDR;
import base.gui.hud.mod.impl.Waypoint;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class HUDConfigScreen extends GuiScreen{
	
	@Override
	public void initGui() {
		
		super.initGui();
		this.buttonList.add(new GuiButton(6340, this.width / 2 - 50, this.height / 2 - 10, 100, 20, "ClickGUI"));
		this.buttonList.add(new GuiButton(6969, this.width / 2 - 50, this.height / 2 + 20, 100, 20, "Report A Player"));
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		for(HudMod m : Client.INSTANCE.hudManager.hudMods) {
				m.renderDummy(mouseX, mouseY);
			
		}
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		// TODO Auto-generated method stub
		super.actionPerformed(button);
		switch(button.id) {
		case 6340:
				mc.displayGuiScreen(new ClickGUI());
		}
		switch(button.id) {
		case 6969:
				mc.displayGuiScreen(new WDR());
		}
		switch(button.id) {
		case 4209:
				mc.displayGuiScreen(new Waypoint());
		}
	}
}
