/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveSubsystem;


public class DrivePID extends CommandBase {
  DriveSubsystem m_drive;
  double m_targetAngle;
  double m_currentAngle;
  double error;
  double relative_error;
  double previous_error=0;
  double power;
  double total_error=0;

  public DrivePID(DriveSubsystem drive,double targetAngle) {
    m_drive = drive;
    m_targetAngle= targetAngle;
    addRequirements(m_drive);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_currentAngle =m_drive.getHeading();
    relative_error =Math.abs(m_targetAngle - m_currentAngle);
    if(relative_error>180){
      error=relative_error-360;
    }
    else {
      error=relative_error;
    }
    total_error +=error;

    power= DriveConstants.turnP*error;
    power +=DriveConstants.turnD*( error-previous_error);
    previous_error =error;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (Math.abs(m_currentAngle-m_targetAngle) < DriveConstants.accuracy);
  }
}
