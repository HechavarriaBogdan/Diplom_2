package praktikum.order;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Orders {
    private String _id;
    private String[] ingredients;
    private String status;
    private String name;
    private String createdAt;
    private String updatedAt;
    private int number;



}
