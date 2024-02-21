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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Init {
  public static final String RL = "[a-z]+[a-z|_]*[a-z]:[a-z]+[a-z|_|/|#|,|=]*[a-z]$";

  public static void main (String[] args) {
    JacksonModule jacksonModule = new JacksonModule(JacksonOption.RESPECT_JSONPROPERTY_REQUIRED);
    JakartaValidationModule jakartaModule = new JakartaValidationModule(JakartaValidationOption.INCLUDE_PATTERN_EXPRESSIONS);
    SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(
      SchemaVersion.DRAFT_2020_12,
      OptionPreset.PLAIN_JSON
    )
      .with(jacksonModule)
      .with(jakartaModule)
      .with(Option.EXTRA_OPEN_API_FORMAT_VALUES);

    SchemaGenerator generator = new SchemaGenerator(configBuilder.build());
    JsonNode machineSchema = generator.generateSchema(Machine.class);
    try {
      String schemaDir = System.getProperty("user.dir") + "/Json Schema/src/main/resources/schemas/";
      File dir = new File(schemaDir);
      if (!dir.exists() && dir.mkdirs()) System.out.println("schema directory created");
      System.out.println("===================== Machine =====================");
      System.out.println(machineSchema.toPrettyString());
      BufferedWriter writer = new BufferedWriter(new FileWriter(schemaDir + "machine.json"));
      writer.write(machineSchema.toPrettyString());
      writer.flush();
    } catch (Exception e) {
      System.out.println(e + "");
    }
  }
}
