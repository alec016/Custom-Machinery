package fr.frinn.custommachinery.json_schema.recipe.requirements;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.frinn.custommachinery.json_schema.Init;
import fr.frinn.custommachinery.json_schema.utils.BlockAction;
import fr.frinn.custommachinery.json_schema.utils.ComparatorMode;
import fr.frinn.custommachinery.json_schema.utils.RequirementIOMode;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.List;

public class BlockRequirement extends Requirement {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private RequirementIOMode mode;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private BlockAction action;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  @Size.List({@Size(min = 3, max = 3), @Size(min = 6, max = 6)})
  private List<Double> pos;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(1)
  private int amount;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private ComparatorMode comparator;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = Init.RL)
  private String block;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private List<@Pattern(regexp = "#?" + Init.RL) String> filter;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean whitelist;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(0)
  @Max(1)
  private double delay;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(0)
  @Max(1)
  private double chance;
}
