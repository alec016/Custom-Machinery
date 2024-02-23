package fr.frinn.custommachinery.json_schema.recipe;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.frinn.custommachinery.json_schema.utils.AppearanceBuilder;
import jakarta.validation.constraints.Min;

public class MachineRecipe extends Recipe {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  @Min(1)
  private int time;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean error;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private AppearanceBuilder appearance;
}
