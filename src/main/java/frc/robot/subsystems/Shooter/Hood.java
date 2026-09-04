package frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import org.littletonrobotics.junction.Logger;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicDutyCycle;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.Command;

public class Hood extends SubsystemBase{
    private static final double kGearRatio = (9.0 * 15.0 * 10.0) / (48.0 * 30.0 * 162.767577);
    public double targetPosition = 0;
    public double currentPosition = 0;
    private final TalonFX hoodMotor;
    public Hood(int motorID){
        hoodMotor = new TalonFX(motorID);
        var talonFXConfigs = new TalonFXConfiguration();
        var slot0Configs = talonFXConfigs.Slot0;
        slot0Configs.kP = 1;
        slot0Configs.kI = 0;
        slot0Configs.kD = 0;
        hoodMotor.getConfigurator().apply(talonFXConfigs);
    }

    public void adjustHood(boolean down){
        if(down){
            hoodMotor.set(0.1);
        }
        else{
            hoodMotor.set(-0.1);
        }
    }

    public void setPositionPID(double rotations){
        final PositionVoltage motorRequest = new PositionVoltage(rotations/kGearRatio);

        hoodMotor.setControl(motorRequest);
        targetPosition = rotations;
    }

    public void stop(){
        hoodMotor.stopMotor();
    }

    public Command upCommand(){
        return new RunCommand(()->adjustHood(true),this);
    }
    
    public Command downCommand(){
        return new RunCommand(()->adjustHood(false),this);
    }
    
    public Command stopCommand(){
        return new RunCommand(()->stop(),this);
    }
    public Command PIDCommand(double rotations){
        return runOnce(()->setPositionPID(rotations));
    }
    public void periodic(){
        currentPosition = (hoodMotor.getRotorPosition().getValueAsDouble())*kGearRatio;
        Logger.recordOutput("Hood/targetPosition", targetPosition);
        Logger.recordOutput("Hood/currentPosition", currentPosition);
    }
}
