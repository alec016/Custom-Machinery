package fr.frinn.custommachinery.json_schema.recipe;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.frinn.custommachinery.json_schema.utils.ItemStack;

public class CraftRecipe extends Recipe {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private ItemStack output;
}
