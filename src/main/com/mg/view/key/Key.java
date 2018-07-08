package com.mg.view.key;

import java.util.Objects;

public class Key
{
    private final String name;
    private final double id;
    private final KeyType type;

    public Key(String name, double id, KeyType type)
    {
        this.name = name;
        this.id = id;
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public double getId()
    {
        return id;
    }

    public KeyType getType()
    {
        return type;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o)
        {
            return true;
        }

        if(o == null || getClass() != o.getClass())
        {
            return false;
        }

        Key key = (Key) o;

        return Double.compare(key.id, id) == 0 &&
                Objects.equals(name, key.name) &&
                type == key.type;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, id, type);
    }

    @Override
    public String toString()
    {
        return "Key: " +
                "name=" + name + ", " +
                "id=" + id + ", " +
                "type=" + type.name().toLowerCase() + ".";
    }
}
