package mas.attribute_unique_custom;

import java.util.ArrayList;

/**
 *
 * @author s14454
 */
public class Car {

    private String model;
    private int speed;                                                  //dotyczace atrybuta
    private String vinNumber;                                           //Unique
    private final static int MAXSPEED = 80;
    private static ArrayList<Car> vinNumbers = new ArrayList<>();

    public Car(String model, int speed, String vinNumber) {
        setModel(model);
        setSpeed(speed);
        setVinNumber(vinNumber);
        vinNumbers.add(this);
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model != null) {
            this.model = model;
        } else {
            throw new IllegalArgumentException("Invalid value - Model is null");
        }
    }

    public void setVinNumber(String VINnumber) {
        if (vinNumber == null) {
            throw new IllegalArgumentException("Number can't be null");
        }
        if (checkDublicate(VINnumber)) {
            throw new IllegalArgumentException("Yhis number : " + VINnumber + " exists already");
        } else if (!VINnumber.matches("\\d{17}")) {
            throw new RuntimeException("Bad format");
        }
        this.vinNumber = VINnumber;

    }

    public ArrayList<Car> getVinNumbers() {
        return new ArrayList<Car>(vinNumbers);
    }

    public void setVinNumbers(ArrayList<Car> vinNumbers) {
        this.vinNumbers = vinNumbers;

    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed > MAXSPEED) {
            throw new IllegalArgumentException("Speed must be less than " + MAXSPEED + "km/h");
        } else {
            this.speed = speed;
        }
    }

    public boolean checkDublicate(String VinNumber) {

        for (Car car : vinNumbers) {
            if (car.getVinNumber() == VinNumber) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Car{" + "model=" + model + ", speed=" + speed + ", vinNumber=" + vinNumber + '}';
    }

}
