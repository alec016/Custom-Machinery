package fr.frinn.custommachinery.json_schema.recipe.requirements;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ButtonRequirement extends Requirement {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private String id;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean inverse;
}
