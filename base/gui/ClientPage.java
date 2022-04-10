package base.gui;

import java.awt.Color;
import java.io.IOException;

import base.Client;
import base.gui.clickgui.ClickGUI;
import base.util.ui.ImageButton;
import base.util.ui.RoundedUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class ClientPage extends GuiScreen {
	
	public int cape1 = 0;
	public int cape2 = 1;
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		mc.getTextureManager().bindTexture(new ResourceLocation("client/sailor-small-logo.png"));
		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
		
		//Gui.drawRect(this.width - 100, 450, 100, this.height - 10, new Color(0,0,0,170).getRGB());
		RoundedUtils.drawRoundedRect(245, 420, 300 + 420, 300 + 215, 15, new Color(0,0,0,140).getRGB());
		
		/*
		
		GlStateManager.pushMatrix();
		//GlStateManager.translate(width/2f, height/2f, 0);
		GlStateManager.scale(3, 3, 1);
		//GlStateManager.translate(-(width/2f), -(height/2f), 0);
		//this.drawCenteredString(mc.fontRendererObj, "§3<§b" + Client.INSTANCE.NAME + "§3/>", 160, height/2-180, 0x55FFFF);
		GlStateManager.popMatrix();*/
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	@Override
	public void initGui() {
		ScaledResolution sr = new ScaledResolution(mc);
		
		//this.buttonList.add(new GuiButton(1, 380, height / 2 + 173, "Singleplayer"));
		//this.buttonList.add(new GuiButton(2, 380, height / 2 + 195, "Multiplayer"));
		//this.buttonList.add(new GuiButton(3, 45, height / 2 + 195, "Settings"));
		//this.buttonList.add(new GuiButton(4, 715, height / 2 + 195, "Exit Game"));
		
		this.buttonList.add(new ImageButton(3, this.width / 2 - 225, height / 2 + 160, 75, new ResourceLocation("client/buttons/settings-button.png")));
		this.buttonList.add(new ImageButton(2, this.width / 2 - 130, height / 2 + 160, 75, new ResourceLocation("client/buttons/multiplayer-button.png")));
		this.buttonList.add(new ImageButton(0, this.width / 2 - 35, height / 2 + 160, 75, new ResourceLocation("client/buttons/client-button.png")));
		this.buttonList.add(new ImageButton(1, this.width / 2 + 60, height / 2 + 160, 75, new ResourceLocation("client/buttons/singleplayer-button.png")));
		this.buttonList.add(new ImageButton(4, this.width / 2 + 155, height / 2 + 160, 75, new ResourceLocation("client/buttons/exitgame-button.png")));
		//this.buttonList.add(new GuiButtonAnimated(1, 10, height / 2 - 40, "Singleplayer"));
		
		super.initGui();
	}
	@Override
	protected void actionPerformed(GuiButton button) throws IOException{
		if(button.id == 1) {
			mc.displayGuiScreen(new GuiSelectWorld(this));
	}
	if(button.id == 2) {
		mc.displayGuiScreen(new GuiMultiplayer(this));
	}
	if(button.id == 3) {
		mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
	}
	if(button.id == 4) {
		mc.shutdown();
	}
	if(button.id == 0) {
	}
	
	super.actionPerformed(button);
	}
}