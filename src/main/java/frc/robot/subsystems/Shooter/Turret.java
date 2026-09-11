package frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static edu.wpi.first.units.Units.Volt;

import org.littletonrobotics.junction.Logger;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.system.LinearSystem;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.DutyCycle;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import static edu.wpi.first.units.Units.Volts;
import edu.wpi.first.math.system.plant.LinearSystemId;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicDutyCycle;
import com.ctre.phoenix6.controls.PositionVoltage;
public class Turret extends SubsystemBase{
    private final TalonFX turretMotor; 
    private static final double GEAR_RATIO = (11.0*10.0) / (50.0 * 83.0);
    private final DCMotorSim turretMotorSim = new DCMotorSim(LinearSystemId.createDCMotorSystem(DCMotor.getKrakenX60Foc(1),0.001, 1/GEAR_RATIO), DCMotor.getKrakenX60Foc(1));
    public double targetPosition = 0;
    public double currentPosition = 0;
    public Turret(int motorID){
        turretMotor = new TalonFX(motorID);
        var talonFXConfigs = new TalonFXConfiguration();
        var slot0Configs = talonFXConfigs.Slot0;
        slot0Configs.kP = 1;
        slot0Configs.kI = 0;
        slot0Configs.kD = 0;
        turretMotor.getConfigurator().apply(talonFXConfigs);
        
    }

    public void setPositionPID(double rotations){
        final PositionVoltage motorRequest = new PositionVoltage(rotations/GEAR_RATIO);

        turretMotor.setControl(motorRequest);
        targetPosition = rotations;
    }

    public void adjustTurret(boolean left){
        if(left){
            turretMotor.set(0.09);
        }
        else{
            turretMotor.set(-0.09);
        }
    }
    public void stop(){
        turretMotor.stopMotor();
        
    }
    public Command rightCommand(){
        return new RunCommand(()->adjustTurret(false), this);
    }

    public Command leftCommand(){
        return new RunCommand(()->adjustTurret(true),this);
    }

      public Command stopCommand(){
        return new RunCommand(()->stop(),this);
    }

    public Command PIDCommand(double rotations){
        return new RunCommand(()->setPositionPID(rotations),this);
    }

     @Override
  public void periodic() {
    currentPosition = (turretMotor.getRotorPosition().getValueAsDouble()*GEAR_RATIO);
    Logger.recordOutput("Turret/targetPosition", targetPosition);
    Logger.recordOutput("Turret/currentPosition", currentPosition);
   
  }

  @Override
  public void simulationPeriodic(){
    var talonFXSim = turretMotor.getSimState();
    talonFXSim.setSupplyVoltage(RobotController.getBatteryVoltage());
    var motorVoltage = talonFXSim.getMotorVoltageMeasure();

    turretMotorSim.setInputVoltage(motorVoltage.in(Volts));
    turretMotorSim.update(0.020);

    talonFXSim.setRawRotorPosition(turretMotorSim.getAngularPosition().times(1/GEAR_RATIO));
    talonFXSim.setRotorVelocity(turretMotorSim.getAngularVelocity().times(1/GEAR_RATIO));
  }
}

