package frc.robot.subsystems.Intake;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Hopper extends SubsystemBase{
    private final TalonFX hopperMotor;
    public Hopper(int motorID){
        hopperMotor = new TalonFX(motorID);
    }
    public void run(boolean inverted){
        if(inverted)
        {
            hopperMotor.set(0.7);
        }
        else
        {
            hopperMotor.set(-0.7);
        }
        }
    public void setSpeed(int speed){
        hopperMotor.set(speed);
    }

    public void stopIntake(){
        hopperMotor.stopMotor();
    }
    }
    

