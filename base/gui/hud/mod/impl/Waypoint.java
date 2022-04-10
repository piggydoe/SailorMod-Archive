package base.gui.hud.mod.impl;

import java.io.File;
import java.io.IOException;
import org.lwjgl.input.Keyboard;

import base.util.config.Config;
import base.util.config.Configuration;
import base.util.config.ConfigurationAPI;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.GuiScreen;

public final class Waypoint extends GuiScreen
{
	
	public Config config;
	public Configuration configToSave = ConfigurationAPI.newConfiguration(new File("Client/Mods/ModConfiguration.clientwaypoints"));
    private GuiTextField coords;
    
    @Override
    protected void actionPerformed(final GuiButton button) {
    	
    	config = new Config();
    	
    	configToSave.set(" xyz", this.coords.getText());
    	
        if (button.id == 0) {
        	
        	try {
    			configToSave.save();
    		} catch (IOException e) {
    			
    			e.printStackTrace();
    			System.out.println("Mod Config Save Failed");
    		}
        	
        	
        }
        
        if (button.id == 1) {
        	
        	IChatComponent chatComponent = new ChatComponentText(this.coords.getText());
            (mc.thePlayer).addChatMessage(chatComponent);
        	
        	
        }
    }
    
    @Override
    public void drawScreen(final int x2, final int y2, final float z2) {
        final ScaledResolution sr = new ScaledResolution(this.mc);
        this.coords.drawTextBox();
        Gui.drawCenteredString(this.mc.fontRendererObj, "Add A Waypoint", (float)(int)(this.width / 2.0f), (float)(sr.getScaledHeight() / 2 - 65), -1);
        super.drawScreen(x2, y2, z2);
    }
    
    @Override
    public void initGui() {
        final ScaledResolution sr = new ScaledResolution(this.mc);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 50, this.height / 2 - 20, 98, 20, I18n.format("Create Waypoint", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 50, this.height / 2 + 10, 98, 20, I18n.format("List Waypoints", new Object[0])));
        (this.coords = new GuiTextField(100, this.fontRendererObj, this.width / 2 - 50, sr.getScaledHeight() / 2 - 50, 100, 20)).setFocused(true);
       
        
        Keyboard.enableRepeatEvents(true);
    }
    
    @Override
    protected void keyTyped(final char character, final int key) {
        try {
            super.keyTyped(character, key);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (character == '\t' && !this.coords.isFocused()) {
            this.coords.setFocused(true);
        }
        if (character == '\r') {
            this.actionPerformed(this.buttonList.get(0));
        }
        this.coords.textboxKeyTyped(character, key);
    }
    
    @Override
    protected void mouseClicked(final int x2, final int y2, final int button) {
        try {
            super.mouseClicked(x2, y2, button);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.coords.mouseClicked(x2, y2, button);
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    public void updateScreen() {
        this.coords.updateCursorCounter();
    }
}

