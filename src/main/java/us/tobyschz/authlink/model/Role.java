package us.tobyschz.authlink.model;

public enum Role {
    USER(100),
    ADMIN(200),
    OWNER(300);

    public final int pLevel;

    Role(int permission) {
        this.pLevel = permission;
    }
}
