package fr.frinn.custommachinery.json_schema.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import fr.frinn.custommachinery.json_schema.Init;
import jakarta.validation.constraints.Pattern;

@JsonSubTypes({
  @JsonSubTypes.Type(Ingredient.ItemIngredient.class),
  @JsonSubTypes.Type(Ingredient.TagIngredient.class)
})
public class Ingredient {
  public static class ItemIngredient {
    @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
    private I item;
  }
  public static class TagIngredient {
    @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
    @Pattern(regexp = Init.RL)
    private String tag;
  }

  private static class I {
    @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
    @Pattern(regexp = Init.RL)
    private String item;
  }
}
