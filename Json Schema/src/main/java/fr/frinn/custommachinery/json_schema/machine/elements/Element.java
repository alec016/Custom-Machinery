package fr.frinn.custommachinery.json_schema.machine.elements;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import fr.frinn.custommachinery.json_schema.Init;
import fr.frinn.custommachinery.json_schema.utils.Tooltip;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import java.util.List;

@JsonSubTypes({
  @JsonSubTypes.Type(value = BarElement.class, name = "custommachinery:bar"),
  @JsonSubTypes.Type(value = ButtonElement.class, name = "custommachinery:button"),
  @JsonSubTypes.Type(value = ConfigElement.class, name = "custommachinery:config"),
  @JsonSubTypes.Type(value = DumpElement.class, name = "custommachinery:dump"),
  @JsonSubTypes.Type(value = EnergyElement.class, name = "custommachinery:energy"),
  @JsonSubTypes.Type(value = ExperienceElement.class, name = "custommachinery:experience"),
  @JsonSubTypes.Type(value = FluidElement.class, name = "custommachinery:fluid"),
  @JsonSubTypes.Type(value = FuelElement.class, name = "custommachinery:fuel"),
  @JsonSubTypes.Type(value = PlayerInventoryElement.class, name = "custommachinery:player_inventory"),
  @JsonSubTypes.Type(value = ProgressBarElement.class, name = "custommachinery:progress"),
  @JsonSubTypes.Type(value = ResetElement.class, name = "custommachinery:reset"),
  @JsonSubTypes.Type(value = SizeElement.class, name = "custommachinery:size"),
  @JsonSubTypes.Type(value = SlotElement.class, name = "custommachinery:slot"),
  @JsonSubTypes.Type(value = StatusElement.class, name = "custommachinery:status"),
  @JsonSubTypes.Type(value = TextElement.class, name = "custommachinery:text"),
  @JsonSubTypes.Type(value = TextureElement.class, name = "custommachinery:texture"),
  // ADDONS
  // botania
  @JsonSubTypes.Type(value = ManaElement.class, name = "custommachinery:mana"),
  // ars
  @JsonSubTypes.Type(value = SourceElement.class, name = "custommachinery:source"),
  // mekanism
  @JsonSubTypes.Type(value = GasElement.class, name = "custommachinery:gas"),
  @JsonSubTypes.Type(value = InfusionElement.class, name = "custommachinery:infusion"),
  @JsonSubTypes.Type(value = PigmentElement.class, name = "custommachinery:pigment"),
  @JsonSubTypes.Type(value = SlurryElement.class, name = "custommachinery:slurry"),
  @JsonSubTypes.Type(value = HeatElement.class, name = "custommachinery:heat"),
})
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.EXISTING_PROPERTY,
  property = "type"
)
public abstract class Element {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  @Min(0)
  private int x;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  @Min(0)
  private int y;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(-1)
  private int width;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(-1)
  private int height;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private int priority;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private List<Tooltip> tooltips;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = Init.RL)
  private String texture;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = Init.RL)
  private String textureHovered;
}
