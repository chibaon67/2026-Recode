package frc.robot.subsystems.Intake;

import com.ctre.phoenix6.hardware.TalonFX;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.networktables.DoubleEntry;
// NetworkTable imports
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;


public class Hopper extends SubsystemBase{
    private final TalonFX hopperMotor;
    
    public Hopper(int motorID){
        hopperMotor = new TalonFX(motorID);
    }
    public void run(boolean inverted){
        if(inverted)
        {
            hopperMotor.set(-0.7);
        }
        else
        {
            hopperMotor.set(0.7);
        }
        }
    public void setSpeed(int speed){
        hopperMotor.set(speed);
    }

    public void stopIntake(){
        hopperMotor.stopMotor();
    }

    public Command intakeCommand(){
        return new RunCommand(()->run(false),this);
    }

      public Command outtakeCommand(){
        return new RunCommand(()-> run(true), this);
    }

    public Command stopCommand(){
        return new RunCommand(()->stopIntake(),this);
    }
    
}

