package UAS2022.Model;

public class User {
    private int id, idCategory;
    private String name, photo, email, password;

    public User(int id, int idCategory, String name, String photo, String email, String password) {
        this.id = id;
        this.idCategory = idCategory;
        this.name = name;
        this.photo = photo;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

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

    @Override
    public String toString() {
        return "User [id=" + id + ", idCategory=" + idCategory + ", name=" + name + ", photo=" + photo + ", email="
                + email + ", password=" + password + "]";
    }

}
