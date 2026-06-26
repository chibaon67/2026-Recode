package frc.robot.subsystems.Intake;


import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Hopper extends SubsystemBase {
    private final TalonFX hopperMotor;
    private static final int MOTOR_ID= 67;
    private static final double MOTOR_SPEED= 0.5;

    public Hopper(){
        hopperMotor= new TalonFX(MOTOR_ID);
    }
    public void intake(){
        hopperMotor.set(MOTOR_SPEED);
    }
    public void outtake(){
        hopperMotor.set(-MOTOR_SPEED);
    }
    public void stop(){
        hopperMotor.stopMotor();
    }

    public double getCurrentRPS(){
        return hopperMotor.getRotorVelocity().getValueAsDouble();
    }
    @Override
    public void periodic(){
        Logger.recordOutput("Hopper/CommandedSpeed", hopperMotor.get());
        Logger.recordOutput("Hopper/CurrentRPS", getCurrentRPS());
    }
}
