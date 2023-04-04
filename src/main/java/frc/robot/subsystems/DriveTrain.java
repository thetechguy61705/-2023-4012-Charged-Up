package frc.robot.subsystems;
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
        // Add motor controllers once they are decided.

      private final WPI_TalonFX DRIVE_LEFT_FRONT;
      private final WPI_TalonFX DRIVE_RIGHT_FRONT;
      private final WPI_TalonFX DRIVE_LEFT_BACK;
      private final WPI_TalonFX DRIVE_RIGHT_BACK;


      private final DifferentialDrive my_robot;

  public DriveTrain() {
    DRIVE_LEFT_FRONT = new WPI_TalonFX(Constants.DriveTrainConstants.LEFT_FRONT_MOTOR);
    DRIVE_RIGHT_FRONT = new WPI_TalonFX(Constants.DriveTrainConstants.RIGHT_FRONT_MOTOR);
    DRIVE_LEFT_BACK = new WPI_TalonFX(Constants.DriveTrainConstants.LEFT_BACK_MOTOR);
    DRIVE_RIGHT_BACK = new WPI_TalonFX(Constants.DriveTrainConstants.RIGHT_BACK_MOTOR);

    DRIVE_LEFT_FRONT.clearStickyFaults();
    DRIVE_RIGHT_FRONT.clearStickyFaults();
    DRIVE_LEFT_BACK.clearStickyFaults();
    DRIVE_RIGHT_BACK.clearStickyFaults();


    DRIVE_LEFT_FRONT.setNeutralMode(NeutralMode.Brake);
    DRIVE_RIGHT_BACK.setNeutralMode(NeutralMode.Brake);
    DRIVE_RIGHT_FRONT.setNeutralMode(NeutralMode.Brake);
    DRIVE_LEFT_BACK.setNeutralMode(NeutralMode.Brake);


    DRIVE_LEFT_BACK.follow(DRIVE_LEFT_FRONT);
    DRIVE_RIGHT_BACK.follow(DRIVE_RIGHT_FRONT);


    
    my_robot = new DifferentialDrive(DRIVE_LEFT_FRONT, DRIVE_RIGHT_FRONT);
    //hog rida 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }


  public synchronized void manualDrive(double leftVal, double rightVal) {
    DRIVE_LEFT_FRONT.set(leftVal);
    DRIVE_RIGHT_FRONT.set(rightVal);
  }

    public synchronized void tankDriveVolts(double leftVolts, double rightVolts) {
        DRIVE_LEFT_FRONT.setVoltage(-leftVolts);
        DRIVE_RIGHT_BACK.setVoltage(-rightVolts);
        my_robot.feed();
    }

    public synchronized void arcadeDrive(double xVal, double yVal) {
        my_robot.tankDrive(xVal, yVal);
    }
}