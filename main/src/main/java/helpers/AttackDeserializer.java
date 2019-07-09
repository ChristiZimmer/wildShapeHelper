package helpers;

import beans.Attack;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class AttackDeserializer extends StdDeserializer<Attack> {

    public AttackDeserializer() {
        this(null);
    }

    public AttackDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Attack deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        String desc = node.get("desc") != null ? node.get("desc").asText() : null;
        String type = node.get("type") != null ? node.get("type").asText() : null;
        String reach = node.get("reach") != null ? node.get("reach").asText() : null;
        String target = node.get("target") != null ? node.get("target").asText() : null;
        String toHit = node.get("toHit") != null ? node.get("toHit").asText() : null;
        String onHit = node.get("onHit") != null ? node.get("onHit").asText() : null;

        return new Attack(desc, type, reach, target, toHit, onHit);
    }
}
