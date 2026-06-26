package frc.robot.subsystems.Intake;


import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Hopper extends SubsystemBase {
    private final TalonFX hopperMotor;
    private final int deviceID= 67;
    private final double speed= 0.5;

    public Hopper(){
        hopperMotor= new TalonFX(deviceID);
    }
    public void runHopper(){
        hopperMotor.set(speed);
    }
    public void stop(){
        hopperMotor.stopMotor();
    }
}
