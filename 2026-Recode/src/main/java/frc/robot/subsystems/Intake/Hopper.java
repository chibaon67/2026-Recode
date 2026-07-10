package frc.robot.subsystems.Intake;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.Command;

public class Hopper extends SubsystemBase{
    private final TalonFX hopperMotor;
    public Hopper(int motorID){
        hopperMotor = new TalonFX(motorID);
    }
    public void run(boolean inverted){
        if(inverted)
        {
            hopperMotor.set(-0.3);
        }
        else
        {
            hopperMotor.set(0.3);
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
    
    
    

