/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  //private static final String m_drive = null;
  private final VictorSP driveMotor1 = new VictorSP(DriveConstants.driveMotorPort1);
  private final VictorSP driveMotor2 = new VictorSP(DriveConstants.driveMotorPort2);


  private final ADXRS450_Gyro gyro= new ADXRS450_Gyro();

  private final Encoder Encoder=new Encoder(Constants.DriveConstants.EncoderPort1,
  Constants.DriveConstants.EncoderPort2, true, EncodingType.k4X);

  private final Encoder Encoder1=new Encoder(Constants.DriveConstants.EncoderPort3,
  Constants.DriveConstants.EncoderPort4, true, EncodingType.k4X);
 
 
  public DriveSubsystem() {
    gyro.calibrate();
    Encoder.setDistancePerPulse((1.0/2048)*15.24*Math.PI);
    Encoder1.setDistancePerPulse((1.0/2048)*15.24*Math.PI);


  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public double getHeading(){
    return Math.IEEEremainder(-1*gyro.getAngle(), 360);
  }
 
 
  public double getDistance(){
     return (Encoder1.getDistance()+ Encoder.getDistance())/2;
   
  }
  //public void arcadeDrive(double fwd, double rot) {
    //m_drive.arcadeDrive(fwd, rot, true);
  //}
  
  
 
  
}

