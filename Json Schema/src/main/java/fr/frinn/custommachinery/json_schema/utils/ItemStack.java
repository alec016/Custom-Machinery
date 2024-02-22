package fr.frinn.custommachinery.json_schema.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.frinn.custommachinery.json_schema.Init;
import jakarta.validation.constraints.Pattern;

public class ItemStack {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private String id;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private int Count;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = "#?" + Init.RL)
  private String tag;
}
