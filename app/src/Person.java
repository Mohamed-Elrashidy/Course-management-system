public class Person implements PersonInterface {
    private String email;
    private String password;
    private String id;
    private String name;

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void login(String email, String password) {

    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
