package fr.frinn.custommachinery.json_schema.components;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonSubTypes({
  @JsonSubTypes.Type(value = ChunkLoadComponent.class, name = "custommachinery:chunkload"),
  @JsonSubTypes.Type(value = EnergyComponent.class, name = "custommachinery:energy"),
  @JsonSubTypes.Type(value = ExperienceComponent.class, name = "custommachinery:experience"),
  @JsonSubTypes.Type(value = FluidComponent.class, name = "custommachinery:fluid"),
  @JsonSubTypes.Type(value = ItemComponent.class, name = "custommachinery:item"),
  @JsonSubTypes.Type(value = RedstoneComponent.class, name = "custommachinery:redstone")
})
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.EXISTING_PROPERTY,
  property = "type"
)
public class Component {
}
