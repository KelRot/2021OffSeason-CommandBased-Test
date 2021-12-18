// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drive extends SubsystemBase {
  //Drive Talons
  Talon frontLeft= new Talon(Constants.solOn);
  Talon backLeft= new Talon(Constants.solArka);
  Talon frontRight= new Talon(Constants.sagOn);
  Talon backRight= new Talon(Constants.sagArka);

  SpeedControllerGroup left= new SpeedControllerGroup(frontLeft, backLeft);
  SpeedControllerGroup right= new SpeedControllerGroup(frontRight, backRight);

  DifferentialDrive drive= new DifferentialDrive(left, right);

  /** Creates a new Drive. */
  public Drive() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void CurvatureDrive(Joystick subjs){
    drive.curvatureDrive(subjs.getRawAxis(1), subjs.getRawAxis(2), subjs.getRawButton(5));
  }
}