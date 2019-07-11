package beans;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import deserializers.AttackDeserializer;

@JsonDeserialize(using = AttackDeserializer.class)
public class Attack {
    private String desc;
    private String type;
    private String reach;
    private String target;
    private String toHit;
    private String onHit;

    public Attack(String desc, String type, String reach, String target, String toHit, String onHit) {
        this.desc = desc;
        this.type = type;
        this.reach = reach;
        this.target = target;
        this.toHit = toHit;
        this.onHit = onHit;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReach() {
        return reach;
    }

    public void setReach(String reach) {
        this.reach = reach;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getToHit() {
        return toHit;
    }

    public void setToHit(String toHit) {
        this.toHit = toHit;
    }

    public String getOnHit() {
        return onHit;
    }

    public void setOnHit(String onHit) {
        this.onHit = onHit;
    }
}
