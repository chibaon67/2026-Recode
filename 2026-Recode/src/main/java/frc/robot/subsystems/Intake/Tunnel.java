package frc.robot.subsystems.Intake;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Tunnel extends SubsystemBase{
    private final TalonFX tunnelMotor;
    public Tunnel(int motorID){
        tunnelMotor = new TalonFX(motorID);
    }
    public void run(boolean inverted){
        if(inverted)
        {
            tunnelMotor.set(0.7);
        }
        else
        {
            tunnelMotor.set(-0.7);
        }
        }
    public void setSpeed(int speed){
        tunnelMotor.set(speed);
    }

    public void stopIntake(){
        tunnelMotor.stopMotor();
    }
    }
    