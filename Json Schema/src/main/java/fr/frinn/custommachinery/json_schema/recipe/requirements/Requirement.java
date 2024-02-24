package fr.frinn.custommachinery.json_schema.recipe.requirements;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonSubTypes({
  @JsonSubTypes.Type(value = BiomeRequirement.class, name = "custommachinery:biome"),
  @JsonSubTypes.Type(value = BlockRequirement.class, name = "custommachinery:block"),
  @JsonSubTypes.Type(value = ButtonRequirement.class, name = "custommachinery:button"),
  @JsonSubTypes.Type(value = ChunkloadRequirement.class, name = "custommachinery:chunkload"),
  @JsonSubTypes.Type(value = CommandRequirement.class, name = "custommachinery:command"),
  @JsonSubTypes.Type(value = DimensionRequirement.class, name = "custommachinery:dimension"),
  @JsonSubTypes.Type(value = DropRequirement.class, name = "custommachinery:drop"),
  @JsonSubTypes.Type(value = DurabilityRequirement.class, name = "custommachinery:durability"),
  @JsonSubTypes.Type(value = EffectRequirement.class, name = "custommachinery:effect"),
  @JsonSubTypes.Type(value = EnergyPerTickRequirement.class, name = "custommachinery:energy_per_tick"),
  @JsonSubTypes.Type(value = EnergyRequirement.class, name = "custommachinery:energy"),
  @JsonSubTypes.Type(value = EntityRequirement.class, name = "custommachinery:entity"),
  @JsonSubTypes.Type(value = ExperienceRequirement.class, name = "custommachinery:experience"),
  @JsonSubTypes.Type(value = ExperiencePerTickRequirement.class, name = "custommachinery:experience_per_tick"),
  @JsonSubTypes.Type(value = FluidRequirement.class, name = "custommachinery:fluid"),
  @JsonSubTypes.Type(value = FluidPerTickRequirement.class, name = "custommachinery:fluid_per_tick"),
  @JsonSubTypes.Type(value = FuelRequirement.class, name = "custommachinery:fuel"),
  @JsonSubTypes.Type(value = ItemFilterRequirement.class, name = "custommachinery:item_filter"),
  @JsonSubTypes.Type(value = ItemRequirement.class, name = "custommachinery:item"),
  @JsonSubTypes.Type(value = ItemTransformRequirement.class, name = "custommachinery:item_transform"),
  @JsonSubTypes.Type(value = LightRequirement.class, name = "custommachinery:light"),
  // ADDONS
})
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.EXISTING_PROPERTY,
  property = "type"
)
public abstract class Requirement {
}
