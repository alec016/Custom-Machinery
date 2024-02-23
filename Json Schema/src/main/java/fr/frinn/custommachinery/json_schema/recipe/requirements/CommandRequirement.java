package fr.frinn.custommachinery.json_schema.recipe.requirements;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.frinn.custommachinery.json_schema.utils.Phase;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class CommandRequirement extends Requirement {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private String command;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private Phase phase;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private int permissionlevel;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean log;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(0)
  @Max(1)
  private double chance;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(0)
  @Max(1)
  private double delay;
}
