package frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.Command;

public class Hood extends SubsystemBase{
    private final TalonFX hoodMotor;
    public Hood(int motorID){
        hoodMotor = new TalonFX(motorID);
    }

    public void adjustHood(boolean down){
        if(down){
            hoodMotor.set(0.3);
        }
        else{
            hoodMotor.set(-0.3);
        }
    }

    public void stop(){
        hoodMotor.stopMotor();
    }

    public Command upCommand(){
        return new RunCommand(()->adjustHood(false),this);
    }
    
    public Command downCommand(){
        return new RunCommand(()->adjustHood(true),this);
    }
    
    public Command stopCommand(){
        return new RunCommand(()->stop(),this);
    }

}
