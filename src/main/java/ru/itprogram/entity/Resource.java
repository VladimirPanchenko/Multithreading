package ru.itprogram.entity;

import java.util.Objects;

public class Resource {
    private long id;
    private boolean using;
    private int weight;

    public Resource(long id, boolean using) {
            this.id = id;
            this.using = using;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isUsing() {
        return using;
    }

    public void setUsing(boolean using) {
        this.using = using;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return id == resource.id &&
                using == resource.using &&
                weight == resource.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, using, weight);
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", using=" + using +
                ", weight=" + weight +
                '}';
    }
}
