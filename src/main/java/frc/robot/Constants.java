/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import frc.robot.subsystems.ShooterConnection;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public final class IntakeConstants{
        public static final int backIntakeMotorPort = 0;
        public static final int frontIntakeMotorPort = 1;
        public static final int intakeMotorPort =2;
        public static final int HallEffectPort = 3;
    }
    
    public final static class DriveConstants {
        public static final int driveMotorPort1 = 0;
        public static final int driveMotorPort2 = 1;
        public static final int driveMotorPort3 = 6;
        public static final int driveMotorPort4 = 7;
        public static final int EncoderPort1 = 2;
        public static final int EncoderPort2 = 3;
        public static final int EncoderPort3 = 4;
        public static final int EncoderPort4 = 5;

        public static final double turnP = 1.0;
        public static final double turnI = 0.0;
        public static final double turnD = 0.0;

        public static final double accuracy = 1.0;
        public static final double accuracy2 = 2.0;

        public static final double ksVolts = 0.22;
        public static final double kvVoltSecondsPerMeter = 1.98;
        public static final double kaVoltSecondsSquaredPerMeter = 0.2;

        public static final double kPDriveVel = 8.5;
        public static final double kTrackwidthMeters = 0.69;
        public static final DifferentialDriveKinematics kDriveKinematics = new DifferentialDriveKinematics(
                kTrackwidthMeters);

        public static final double kMaxSpeedMetersPerSecond = 3;
        public static final double kMaxAccelerationMetersPerSecondSquared = 3;
        public static final double kRamseteB = 2;
        public static final double kRamseteZeta = 0.7;

    }
    public final class ShooterConnectionConstants{
        public static final int connectionMotorPort =0;
        public static final int connectionMotorPort1 =1;
    }
    public final class ClimbConstants{
        public static final int climbMotorPort =0;
        public static final int climbMotorPort1=1;
    }
    public final class JoystickConstants{
        public static final int driverControllerPort = 0;
    }
    public final class ShooterConstants{
        public static final int shooterEncoder_A = 0;
         public static final int shooterEncoder_B = 1;
         public static final int shooterEncoder_D =2;
         public static final int shooterEncoder_C = 3; 
         public static final int shooterMotorPort1= 4;
         public static final int shooterMotorPort2 = 5;

    }
    public final class HopperConstants {
        public static final int hopperMotorPort = 1;
    }
}
