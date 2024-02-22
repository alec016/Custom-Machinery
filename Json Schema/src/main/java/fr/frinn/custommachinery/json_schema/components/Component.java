package fr.frinn.custommachinery.json_schema.components;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonSubTypes({
  @JsonSubTypes.Type(value = ChunkLoadComponent.class, name = "custommachinery:chunkload"),
  @JsonSubTypes.Type(value = EnergyComponent.class, name = "custommachinery:energy"),
  @JsonSubTypes.Type(value = ExperienceComponent.class, name = "custommachinery:experience"),
  @JsonSubTypes.Type(value = FluidComponent.class, name = "custommachinery:fluid"),
  @JsonSubTypes.Type(value = ItemComponent.class, name = "custommachinery:item"),
  @JsonSubTypes.Type(value = RedstoneComponent.class, name = "custommachinery:redstone"),
  // addons
  // botania
  @JsonSubTypes.Type(value = ManaComponent.class, name = "custommachinery:mana"),
  // ars
  @JsonSubTypes.Type(value = SourceComponent.class, name = "custommachinery:source"),
  // mekanism
  @JsonSubTypes.Type(value = GasComponent.class, name = "custommachinery:gas"),
  @JsonSubTypes.Type(value = InfusionComponent.class, name = "custommachinery:infusion"),
  @JsonSubTypes.Type(value = PigmentComponent.class, name = "custommachinery:pigment"),
  @JsonSubTypes.Type(value = SlurryComponent.class, name = "custommachinery:slurry"),
  @JsonSubTypes.Type(value = HeatComponent.class, name = "custommachinery:heat"),
  // create
  @JsonSubTypes.Type(value = ContraptionComponent.class, name = "custommachinery:contraption")
})
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.EXISTING_PROPERTY,
  property = "type"
)
public class Component {
}
