package transaction.app;

/**
 * Created by denys on 6/1/2017.
 */
public class User {
    private String name;
    private String role;
    private String email;

    public User(String name, String role, String email) {
        this.name = name;
        this.role = role;
        this.email = email;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
