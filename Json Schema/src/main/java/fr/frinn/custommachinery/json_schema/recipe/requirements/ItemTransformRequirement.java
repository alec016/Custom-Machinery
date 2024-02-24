package fr.frinn.custommachinery.json_schema.recipe.requirements;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.frinn.custommachinery.json_schema.Init;
import fr.frinn.custommachinery.json_schema.utils.Item;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public class ItemTransformRequirement extends Requirement {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private Item input;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(1)
  private int input_amount;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private String input_slot;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private Object input_nbt;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = Init.RL)
  private String output;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(1)
  private int output_amount;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private String output_slot;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean copy_nbt;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(0)
  @Max(1)
  private double chance;
}
