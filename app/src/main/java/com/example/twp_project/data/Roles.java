
package com.example.twp_project.data;

public enum Roles {
    ADMIN("0"),
    USER("1");

    private final String value;

    Roles(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
