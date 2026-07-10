package frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.Command;

public class Turret extends SubsystemBase{
    private final TalonFX turretMotor;
    public Turret(int motorID){
        turretMotor = new TalonFX(motorID);
    }
    public void adjustTurret(boolean left){
        if(left){
            turretMotor.set(0.05);
        }
        else{
            turretMotor.set(-0.05);
        }
    }
    public void stop(){
        turretMotor.stopMotor();
    }
    public Command rightCommand(){
        return new RunCommand(()->adjustTurret(false), this);
    }

    public Command leftCommand(){
        return new RunCommand(()->adjustTurret(true),this);
    }

      public Command stopCommand(){
        return new RunCommand(()->stop(),this);
    }

}

