package fr.frinn.custommachinery.json_schema.recipe.requirements;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import fr.frinn.custommachinery.json_schema.utils.Ingredient;

public class ItemFilterRequirement {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  @JsonAlias("item")
  @JsonSubTypes({
    @JsonSubTypes.Type(Ingredient.class),
    @JsonSubTypes.Type(Ingredient[].class)
  })
  private Ingredient[] ingredient;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private String slot;
}
