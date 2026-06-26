package frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import org.littletonrobotics.junction.Logger;

import com.ctre.phoenix6.hardware.TalonFX;

public class Intake extends SubsystemBase {
    private final TalonFX intakeMotor;
    private static final double INTAKE_SPEED = 0.5;
    private static final double OUTTAKE_SPEED = -0.5;
    private static final int MOTOR_ID=76;
    public Intake() {
        intakeMotor = new TalonFX(MOTOR_ID);
    }

    public void intake() {
        intakeMotor.set(INTAKE_SPEED);
    }

    public void outtake() {
        intakeMotor.set(OUTTAKE_SPEED);
    }

    public void stop() {
        intakeMotor.stopMotor();
    }

    public double getCurrentRPS(){
        return intakeMotor.getRotorVelocity().getValueAsDouble();
    }
    
    @Override
    public void periodic(){
        Logger.recordOutput("Intake/CommandedSpeed", intakeMotor.get());
        Logger.recordOutput("Intake/CurrentRPS", getCurrentRPS());
    }
}
