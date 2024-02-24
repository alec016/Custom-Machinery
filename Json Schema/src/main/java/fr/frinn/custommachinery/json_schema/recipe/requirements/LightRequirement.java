package fr.frinn.custommachinery.json_schema.recipe.requirements;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import jakarta.validation.constraints.Pattern;

public class LightRequirement extends Requirement {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  @JsonPropertyDescription("see https://frinn.gitbook.io/custom-machinery-1.19/misc/range for valid ranges")
  private String light;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean sky;
}
