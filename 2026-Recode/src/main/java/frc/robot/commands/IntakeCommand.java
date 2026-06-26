package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake.Intake;

public class IntakeCommand extends Command{
private final Intake intake;
public IntakeCommand(Intake intake){
    this.intake = intake;
    addRequirements(intake);
}
@Override
public void execute(){
    intake.intake();
}
@Override
public void end(boolean interrupted){
    intake.stop();
}
@Override 
public boolean isFinished(){
    return false;

}
}
