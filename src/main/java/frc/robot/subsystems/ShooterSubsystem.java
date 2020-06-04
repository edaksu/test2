/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {
 
  private final Encoder shooterEncoder1 = new Encoder(ShooterConstants.shooterEncoder_A,ShooterConstants.shooterEncoder_B,false,EncodingType.k4X);
  private final Encoder shooterEncoder2= new Encoder(ShooterConstants.shooterEncoder_C,ShooterConstants.shooterEncoder_D,false,EncodingType.k4X);

  private final Talon shooterMotor1 = new Talon ( ShooterConstants.shooterMotorPort1);
  private final Talon shooterMotor2= new Talon ( ShooterConstants.shooterMotorPort2);
  

 

  public ShooterSubsystem() {

  }
  
  public Encoder getShooterEncoder1() {
    return shooterEncoder1;
  }
  public Encoder getShooterEncoder2 (){
    return shooterEncoder2;
  }
  public void runShooter(double speed) {
    shooterMotor1.set(speed);
    shooterMotor2.set(-speed);
  }
  public void stopShooter() {
    shooterMotor1.set(0);
    shooterMotor2.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
