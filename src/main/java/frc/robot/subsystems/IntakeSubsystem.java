/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {
  private final VictorSP backintakemotor= new VictorSP(IntakeConstants.backIntakeMotorPort); //intake'i açıp kapamak için
 private final VictorSP frontintakemotor= new VictorSP(IntakeConstants.frontIntakeMotorPort);

 private final VictorSP intakemotor = new VictorSP (IntakeConstants.intakeMotorPort);

 private final DigitalInput HallEffect = new DigitalInput(IntakeConstants.HallEffectPort);

  public IntakeSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public  void runIntake(double speed) {
    backintakemotor.set(speed);
    frontintakemotor.set(-speed);
  }

  public void stopIntake() {
    backintakemotor.set(0);
    frontintakemotor.set(0);
  }
  public class RingBuffer {
    
    int length;
    int idx = 0;
    double[] buffer; 
    
    public RingBuffer(int length){
        this.length = length;
        buffer = new double[length];
    }
    
    
    
    public void add(double newVal){
        buffer[idx] = newVal;
        idx++; 
        if( idx >= buffer.length){
            idx = 0;
        }        
    }
    
    public double getAverage(){
        double total = 0;
        for(int i = 0; i < buffer.length; i++){
            total += buffer[i];
        }
        return total/buffer.length;
    }
}
 
}


