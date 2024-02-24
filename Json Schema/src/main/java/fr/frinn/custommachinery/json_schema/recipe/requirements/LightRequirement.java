package fr.frinn.custommachinery.json_schema.recipe.requirements;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;

public class LightRequirement extends Requirement {
  public static final String INT_RANGE = "[[\\[|\\(]?]\\d+,?\\d[\\]|\\)]+]|\\d|\\*|]";
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  @Pattern(regexp = INT_RANGE)
  private String light;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean sky;
}
