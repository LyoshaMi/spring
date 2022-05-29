package homework;

@Table(title = "cats")
public class Cat {
    @Column
    int id;

    @Column
    String name;

    @Column
    int weight;

    public Cat(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }
}
