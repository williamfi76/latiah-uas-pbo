package UAS2022.Model;

public class CategoryUser {
    private int id;
    private String name;

    public CategoryUser(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryUser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
