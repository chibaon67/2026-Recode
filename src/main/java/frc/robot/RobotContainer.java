// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.Shooter.*;
import frc.robot.subsystems.Intake.*;
import edu.wpi.first.wpilibj.XboxController;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final Hood hood = new Hood(Constants.HoodConstants.HOOD_MOTOR_ID);
  public final Turret turret = new Turret(Constants.TurretConstants.TURRET_MOTOR_ID);
  public final Flywheel flywheel = new Flywheel(Constants.FlywheelConstants.FLYWHEEL_MOTOR_ID);
  public final Hopper hopper = new Hopper(Constants.HopperConstants.HOPPER_MOTOR_ID);
  public final Intake intake = new Intake(Constants.IntakeConstants.INTAKE_MOTOR_ID);
  public final Tunnel tunnel = new Tunnel(Constants.TunnelConstants.TOP_TUNNEL_MOTOR_ID, Constants.TunnelConstants.BOTTOM_TUNNEL_MOTOR_ID);
  // Our one Controller
  private final CommandXboxController driverController = new CommandXboxController(0);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureButtonBindings();
  }


  private void configureButtonBindings() {
    intake.setDefaultCommand(intake.stopCommand().withName("stop intake"));
    hopper.setDefaultCommand(hopper.stopCommand().withName("stop hopper"));
    hood.setDefaultCommand(hood.stopCommand().withName("stop hood"));
    flywheel.setDefaultCommand(flywheel.stopCommand().withName("stop flywheel"));
    tunnel.setDefaultCommand(tunnel.stopCommand().withName("stop tunnel"));
    turret.setDefaultCommand(turret.stopCommand().withName("stop turret"));

    driverController.a().whileTrue(Commands.parallel(intake.intakeCommand(),tunnel.intakeCommand(), hopper.intakeCommand()));
    driverController.b().whileTrue(Commands.parallel(intake.outtakeComand(),tunnel.outtakeCommand(), hopper.outtakeCommand()));
    driverController.x().whileTrue(flywheel.spinCommand());
    driverController.leftBumper().whileTrue(hood.downCommand());
    driverController.rightBumper().whileTrue(hood.upCommand());
    driverController.rightTrigger().whileTrue(turret.rightCommand());
    driverController.leftTrigger().whileTrue(turret.leftCommand());
  }
  
}