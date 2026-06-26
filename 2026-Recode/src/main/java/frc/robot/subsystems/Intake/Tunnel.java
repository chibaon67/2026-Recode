package frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import org.littletonrobotics.junction.Logger;

import com.ctre.phoenix6.hardware.TalonFX;

public class Tunnel extends SubsystemBase {
    private final TalonFX topTunnelMotor;
    private final TalonFX bottomTunnelMotor;
    private static final int TOP_MOTOR_ID = 6767;
    private static final int BOTTOM_MOTOR_ID = 757575;
    private static final double TOP_MOTOR_SPEED=0.5;
    private static final double BOTTOM_MOTOR_SPEED=0.5;
    
    public Tunnel(){
        topTunnelMotor = new TalonFX(TOP_MOTOR_ID);
        bottomTunnelMotor = new TalonFX(BOTTOM_MOTOR_ID);
    }

    public void intake(){
        topTunnelMotor.set(TOP_MOTOR_SPEED);
        bottomTunnelMotor.set(BOTTOM_MOTOR_SPEED);
    }

    public void outtake(){
        topTunnelMotor.set(-TOP_MOTOR_SPEED);
        bottomTunnelMotor.set(-BOTTOM_MOTOR_SPEED);
    }

    public void stop(){
        topTunnelMotor.stopMotor();
        bottomTunnelMotor.stopMotor();
    }

    public double getTopCurrentRPS(){
        return topTunnelMotor.getRotorVelocity().getValueAsDouble();
    }
    public double getBottomCurrentRPS(){
        return bottomTunnelMotor.getRotorVelocity().getValueAsDouble();
    }

    @Override
    public void periodic(){
        Logger.recordOutput("topTunnel/CommandedSpeed", topTunnelMotor.get());
        Logger.recordOutput("topTunnel/CurrentRPS", getTopCurrentRPS());
        Logger.recordOutput("bottomTunnel/CommandedSpeed", bottomTunnelMotor.get());
        Logger.recordOutput("bottomTunnel/CurrentRPS", getBottomCurrentRPS());
    }

}
