package fr.frinn.custommachinery.common.guielement;

import fr.frinn.custommachinery.CustomMachinery;
import fr.frinn.custommachinery.api.codec.NamedCodec;
import fr.frinn.custommachinery.api.component.MachineComponentType;
import fr.frinn.custommachinery.api.guielement.GuiElementType;
import fr.frinn.custommachinery.api.guielement.IComponentGuiElement;
import fr.frinn.custommachinery.common.component.ItemMachineComponent;
import fr.frinn.custommachinery.common.init.Registration;
import fr.frinn.custommachinery.common.util.GhostItem;
import fr.frinn.custommachinery.impl.guielement.AbstractTexturedGuiElement;
import net.minecraft.resources.ResourceLocation;

public class SlotGuiElement extends AbstractTexturedGuiElement implements IComponentGuiElement<ItemMachineComponent> {

    private static final ResourceLocation BASE_TEXTURE = new ResourceLocation(CustomMachinery.MODID, "textures/gui/base_slot.png");

    public static final NamedCodec<SlotGuiElement> CODEC = NamedCodec.record(slotGuiElementCodec ->
            slotGuiElementCodec.group(
                    makePropertiesCodec(BASE_TEXTURE).forGetter(SlotGuiElement::getProperties),
                    NamedCodec.STRING.fieldOf("id").forGetter(SlotGuiElement::getID),
                    GhostItem.CODEC.optionalFieldOf("ghost", GhostItem.EMPTY).forGetter(element -> element.ghost)
            ).apply(slotGuiElementCodec, SlotGuiElement::new), "Slot gui element"
    );

    private final String id;
    private final GhostItem ghost;

    public SlotGuiElement(Properties properties, String id, GhostItem ghost) {
        super(properties);
        this.id = id;
        this.ghost = ghost;
    }

    @Override
    public GuiElementType<SlotGuiElement> getType() {
        return Registration.SLOT_GUI_ELEMENT.get();
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public MachineComponentType<ItemMachineComponent> getComponentType() {
        return Registration.ITEM_MACHINE_COMPONENT.get();
    }

    public GhostItem getGhost() {
        return this.ghost;
    }
}
