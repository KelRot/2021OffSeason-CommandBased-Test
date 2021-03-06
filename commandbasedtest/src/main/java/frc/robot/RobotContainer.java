// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.Drive;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Joystick js= new Joystick(0);
  private final Drive drive= new Drive();
  private final DriveCommand driveCommand= new DriveCommand(drive, js);
  private final Intex intex= ;      //   TAMAMLANMADI
  private final RunIntex runIntex=; //   TAMAMLANMADI
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  private void configureButtonBindings() {

    new JoystickButton(joystick, Button.kY.value).whileHeld(new InstantCommand( ()-> intex_subystem.runIntex(false) )).whenReleased(new InstantCommand(intex_subystem::stopIntex));
    new JoystickButton(joystick, Button.kA.value).whileHeld(new InstantCommand( ()-> intex_subystem.runIntex(true) )).whenReleased(new InstantCommand(intex_subystem::stopIntex));
    
    new JoystickButton(joystick, Button.kX.value).whileHeld(new InstantCommand( ()-> kapak_subystem.runKapak(false) )).whenReleased(new InstantCommand(kapak_subystem::stopKapak));
    new JoystickButton(joystick, Button.kB.value).whileHeld(new InstantCommand( ()-> kapak_subystem.runKapak(false) )).whenReleased(new InstantCommand(kapak_subystem::stopKapak));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return driveCommand ;
  }
}