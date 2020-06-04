/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimbConstants;

public class ClimbSubsystem extends SubsystemBase {
  
  private final VictorSP climbMotor =new VictorSP(ClimbConstants.climbMotorPort);
  private final VictorSP climbMotor1 =new VictorSP(ClimbConstants.climbMotorPort1);

  
  public ClimbSubsystem() {

  }
  public  void runClimb(double speed) {
    climbMotor.set(speed);
    climbMotor1.set(-speed);
  }
  public void stopClimb(double speed){
    climbMotor.set(0);
    climbMotor1.set(0);
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
