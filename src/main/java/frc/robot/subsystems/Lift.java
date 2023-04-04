// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lift extends SubsystemBase {
    private final CANSparkMax LiftMotor;

    public Lift() {
        LiftMotor = new CANSparkMax(5, MotorType.kBrushless);

        LiftMotor.clearFaults();

        LiftMotor.restoreFactoryDefaults();
    }

    // top 0.547618865966797
    // bottom (anthony) 29.309293746948242

    public synchronized void up() {
        LiftMotor.set(0.2);
    }
    public synchronized void down() {
        LiftMotor.set(-0.2);
    }
    public synchronized double getEncoder() {
        return LiftMotor.getEncoder().getPosition();
    }
    public synchronized void stop() {
        SmartDashboard.putNumber("Lift Position", LiftMotor.getEncoder().getPosition());
        LiftMotor.set(0);
    }
    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        SmartDashboard.putNumber("Lift Position", LiftMotor.getEncoder().getPosition());
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}