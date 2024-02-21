package fr.frinn.custommachinery.json_schema.elements;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import fr.frinn.custommachinery.json_schema.components.ChunkLoadComponent;
import fr.frinn.custommachinery.json_schema.components.EnergyComponent;
import java.util.ArrayList;
import java.util.List;

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
  @JsonIgnore
  static List<Element> elements = new ArrayList<>();

  public static List<Element> create() {
    if (!elements.isEmpty()) return elements;
    return elements;
  }
}
