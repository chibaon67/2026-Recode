package frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;

public class Tunnel extends SubsystemBase {
    private final TalonFX tunnelMotor;
    private final int MOTOR_ID = 6767;
    private final double MOTOR_SPEED=0.5;
    public Tunnel(){
        tunnelMotor = new TalonFX(MOTOR_ID);
    }
    public void runTunnel(){
        tunnelMotor.set(MOTOR_SPEED);
    }
    public void stop(){
        tunnelMotor.stopMotor();
    }
}
