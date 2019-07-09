package helpers;

import beans.Attack;
import beans.Beast;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        String skills = node.get("skills") != null ? node.get("skills").asText() : null;
        String senses = node.get("senses") != null ? node.get("senses").asText() : null;
        String damageImmunities = node.get("damageImmunities") != null ? node.get("damageImmunities").asText() : null;
        String conditionImmunities = node.get("conditionImmunities") != null ? node.get("conditionImmunities").asText() : null;

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> specialAbilities = node.get("specialAbilities") != null ? objectMapper.convertValue(node.get("specialAbilities"), Map.class) : null;
        List<Attack> actions = new ArrayList<>();
        if(node.get("actions") != null) {
            node.get("actions").forEach(e -> actions.add(objectMapper.convertValue(e, Attack.class)));
        }

        return new Beast(name, cr, size, habitat, goodFor, hp, ac, walkingSpeed, swimmingSpeed, flyingSpeed,
                climbingSpeed, burrow, strength, dexterity, constitution, intelligence, wisdom, charisma, skills, senses,
                damageImmunities, conditionImmunities, specialAbilities, actions);
    }
}
