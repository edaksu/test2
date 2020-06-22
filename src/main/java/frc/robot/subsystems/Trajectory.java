/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.List;


import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import frc.robot.Constants.DriveConstants;
import frc.robot.commands.centerLeft4Cell;

/**
 * Add your docs here.
 */
public class Trajectory {
	public static final Trajectory[] CenterRight0Cell = null;
	public Trajectory centerLeft4Cell[];
    private DriveSubsystem m_drive;
	public Trajectory[] CenterLeft0Cell;
    public Trajectory(DriveSubsystem drive ){
        var autoVoltageConstraint =
        new DifferentialDriveVoltageConstraint(
            new SimpleMotorFeedforward(DriveConstants.ksVolts,
                                       DriveConstants.kvVoltSecondsPerMeter,
                                       DriveConstants.kaVoltSecondsSquaredPerMeter),
            DriveConstants.kDriveKinematics,
            10);

            TrajectoryConfig config =
        new TrajectoryConfig(DriveConstants.kMaxSpeedMetersPerSecond,
                             DriveConstants.kMaxAccelerationMetersPerSecondSquared)
            // Add kinematics to ensure max speed is actually obeyed
            .setKinematics(DriveConstants.kDriveKinematics)
            // Apply the voltage constraint
            .addConstraint(autoVoltageConstraint);

            TrajectoryConfig configReversed =
            new TrajectoryConfig(DriveConstants.kMaxSpeedMetersPerSecond,
                                 DriveConstants.kMaxAccelerationMetersPerSecondSquared)
                // Add kinematics to ensure max speed is actually obeyed
                .setKinematics(DriveConstants.kDriveKinematics)
                // Apply the voltage constraint
                .addConstraint(autoVoltageConstraint);

            config.setReversed(true);

            centerLeft4Cell[0]= TrajectoryGenerator.generateTrajectory(
                List.of(
                    new Pose2d(12.80,5.79,new Rotation2d(0)),
                    new Pose2d(9.75,7.54,new Rotation2d(0)),
                    new Pose2d(12.80,5.79,new Rotation2d(0)),
                    config.setReversed(true) ;))

                config.setReversed(false);

                centerLeft4Cell[1]= TrajectoryGenerator.generateTrajectory(
                List.of(
                    new Pose2d(7.92,7.54,new Rotation2d(0)),
                    new Pose2d(10.97,5.79,new Rotation2d(0)),
                    new Pose2d(12.80,5.79,new Rotation2d(0)),
                    config.setReversed(false);))

                   
    }
    public RamseteCommand getRamsete(Trajectory trajectory)
    {
      return new RamseteCommand(
         trajectory,
         m_drive::getPose,
         new RamseteController(DriveConstants.kRamseteB, DriveConstants.kRamseteZeta),
         new SimpleMotorFeedforward(DriveConstants.ksVolts,
                                    DriveConstants.kvVoltSecondsPerMeter,
                                    DriveConstants.kaVoltSecondsSquaredPerMeter),
         DriveConstants.kDriveKinematics,
         m_drive::getWheelSpeeds,
         new PIDController(DriveConstants.kPDriveVel, 0, 0),
         new PIDController(DriveConstants.kPDriveVel, 0, 0),
         // RamseteCommand passes volts to the callback
         m_drive::tankDriveVolts,
         m_drive
     );
    }

   

                
              
    
                
           
}
 