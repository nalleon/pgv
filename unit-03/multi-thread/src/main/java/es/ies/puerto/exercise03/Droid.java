package es.ies.puerto.exercise03;

import java.util.Objects;

public class Droid {
    private String name;
    private boolean assembly = false;
    private boolean activate = false;

    public Droid(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAssembly() {
        return assembly;
    }

    public void setAssembly(boolean assembly) {
        this.assembly = assembly;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Droid droide = (Droid) o;
        return Objects.equals(name, droide.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
