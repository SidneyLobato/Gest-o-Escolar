package model;

public class Admin extends Usuario {
    @Override
    public String getTipo() {
        return "Admin";
    }
}