package base;

import org.lwjgl.opengl.Display;

import base.discord.DiscordRP;
import base.event.EventManager;
import base.event.EventTarget;
import base.event.impl.ClientTick;
import base.gui.clickgui.ClickGUI;
import base.gui.hud.HUDConfigScreen;
import base.gui.hud.mod.HudManager;
import base.mod.ModManager;
import base.util.SessionChanger;
import base.util.config.Config;
import base.util.font.FontUtil;
import net.minecraft.client.Minecraft;

public class Client {
	public String NAME = "SailorMod", VERSION = "B4", NAMEVER = NAME + " " + VERSION;
	public static Client INSTANCE = new Client();
	public Minecraft mc = Minecraft.getMinecraft();
	
	public EventManager eventManager;
	public Config config;
	public HudManager hudManager;
	public ModManager modManager;
	public DiscordRP discordRP;
	
	
	public void startup() {
		
		eventManager = new EventManager();
		(this.config = new Config()).loadModConfig();
		hudManager = new HudManager();
		modManager = new ModManager();
		discordRP = new DiscordRP();
		
		discordRP.start();
	

		FontUtil.bootstrap();
		
		System.out.println("Starting up base client " + NAMEVER);
		Display.setTitle(Client.INSTANCE.NAME + " | " + VERSION + " | by" + " Piggydoe");
		EventManager.register(this);
		//SessionChanger.getInstance().setUserMicrosoft("@gmail.com", "");
		
	}
	
	public void shutdown() {
		System.out.println("Shutting down client " + NAMEVER);
		config.saveModConfig();
		EventManager.unregister(this);
		discordRP.shutdown();
	}
	
	public DiscordRP getRP() {
		return discordRP;
	}
	
	@EventTarget
	public void onTick(ClientTick event) {
		if(mc.gameSettings.HUD.isPressed()) {
			mc.displayGuiScreen(new HUDConfigScreen());
		}
		if (this.mc.gameSettings.keyBindInventory.isPressed()) {
            this.modManager.toggleSprint.toggle();
        }
		if(this.mc.gameSettings.FULL_BRIGHT.isPressed()) {
			this.modManager.fullBright.toggle();
		}
		
	}

}
