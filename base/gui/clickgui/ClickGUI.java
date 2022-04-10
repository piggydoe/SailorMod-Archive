package base.gui.clickgui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import base.Client;
import base.gui.ClientPage;
import base.gui.clickgui.screen.CombatScreen;
import base.gui.clickgui.screen.WorldScreen;
import base.gui.hud.mod.HudMod;
import base.util.font.FontUtil;
import base.util.ui.GuiCheckBox;
import base.util.ui.ImageButton;
import base.util.ui.RoundedUtils;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class ClickGUI extends GuiScreen{
	
	ArrayList<ModButton> modButtons = new ArrayList<>();
	ArrayList<ModCard> modCard = new ArrayList<>();
	public ClientPage clientPage;
	public HudMod m;
	public ToggleButton toggleButton;
	

	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ScaledResolution sr = new ScaledResolution(mc);
		RoundedUtils.drawSmoothRoundedRect(200, 50, sr.getScaledWidth() - 200, sr.getScaledHeight() - 50, 20, new Color(22,23,26,240).getRGB());
		
		//Gui.drawRect(200, 50, sr.getScaledWidth() - 200, sr.getScaledHeight() - 50, new Color(54,57,63,255).getRGB());
		drawVerticalLine(278, sr.getScaledHeight() - 50, 49, new Color(255,255,254,255).getRGB());
		GlStateManager.pushMatrix();
        GlStateManager.translate(0.0f, 0.0f, 0.0f);
        GlStateManager.scale(2.0f, 2.0f, 1.0f);
        GlStateManager.translate(-14.0f, 0.0f, 0.0f);
        FontUtil.normal.drawCenteredString(Client.INSTANCE.NAME + " GUI", 260, 30.0f, -1);
        
        GlStateManager.popMatrix();
		for(ModButton m : modButtons) {
			m.draw();
		}
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
		
		mc.entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
		
		this.buttonList.add(new ImageButton(100, 207, 60, 65, new ResourceLocation("client/buttons/client-button.png")));
		this.buttonList.add(new ImageButton(0, 207, 140, 65, new ResourceLocation("client/buttons/combat-button.png")));
		this.buttonList.add(new ImageButton(1, 207, 220, 65, new ResourceLocation("client/buttons/world-button.png")));
		
		
		super.initGui();
		this.modButtons.add(new ModButton(320, 125, 65, mc.fontRendererObj.FONT_HEIGHT + 5, Client.INSTANCE.hudManager.testMod));
		this.modButtons.add(new ModButton(475, 125, 65, mc.fontRendererObj.FONT_HEIGHT + 5, Client.INSTANCE.hudManager.fps));
		this.modButtons.add(new ModButton(630, 125, 65, mc.fontRendererObj.FONT_HEIGHT + 5, Client.INSTANCE.hudManager.sessionInfo));
		/*this.modButtons.add(new ModButton(210, 60, 65, mc.fontRendererObj.FONT_HEIGHT + 5, Client.INSTANCE.hudManager.testMod));
		this.modButtons.add(new ModButton(280, 60, 65, mc.fontRendererObj.FONT_HEIGHT + 5, Client.INSTANCE.hudManager.targetHud));
		this.modButtons.add(new ModButton(350, 60, 65, mc.fontRendererObj.FONT_HEIGHT + 5, Client.INSTANCE.hudManager.fps));
		this.modButtons.add(new ModButton(420, 60, 65, mc.fontRendererObj.FONT_HEIGHT + 5, Client.INSTANCE.hudManager.keystrokes));
		this.modButtons.add(new ModButton(420, 60, 65, mc.fontRendererObj.FONT_HEIGHT + 5, Client.INSTANCE.hudManager.xyz));
		this.modButtons.add(new ModButton(420, 60, 65, mc.fontRendererObj.FONT_HEIGHT + 5, Client.INSTANCE.hudManager.potStatus));
		this.modButtons.add(new ModButton(420, 60, 65, mc.fontRendererObj.FONT_HEIGHT + 5, Client.INSTANCE.hudManager.potCounter));
		this.modButtons.add(new ModButton(420, 60, 65, mc.fontRendererObj.FONT_HEIGHT + 5, Client.INSTANCE.hudManager.ping));*/
	}
	
	@Override
	public void onGuiClosed() {
		mc.entityRenderer.loadEntityShader(null);
        super.onGuiClosed();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException{
	if(button.id == 0) {
		mc.displayGuiScreen(new CombatScreen());
	}
	if(button.id == 1) {
		mc.displayGuiScreen(new WorldScreen());
	}
	if(button.id == 100) {
		mc.displayGuiScreen(new ClickGUI());
		
		
	}
	super.actionPerformed(button);
	}
	
	
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		// TODO Auto-generated method stub
		super.mouseClicked(mouseX, mouseY, mouseButton);
		for(ModButton m : modButtons) {
			m.onClick(mouseX, mouseY, mouseButton);
		}
	}

}
