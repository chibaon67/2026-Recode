package frc.robot.subsystems.Intake;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.DoubleEntry;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.networktables.DoubleEntry;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
public class Tunnel extends SubsystemBase{
    final DoubleEntry topTunnelSpeedEntry;
    final DoubleEntry bottomTunnelSpeedEntry;

    private final TalonFX topTunnelMotor;
    private final TalonFX bottomTunnelMotor;
    public Tunnel(int topMotorID, int bottomMotorID){
        topTunnelMotor = new TalonFX(topMotorID);
        bottomTunnelMotor = new TalonFX(bottomMotorID);
        NetworkTableInstance inst = NetworkTableInstance.getDefault();
    NetworkTable topTunnelTable = inst.getTable("Subsystems/topTunnel");
    NetworkTable bottomTunnelTable = inst.getTable("Subsystems/bottomTunnel");
    topTunnelSpeedEntry = topTunnelTable.getDoubleTopic("topTunnelSpeed").getEntry(0);
    topTunnelSpeedEntry.set(0.3);
     bottomTunnelSpeedEntry = bottomTunnelTable.getDoubleTopic("bottomTunnelSpeed").getEntry(0);
    bottomTunnelSpeedEntry.set(0.3);    

 
    }
    public void run(boolean inverted){
        if(inverted)
        {
            topTunnelMotor.set(-0.7);
            bottomTunnelMotor.set(-0.7);
        }
        else
        {
            topTunnelMotor.set(0.7);
            bottomTunnelMotor.set(0.7);

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
    