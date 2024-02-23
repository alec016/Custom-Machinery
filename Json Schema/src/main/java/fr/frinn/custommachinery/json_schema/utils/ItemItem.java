package fr.frinn.custommachinery.json_schema.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.frinn.custommachinery.json_schema.Init;
import jakarta.validation.constraints.Pattern;

public class ItemItem extends Item {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  @Pattern(regexp = Init.RL)
  private String item;
}
