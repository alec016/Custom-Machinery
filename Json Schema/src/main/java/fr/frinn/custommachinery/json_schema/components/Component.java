package fr.frinn.custommachinery.json_schema.components;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.ArrayList;
import java.util.List;

@JsonSubTypes({
  @JsonSubTypes.Type(value = ChunkLoadComponent.class, name = "custommachinery:chunkload"),
  @JsonSubTypes.Type(value = EnergyComponent.class, name = "custommachinery:energy"),
  @JsonSubTypes.Type(value = ExperienceComponent.class, name = "custommachinery:experience"),
  @JsonSubTypes.Type(value = FluidComponent.class, name = "custommachinery:fluid")
})
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.EXISTING_PROPERTY,
  property = "type"
)
public class Component {
}
