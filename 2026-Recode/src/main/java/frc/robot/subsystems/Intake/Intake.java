package frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class Intake extends SubsystemBase {
    private final TalonFX intakeMotor;

    public Intake(int motorID) {
        intakeMotor = new TalonFX(motorID);
    }
    public void Intake(double speed) {
        intakeMotor.set(speed);
    }
    public void outtake(double speed) {
        intakeMotor.set(-speed);
    }
    public void stop() {
        intakeMotor.set(0);
    }
    public double getSpeed() {
        return intakeMotor.get();
    }
    public void setSpeed(double speed) {
        intakeMotor.set(speed);
    }
}
