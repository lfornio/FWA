package edu.school21.cinema.models;

public enum Fields {
    EMAIL("email"),
    FIRST_NAME("firstName"),
    LAST_NAME("lastName"),
    PASSWORD("password"),
    PHONE_NUMBER("phoneNumber");

    private String value;

    Fields(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
