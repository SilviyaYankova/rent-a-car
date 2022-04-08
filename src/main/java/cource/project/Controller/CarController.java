package cource.project.Controller;

import cource.project.exeption.InvalidEntityDataException;
import cource.project.exeption.NoneAvailableEntityException;
import cource.project.exeption.NoneExistingEntityException;
import cource.project.model.Car;
import cource.project.model.user.User;
import cource.project.service.CarService;
import cource.project.service.UserService;
import cource.project.view.*;
import cource.project.view.Menu.Menu;
import cource.project.view.Menu.Option;

import java.util.Collection;
import java.util.List;

public class CarController {
    private final UserService userService;
    private final CarService carService;

    public CarController(UserService userService, CarService carService) {
        this.userService = userService;
        this.carService = carService;
    }

    public void init(User LOGGED_IN_USER) throws InvalidEntityDataException, NoneAvailableEntityException, NoneExistingEntityException {


        Menu menu = new Menu("Car Menu", List.of(
                new Option("See all cars", () -> {
                    Collection<Car> allCars = carService.getAllCars();
                    int cont = 0;
                    for (Car car : allCars) {
                        cont++;
                        System.out.println(cont + ". \t" + car);
                    }

                    return "";
                }),
                new Option("Add car", () -> {
                    AddCarDialog addCarDialog = new AddCarDialog(carService);
                    addCarDialog.input(LOGGED_IN_USER);
                    return "";
                }),
                new Option("Edit car", () -> {
                    EditCarDialog editCarDialog = new EditCarDialog(carService);
                    editCarDialog.input(LOGGED_IN_USER);
                    return "";
                }),
                new Option("Delete car", () -> {
                    DeleteCarDialog deleteCarDialog = new DeleteCarDialog(carService);
                    deleteCarDialog.input(LOGGED_IN_USER);
                    return "";
                })
        ));
        menu.show();
    }
}