package fr.frinn.custommachinery.json_schema;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.victools.jsonschema.generator.Option;
import com.github.victools.jsonschema.generator.OptionPreset;
import com.github.victools.jsonschema.generator.SchemaGenerator;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfigBuilder;
import com.github.victools.jsonschema.generator.SchemaVersion;
import com.github.victools.jsonschema.module.jackson.JacksonModule;
import com.github.victools.jsonschema.module.jackson.JacksonOption;
import com.github.victools.jsonschema.module.jakarta.validation.JakartaValidationModule;
import com.github.victools.jsonschema.module.jakarta.validation.JakartaValidationOption;
import fr.frinn.custommachinery.json_schema.machine.Machine;
import fr.frinn.custommachinery.json_schema.machine.UpgradedMachine;
import fr.frinn.custommachinery.json_schema.recipe.CraftRecipe;
import fr.frinn.custommachinery.json_schema.recipe.MachineRecipe;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Init {
  public static final String RL = "[a-z]+[a-z|_]*[a-z]:[a-z]+[a-z|_|/|#|,|=|\\.]*[a-z]$";

  public static void main (String[] args) {
    JacksonModule jacksonModule = new JacksonModule(JacksonOption.RESPECT_JSONPROPERTY_REQUIRED);
    JakartaValidationModule jakartaModule = new JakartaValidationModule(JakartaValidationOption.INCLUDE_PATTERN_EXPRESSIONS);
    SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(
      SchemaVersion.DRAFT_2020_12,
      OptionPreset.PLAIN_JSON
    )
      .with(jacksonModule)
      .with(jakartaModule)
      .with(Option.EXTRA_OPEN_API_FORMAT_VALUES)
      .with(Option.FLATTENED_ENUMS_FROM_TOSTRING);

    SchemaGenerator generator;
    try {
      String schemaDir = System.getProperty("user.dir") + "/Json Schema/src/main/resources/schemas/";
      File dir = new File(schemaDir);
      if (!dir.exists() && dir.mkdirs()) System.out.println("schema directory created");
      BufferedWriter writer;

      System.out.println("===================== Machine =====================");
      configBuilder.forTypesInGeneral()
        .withIdResolver(scope -> scope.getType().getErasedType() == Machine.class
          ? "https://alec016.github.io/Custom-Machinery/Json%20Schema/src/main/resources/schemas/machine.json"
          : null
        ).withDescriptionResolver(scope -> scope.getType().getErasedType() == Machine.class
          ? "CustomMachinery machine json schema definition"
          : null
        ).withTitleResolver(scope -> scope.getType().getErasedType() == Machine.class
          ? "CustomMachinery Machine"
          : null
        );
      generator = new SchemaGenerator(configBuilder.build());
      JsonNode machineSchema = generator.generateSchema(Machine.class);
      System.out.println(machineSchema.toPrettyString());
//      writer = new BufferedWriter(new FileWriter(schemaDir + "machine.json"));
//      writer.write(machineSchema.toPrettyString());
//      writer.flush();

      System.out.println("===================== Upgraded Machine =====================");
      configBuilder.forTypesInGeneral()
        .withIdResolver(scope -> scope.getType().getErasedType() == UpgradedMachine.class
          ? "https://alec016.github.io/Custom-Machinery/Json%20Schema/src/main/resources/schemas/upgraded_machine.json"
          : null
        ).withDescriptionResolver(scope -> scope.getType().getErasedType() == UpgradedMachine.class
          ? "CustomMachinery upgraded machine json schema definition"
          : null
        ).withTitleResolver(scope -> scope.getType().getErasedType() == UpgradedMachine.class
          ? "CustomMachinery Upgraded Machine"
          : null
        );
      generator = new SchemaGenerator(configBuilder.build());
      JsonNode upgradedMachineSchema = generator.generateSchema(UpgradedMachine.class);
      System.out.println(upgradedMachineSchema.toPrettyString());
//      writer = new BufferedWriter(new FileWriter(schemaDir + "upgraded_machine.json"));
//      writer.write(upgradedMachineSchema.toPrettyString());
//      writer.flush();

      System.out.println("===================== Craft Recipe =====================");
      configBuilder.forTypesInGeneral()
        .withIdResolver(scope -> scope.getType().getErasedType() == CraftRecipe.class
          ? "https://alec016.github.io/Custom-Machinery/Json%20Schema/src/main/resources/schemas/craft_recipe.json"
          : null
        ).withDescriptionResolver(scope -> scope.getType().getErasedType() == CraftRecipe.class
          ? "CustomMachinery Craft recipe json schema definition"
          : null
        ).withTitleResolver(scope -> scope.getType().getErasedType() == CraftRecipe.class
          ? "CustomMachinery Craft Recipe"
          : null
        );
      generator = new SchemaGenerator(configBuilder.build());
      JsonNode craftRecipeSchema = generator.generateSchema(CraftRecipe.class);
      System.out.println(craftRecipeSchema.toPrettyString());
      writer = new BufferedWriter(new FileWriter(schemaDir + "craft_recipe.json"));
      writer.write(craftRecipeSchema.toPrettyString());
      writer.flush();

      System.out.println("===================== Machine Recipe =====================");
      configBuilder.forTypesInGeneral()
        .withIdResolver(scope -> scope.getType().getErasedType() == MachineRecipe.class
          ? "https://alec016.github.io/Custom-Machinery/Json%20Schema/src/main/resources/schemas/machine_recipe.json"
          : null
        ).withDescriptionResolver(scope -> scope.getType().getErasedType() == MachineRecipe.class
          ? "CustomMachinery Machine recipe json schema definition"
          : null
        ).withTitleResolver(scope -> scope.getType().getErasedType() == MachineRecipe.class
          ? "CustomMachinery Machine Recipe"
          : null
        );
      generator = new SchemaGenerator(configBuilder.build());
      JsonNode machineRecipeSchema = generator.generateSchema(MachineRecipe.class);
      System.out.println(machineRecipeSchema.toPrettyString());
      writer = new BufferedWriter(new FileWriter(schemaDir + "machine_recipe.json"));
      writer.write(machineRecipeSchema.toPrettyString());
      writer.flush();
    } catch (Exception e) {
      System.out.println(e + "");
    }
  }
}
