package fr.frinn.custommachinery.json_schema.recipe.requirements;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.frinn.custommachinery.json_schema.utils.EntityAction;
import fr.frinn.custommachinery.json_schema.utils.RequirementIOMode;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class EntityRequirement extends Requirement {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private RequirementIOMode mode;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private EntityAction action;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private int amount;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private int radius;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(0)
  @Max(1)
  private double delay;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(0)
  @Max(1)
  private double chance;
}
