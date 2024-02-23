package fr.frinn.custommachinery.json_schema.recipe.requirements;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import fr.frinn.custommachinery.json_schema.Init;
import fr.frinn.custommachinery.json_schema.utils.DropAction;
import fr.frinn.custommachinery.json_schema.utils.RequirementIOMode;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import java.util.List;
import java.util.Objects;

public class DropRequirement extends Requirement {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private RequirementIOMode mode;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private DropAction action;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private List<@Pattern(regexp = "#?" + Init.RL) Input> input;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean whitelist;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = Init.RL)
  private String output;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @JsonSubTypes({
    @JsonSubTypes.Type(String.class),
    @JsonSubTypes.Type(Object.class)
  })
  private Object nbt;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(1)
  private int amount;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(1)
  private int radius;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(0)
  @Max(1)
  private double chance;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(0)
  @Max(1)
  private double delay;

  private static class Item extends Input {
    @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
    @Pattern(regexp = Init.RL)
    private String item;
  }

  private static class ItemTag extends Input {
    @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
    @Pattern(regexp = "#?" + Init.RL)
    private String tag;
  }

  @JsonSubTypes({
    @JsonSubTypes.Type(Item.class),
    @JsonSubTypes.Type(ItemTag.class),
    @JsonSubTypes.Type(String.class)
  })
  private static class Input { }
}
