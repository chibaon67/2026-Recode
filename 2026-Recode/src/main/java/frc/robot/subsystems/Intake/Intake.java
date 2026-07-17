package frc.robot.subsystems.Intake;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.networktables.DoubleEntry;
import edu.wpi.first.wpilibj2.command.Command;

public class Intake extends SubsystemBase{
    final DoubleEntry intakeSpeedEntry;
    private final TalonFX intakeMotor;
    public Intake(int motorID){
        intakeMotor = new TalonFX(motorID);
        
    }
    public void run(boolean inverted){
        if(inverted)
        {
            intakeMotor.set(-0.7);
        }
        else
        {
            intakeMotor.set(0.7);
        }
        }
    public void setSpeed(int speed){
        intakeMotor.set(speed);
    }

    public void stopIntake(){
        intakeMotor.stopMotor();
    }

    public Command intakeCommand(){
        return new RunCommand(()->run(false),this);
    }

    public Command outtakeComand(){
        return new RunCommand(()->run(true),this);
    }

    public Command stopCommand(){
        return new RunCommand(()->stopIntake(),this);
    }
    }
    

