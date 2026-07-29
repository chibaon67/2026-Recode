package frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.math.controller.PIDController;

public class Turret extends SubsystemBase{
    private final TalonFX turretMotor; 
    private static final double GEAR_RATIO = (11.0*10.0) / (50.0 * 83.0);
    private final PIDController turretPID;
    
    public Turret(int motorID){
        turretMotor = new TalonFX(motorID);
        PIDController pid = new PIDController
    }
    public void adjustTurret(boolean left){
        if(left){
            turretMotor.set(0.09);
        }
        else{
            turretMotor.set(-0.09);
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

