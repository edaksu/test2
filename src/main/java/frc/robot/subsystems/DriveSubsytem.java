/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsytem extends SubsystemBase {
  /**
   * Creates a new DriveSubsytem.
   */
  private final VictorSP frontLeftMotor = new VictorSP(DriveConstants.frontLeftMotorPin);
  private final VictorSP frontRightMotor = new VictorSP(DriveConstants.frontRightMotorPin);
  private final VictorSP rearLeftMotor = new VictorSP(DriveConstants.rearLeftMotorPin);
  private final VictorSP rearRightMotor = new VictorSP(DriveConstants.rearRightMotorPin);

  private final SpeedControllerGroup leftGroup = new SpeedControllerGroup(frontLeftMotor, rearLeftMotor);
  private final SpeedControllerGroup rightGroup = new SpeedControllerGroup(frontRightMotor, rearRightMotor);

  private final DifferentialDrive m_drive = new DifferentialDrive(leftGroup, rightGroup);

  public DriveSubsytem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void arcadeDrive(double fwd, double rot) {
    m_drive.arcadeDrive(fwd, rot, true);
  }
}
