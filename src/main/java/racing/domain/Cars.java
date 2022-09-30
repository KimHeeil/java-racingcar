package racing.domain;

import racing.domain.model.CarName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars
{
    private final List<Car> carList;
    private static final String DELEMETER = ",";

    private Cars(int number, MovingStrategy movingStrategy)
    {
        this.carList = new ArrayList<>();

        IntStream.range(0, number)
            .forEach(carName -> carList.add(Car.newCar(movingStrategy)));
    }

    private Cars(String[] carNames, MovingStrategy movingStrategy)
    {
        this.carList = new ArrayList<>();

        Arrays.stream(carNames)
            .forEach(carName -> carList.add(Car.newCar(CarName.of(carName), movingStrategy)));
    }

    public static Cars newCars(String[] carNames, MovingStrategy movingStrategy)
    {
        return new Cars(carNames, movingStrategy);
    }

    public static Cars newCars(int number, MovingStrategy movingStrategy)
    {
        return new Cars(number, movingStrategy);
    }

    public List<Car> getCarList()
    {
        return carList;
    }

    public List<Car> moving()
    {
        carList.forEach(Car::moveForward);

        return carList;
    }

    public String getWinner()
    {
        int winnerPosition = getWinnerPosition();
        return carList.stream()
            .filter(car -> car.getPosition() == winnerPosition)
            .map(Car::getCarName).collect(Collectors.joining(DELEMETER));
    }

    private int getWinnerPosition()
    {
        return carList.stream()
            .max(Comparator.comparingInt(Car::getPosition))
            .get()
            .getPosition();
    }
}