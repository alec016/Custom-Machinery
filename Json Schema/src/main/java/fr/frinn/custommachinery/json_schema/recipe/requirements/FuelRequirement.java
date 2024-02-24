package fr.frinn.custommachinery.json_schema.recipe.requirements;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;

public class FuelRequirement extends Requirement {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(1)
  private int amount;
}
