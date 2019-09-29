package org.chaofei.entity;

public class Animal {
    private Ability ability;

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    @Override
    public String toString() {
        return "Animal [ability=" + ability + "]";
    }
}
