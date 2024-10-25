package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

import java.io.ObjectOutput;
import java.io.OutputStreamWriter;

import javax.xml.transform.OutputKeys;

import edu.wpi.first.math.controller.PIDController;


public class PIDTurnCCW extends Command {
    
    double setPointAngle;
    Drivetrain drivetrain = new Drivetrain();
    PIDController pidController = new PIDController(0.5, 0, 0);

    public PIDTurnCCW(double angle) {

        setPointAngle = angle;
        addRequirements();
        pidController.setTolerance(5);
    }

    @Override
    public void initialize() {
     drivetrain.resetNavx();
     drivetrain.tankDrive(0, 0);


    }
    @Override
    public void execute() {
      //ToDo: crete variable which uses calculate method to 
      double speed = pidController.calculate(0);
      drivetrain.tankDrive(speed, -speed);
    }



    @Override
    public void end(boolean interrupted) {
      drivetrain.tankDrive(0, 0);    
    }


    @Override
    public boolean isFinished() {

        
        return pidController.atSetpoint();
    }
}
