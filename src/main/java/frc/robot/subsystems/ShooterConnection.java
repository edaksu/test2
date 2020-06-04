/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConnectionConstants;

public class ShooterConnection extends SubsystemBase {
 private final VictorSP connectionMotor= new VictorSP(ShooterConnectionConstants.connectionMotorPort);
 private final VictorSP connectionMotor1 = new VictorSP(ShooterConnectionConstants.connectionMotorPort1);
 
  public ShooterConnection() {

  }
  public void runConnection(double speed){
    connectionMotor.set(-speed);
    connectionMotor1.set (speed);
  }
  public void stopConnection(double speed){
    connectionMotor.set(0);
    connectionMotor1.set (0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
