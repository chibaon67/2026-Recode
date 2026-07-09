package frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;



public class Flywheel extends SubsystemBase{
    private final TalonFX shooterMotor;
    public Flywheel(int motorID){
        shooterMotor = new TalonFX(motorID);
    }

    public void run(){
        shooterMotor.set(0.5);
    }

    public void stop(){
        shooterMotor.stopMotor();
    }
}