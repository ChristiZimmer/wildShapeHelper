package beans;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import helpers.BeastDeserializer;

import java.util.List;
import java.util.Map;

@JsonDeserialize(using = BeastDeserializer.class)
public class Beast {
    private String name;
    private double cr;
    private String size;
    private String[] habitat;
    private String[] goodFor;
    private String hp;
    private int ac;
    private int walkingSpeed;
    private int swimmingSpeed;
    private  int flyingSpeed;
    private int climbingSpeed;
    private int burrow;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private String skills;
    private  String senses;
    private  String damageImmunities;
    private String conditionImmunities;
    private Map<String, String> specialAbilities;
    private List<Attack> actions;

    public Beast(String name, double cr, String size, String[] habitat, String[] goodFor, String hp, int ac,
                 int walkingSpeed, int swimmingSpeed, int flyingSpeed, int climbingSpeed, int burrow, int strength, int dexterity,
                 int constitution, int intelligence, int wisdom, int charisma, String skills, String senses, String damageImmunities,
                 String conditionImmunities, Map<String, String> specialAbilities, List<Attack> actions) {
        this.name = name;
        this.cr = cr;
        this.size = size;
        this.habitat = habitat;
        this.goodFor = goodFor;
        this.hp = hp;
        this.ac = ac;
        this.walkingSpeed = walkingSpeed;
        this.swimmingSpeed = swimmingSpeed;
        this.flyingSpeed = flyingSpeed;
        this.climbingSpeed = climbingSpeed;
        this.burrow = burrow;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.skills = skills;
        this.senses = senses;
        this.damageImmunities = damageImmunities;
        this.conditionImmunities = conditionImmunities;
        this.specialAbilities = specialAbilities;
        this.actions = actions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCr() {
        return cr;
    }

    public void setCr(double cr) {
        this.cr = cr;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String[] getHabitat() {
        return habitat;
    }

    public void setHabitat(String[] habitat) {
        this.habitat = habitat;
    }

    public String[] getGoodFor() {
        return goodFor;
    }

    public void setGoodFor(String[] goodFor) {
        this.goodFor = goodFor;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public int getWalkingSpeed() {
        return walkingSpeed;
    }

    public void setWalkingSpeed(int walkingSpeed) {
        this.walkingSpeed = walkingSpeed;
    }

    public int getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(int swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }

    public int getFlyingSpeed() {
        return flyingSpeed;
    }

    public void setFlyingSpeed(int flyingSpeed) {
        this.flyingSpeed = flyingSpeed;
    }

    public int getClimbingSpeed() {
        return climbingSpeed;
    }

    public void setClimbingSpeed(int climbingSpeed) {
        this.climbingSpeed = climbingSpeed;
    }

    public int getBurrow() {
        return burrow;
    }

    public void setBurrow(int burrow) {
        this.burrow = burrow;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getSenses() {
        return senses;
    }

    public void setSenses(String senses) {
        this.senses = senses;
    }

    public String getDamageImmunities() {
        return damageImmunities;
    }

    public void setDamageImmunities(String damageImmunities) {
        this.damageImmunities = damageImmunities;
    }

    public String getConditionImmunities() {
        return conditionImmunities;
    }

    public void setConditionImmunities(String conditionImmunities) {
        this.conditionImmunities = conditionImmunities;
    }

    public Map<String, String> getSpecialAbilities() {
        return specialAbilities;
    }

    public void setSpecialAbilities(Map<String, String> specialAbilities) {
        this.specialAbilities = specialAbilities;
    }

    public List<Attack> getActions() {
        return actions;
    }

    public void setActions(List<Attack> actions) {
        this.actions = actions;
    }
}
