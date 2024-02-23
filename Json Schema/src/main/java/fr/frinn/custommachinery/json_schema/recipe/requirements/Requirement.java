package fr.frinn.custommachinery.json_schema.recipe.requirements;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonSubTypes({
  @JsonSubTypes.Type(value = BiomeRequirement.class, name = "custommachinery:biome"),
  @JsonSubTypes.Type(value = BlockRequirement.class, name = "custommachinery:block"),
  @JsonSubTypes.Type(value = ButtonRequirement.class, name = "custommachinery:button"),
  @JsonSubTypes.Type(value = ChunkloadRequirement.class, name = "custommachinery:chunkload"),
  @JsonSubTypes.Type(value = CommandRequirement.class, name = "custommachinery:command"),
  // ADDONS
})
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.EXISTING_PROPERTY,
  property = "type"
)
public abstract class Requirement {
}
