package cource.project.service;

import cource.project.exeption.NoneAvailableEntityException;
import cource.project.exeption.NoneExistingEntityException;
import cource.project.model.Car;
import cource.project.model.Worker;

import java.util.Collection;
import java.util.List;

public interface WorkerService {

    void addWorker(Worker worker);

    Collection<Worker> getAllWorkers();

    Worker getWorkerById(Long id) throws NoneExistingEntityException;

    void editWorker(Worker worker ) throws NoneExistingEntityException ;

    void deleteWorker(Long id) throws NoneExistingEntityException;

    Worker getAllAvailableWorker() throws NoneAvailableEntityException;

    void cleanCar(List<Car> allCarsWaitingForCleaning) throws NoneAvailableEntityException;

    void finishCarCleaning(Car car) throws NoneExistingEntityException;
}
