package frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.Command;


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

    public Command spinCommand(){
        return new RunCommand(()-> run(), this);
    }

    public Command stopCommand(){
        return new RunCommand(()->stop(),this);
    }
}