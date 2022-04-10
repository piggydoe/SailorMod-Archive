package base.gui.hud.mod.impl;

import java.io.IOException;
import org.lwjgl.input.Keyboard;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.GuiScreen;

public final class WDR extends GuiScreen
{
    private GuiTextField username;
    
    @Override
    protected void actionPerformed(final GuiButton button) {
        if (button.id == 0) {
            this.mc.thePlayer.sendChatMessage("/report " + this.username.getText());
        }
    }
    
    @Override
    public void drawScreen(final int x2, final int y2, final float z2) {
        final ScaledResolution sr = new ScaledResolution(this.mc);
        this.username.drawTextBox();
        Gui.drawCenteredString(this.mc.fontRendererObj, "Report Player", (float)(int)(this.width / 2.0f), (float)(sr.getScaledHeight() / 2 - 65), -1);
        super.drawScreen(x2, y2, z2);
    }
    
    @Override
    public void initGui() {
        final ScaledResolution sr = new ScaledResolution(this.mc);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 50, this.height / 2 - 20, 98, 20, I18n.format("Send Report", new Object[0])));
        (this.username = new GuiTextField(100, this.fontRendererObj, this.width / 2 - 50, sr.getScaledHeight() / 2 - 50, 100, 20)).setFocused(true);
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
        if (character == '\t' && !this.username.isFocused()) {
            this.username.setFocused(true);
        }
        if (character == '\r') {
            this.actionPerformed(this.buttonList.get(0));
        }
        this.username.textboxKeyTyped(character, key);
    }
    
    @Override
    protected void mouseClicked(final int x2, final int y2, final int button) {
        try {
            super.mouseClicked(x2, y2, button);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.username.mouseClicked(x2, y2, button);
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    public void updateScreen() {
        this.username.updateCursorCounter();
    }
}
