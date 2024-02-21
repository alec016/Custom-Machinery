package fr.frinn.custommachinery.json_schema.elements;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonSubTypes({
//  @JsonSubTypes.Type(value = ChunkLoadComponent.class, name = "custommachinery:chunkload"),
//  @JsonSubTypes.Type(value = EnergyComponent.class, name = "custommachinery:energy")
})
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.EXISTING_PROPERTY,
  property = "type"
)
public class Element {
}
