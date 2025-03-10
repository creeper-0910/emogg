package io.github.aratakileo.emogg.gui.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public abstract class AbstractScreen extends Screen {
    protected net.minecraft.client.gui.screens.Screen parent;

    protected AbstractScreen(Component component, net.minecraft.client.gui.screens.Screen parent) {
        super(component);
        this.parent = parent;
    }

    protected AbstractScreen(Component component) {
        super(component);
        this.parent = Minecraft.getInstance().screen;
    }

    @Override
    public void onClose() {
        Minecraft.getInstance().setScreen(parent);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float dt) {
        renderBackground(guiGraphics);
        guiGraphics.drawCenteredString(font, title, width / 2, 15, 0xffffff);
        super.render(guiGraphics, mouseX, mouseY, dt);
    }

    public int horizontalCenter() {
        return width / 2;
    }

    public int verticalCenter() {
        return height / 2;
    }
}
