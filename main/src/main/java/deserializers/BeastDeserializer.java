package deserializers;

import beans.Attack;
import beans.Beast;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Map;

public class BeastDeserializer extends StdDeserializer<Beast> {

    public BeastDeserializer() {
        this(null);
    }

    public BeastDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Beast deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        String name = node.get("name").asText();
        double cr = node.get("cr").doubleValue();
        String size = node.get("size").asText();
        boolean extinct = node.get("extinct") != null && node.get("extinct").asBoolean();
        boolean swarm = node.get("swarm") != null && node.get("swarm").asBoolean();
        String[] habitat = node.get("habitat") != null ? node.get("habitat").asText().split(",") : null;
        String[] goodFor = node.get("goodFor") != null ? node.get("goodFor").asText().split(","): null;
        String hp = node.get("hp").asText();
        int ac = node.get("ac").intValue();
        int walkingSpeed = node.get("walkingSpeed") != null ? node.get("walkingSpeed").intValue() : 0;
        int swimmingSpeed = node.get("swimmingSpeed") != null ? node.get("swimmingSpeed").intValue() : 0;
        int flyingSpeed = node.get("flyingSpeed") != null ? node.get("flyingSpeed").intValue() : 0;
        int climbingSpeed = node.get("climbingSpeed") != null ? node.get("climbingSpeed").intValue() : 0;
        int burrow = node.get("burrow") != null ? node.get("burrow").intValue() : 0;
        int strength = node.get("strength").intValue();
        int dexterity = node.get("dexterity").intValue();
        int constitution = node.get("constitution").intValue();
        int intelligence = node.get("intelligence").intValue();
        int wisdom = node.get("wisdom").intValue();
        int charisma = node.get("charisma").intValue();
        String savingThrows = node.get("savingThrows") != null ? node.get("savingThrows").asText() : null;
        String skills = node.get("skills") != null ? node.get("skills").asText() : null;
        String senses = node.get("senses") != null ? node.get("senses").asText() : null;
        String languages = node.get("languages") != null ? node.get("languages").asText() : null;
        String damageResistance = node.get("damageResistance") != null ? node.get("damageResistance").asText() : null;
        String damageImmunities = node.get("damageImmunities") != null ? node.get("damageImmunities").asText() : null;
        String conditionResistance = node.get("conditionResistance") != null ? node.get("conditionResistance").asText() : null;
        String conditionImmunities = node.get("conditionImmunities") != null ? node.get("conditionImmunities").asText() : null;

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> specialAbilities = node.get("specialAbilities") != null ? objectMapper.convertValue(node.get("specialAbilities"), Map.class) : null;
        Map<String, Attack> actions = node.get("actions") != null ? objectMapper.convertValue(node.get("actions"), Map.class) : null;

        return new Beast(name, cr, size, extinct, swarm, habitat, goodFor, hp, ac, walkingSpeed, swimmingSpeed, flyingSpeed,
                climbingSpeed, burrow, strength, dexterity, constitution, intelligence, wisdom, charisma, savingThrows, skills, senses,
                languages, damageResistance, damageImmunities, conditionResistance, conditionImmunities, specialAbilities, actions);
    }
}
