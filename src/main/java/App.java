import daos.CarDAO;
import models.CarDTO;

public class App {
    public static void main(String[] args) {
        // findbyId
        CarDAO carD = new CarDAO();
        System.out.println(carD.findById(1).toString());

        // findAll
        carD = new CarDAO();
        System.out.println(carD.findAll().toString());

        // update
        carD = new CarDAO();
        CarDTO carT = new CarDTO(1, "Honda", "Civic", "Blue", 2011, "12345abc");
        System.out.println(carD.update(carT).toString());

        // create
        carD = new CarDAO();
        carT = new CarDTO(2, "Honda", "Civic", "Blue", 2011, "12345abc");
        System.out.println(carD.create(carT).toString());

        // delete
        carD = new CarDAO();
        carD.delete(1);

    }
}
