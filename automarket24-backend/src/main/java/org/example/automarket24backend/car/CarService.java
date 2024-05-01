package org.example.automarket24backend.car;

import lombok.AllArgsConstructor;
import org.example.automarket24backend.bodyType.BodyType;
import org.example.automarket24backend.bodyType.BodyTypeRepository;
import org.example.automarket24backend.color.Color;
import org.example.automarket24backend.color.ColorRepository;
import org.example.automarket24backend.condition.Condition;
import org.example.automarket24backend.condition.ConditionRepository;
import org.example.automarket24backend.damageType.DamageType;
import org.example.automarket24backend.damageType.DamageTypeRepository;
import org.example.automarket24backend.drivetrain.Drivetrain;
import org.example.automarket24backend.drivetrain.DrivetrainRepository;
import org.example.automarket24backend.feature.Feature;
import org.example.automarket24backend.feature.FeatureRepository;
import org.example.automarket24backend.fuelType.FuelType;
import org.example.automarket24backend.fuelType.FuelTypeRepository;
import org.example.automarket24backend.generation.Generation;
import org.example.automarket24backend.generation.GenerationRepository;
import org.example.automarket24backend.make.Make;
import org.example.automarket24backend.make.MakeRepository;
import org.example.automarket24backend.model.Model;
import org.example.automarket24backend.model.ModelRepository;
import org.example.automarket24backend.transmission.Transmission;
import org.example.automarket24backend.transmission.TransmissionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

    private CarRepository carRepository;
    private MakeRepository makeRepository;
    private ModelRepository modelRepository;
    private GenerationRepository generationRepository;
    private BodyTypeRepository bodyTypeRepository;
    private TransmissionRepository transmissionRepository;
    private DrivetrainRepository drivetrainRepository;
    private ColorRepository colorRepository;
    private FuelTypeRepository fuelTypeRepository;
    private DamageTypeRepository damageTypeRepository;
    private ConditionRepository conditionRepository;
    private FeatureRepository featureRepository;

    public Car saveCar(CarDto carDto) {
        Car car = new Car();
        car.setProductionYear(carDto.productionYear());
        car.setMileage(carDto.mileage());
        car.setPower(carDto.power());
        car.setEngineSize(carDto.engineSize());
        car.setSeats(carDto.seats());
        car.setDoors(carDto.doors());

        Make make = makeRepository.findById(carDto.make()).orElse(null);
        car.setMake(make);

        Model model = modelRepository.findById(carDto.model()).orElse(null);
        car.setModel(model);

        Generation generation = generationRepository.findById(carDto.generation()).orElse(null);
        car.setGeneration(generation);

        BodyType bodyType = bodyTypeRepository.findById(carDto.bodyType()).orElse(null);
        car.setBodyType(bodyType);

        Transmission transmission = transmissionRepository.findById(carDto.transmission()).orElse(null);
        car.setTransmission(transmission);

        Drivetrain drivetrain = drivetrainRepository.findById(carDto.drivetrain()).orElse(null);
        car.setDrivetrain(drivetrain);

        Color color = colorRepository.findById(carDto.color()).orElse(null);
        car.setColor(color);

        FuelType fuelType = fuelTypeRepository.findById(carDto.fuelType()).orElse(null);
        car.setFuelType(fuelType);

        DamageType damageType = damageTypeRepository.findById(carDto.damageType()).orElse(null);
        car.setDamageType(damageType);

        Condition condition = conditionRepository.findById(carDto.condition()).orElse(null);
        car.setCondition(condition);

        List<Feature> features = new ArrayList<>();
        for (Integer featureId: carDto.features()) {
            featureRepository.findById(featureId).ifPresent(features::add);
        }
        car.setFeatures(features);

        return carRepository.save(car);
    }
}
