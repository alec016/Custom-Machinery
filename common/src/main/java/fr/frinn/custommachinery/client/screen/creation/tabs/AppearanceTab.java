package fr.frinn.custommachinery.client.screen.creation.tabs;

import fr.frinn.custommachinery.client.screen.creation.AppearanceList;
import fr.frinn.custommachinery.client.screen.creation.MachineEditScreen;
import fr.frinn.custommachinery.common.machine.builder.MachineAppearanceBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.layouts.GridLayout;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.network.chat.Component;

public class AppearanceTab extends MachineEditTab {

    private final CycleButton<MachineAppearanceBuilder> builderButton;
    private final AppearanceList appearanceList;

    public AppearanceTab(MachineEditScreen parent) {
        super(Component.translatable("custommachinery.gui.creation.tab.appearance"), parent);
        GridLayout.RowHelper row = this.layout.createRowHelper(1);
        this.builderButton = row.addChild(new CycleButton.Builder<MachineAppearanceBuilder>(builder -> builder.getStatus() == null ? Component.literal("Default") : builder.getStatus().getTranslatedName())
                .withValues(parent.getBuilder().getAppearanceBuilders())
                .displayOnlyValue()
                .create(0, 0, 100, 20, Component.literal("Machine status"), (button, value) -> this.initList()), row.newCellSettings().alignHorizontallyCenter().alignVerticallyTop());
        this.appearanceList = new AppearanceList(Minecraft.getInstance(), parent.x, parent.y + 50, parent.xSize, parent.ySize - 60, 30, this.builderButton::getValue, this.parent);
    }

    public void initList() {
        this.appearanceList.init();
    }

    @Override
    public void doLayout(ScreenRectangle rectangle) {
        super.doLayout(rectangle);
        this.appearanceList.resize(this.parent.x, this.parent.y + 50, this.parent.xSize, this.parent.ySize - 60);
    }

    @Override
    public void opened() {
        this.parent.addRenderableWidget(this.appearanceList);
    }

    @Override
    public void closed() {
        this.parent.removeWidget(this.appearanceList);
    }
}
