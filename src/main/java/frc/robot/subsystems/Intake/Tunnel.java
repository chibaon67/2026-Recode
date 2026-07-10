package frc.robot.subsystems.Intake;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;

public class Tunnel extends SubsystemBase{
    private final TalonFX topTunnelMotor;
    private final TalonFX bottomTunnelMotor;
    public Tunnel(int topMotorID, int bottomMotorID){
        topTunnelMotor = new TalonFX(topMotorID);
        bottomTunnelMotor = new TalonFX(bottomMotorID);
    }
    public void run(boolean inverted){
        if(inverted)
        {
            topTunnelMotor.set(-0.3);
            bottomTunnelMotor.set(-0.3);
        }
        else
        {
            topTunnelMotor.set(0.3);
            bottomTunnelMotor.set(0.3);

        }
        }
    public void setSpeed(int speed){
        topTunnelMotor.set(0.7);
        bottomTunnelMotor.set(0.7);
    }

    public void stopIntake(){
        topTunnelMotor.stopMotor();
        bottomTunnelMotor.stopMotor();
    }


    public Command intakeCommand(){
        return new RunCommand(()->run(false), this);
    }

    public Command outtakeCommand(){
        return new RunCommand(()-> run(true), this);
    }

    public Command stopCommand(){
        return new RunCommand(()->stopIntake(),this);
    }
    }
    