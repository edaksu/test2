/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.JoystickConstants;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.JoystickDrive;
import frc.robot.commands.RunClimb;
import frc.robot.commands.RunConnection;
import frc.robot.commands.RunIntake;
import frc.robot.commands.RunShooter;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.HopperSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterConnection;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private final IntakeSubsystem m_intake= new IntakeSubsystem();
  private final ShooterSubsystem m_shooter = new ShooterSubsystem();
  private final HopperSubsystem m_hopper = new HopperSubsystem();
  private final DriveSubsystem m_drive = new DriveSubsystem();
  private final ClimbSubsystem m_climb =new ClimbSubsystem();
  private final ShooterConnection m_connection = new ShooterConnection();


  
  public Joystick m_driverController = new Joystick(JoystickConstants.driverControllerPort);

  

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_drive.setDefaultCommand(
        new JoystickDrive(m_drive, () -> -m_driverController.getRawAxis(1),
         () -> m_driverController.getRawAxis(0)));
  }

private void configureButtonBindings() {
 
    new JoystickButton(m_driverController, 1).whileHeld(new RunIntake(m_intake, 0.8));

    new JoystickButton(m_driverController, 2).whileHeld(new RunIntake(m_intake, -0.8));
    
    new JoystickButton(m_driverController, 3).whileHeld(new RunShooter(m_shooter, 1));
    
    new JoystickButton(m_driverController, 4).whileHeld(new RunShooter(m_shooter, -1));

    new JoystickButton(m_driverController, 5).whenPressed(new RunClimb(m_climb,0.8));

    new JoystickButton(m_driverController, 6).whenPressed(new RunClimb(m_climb,-0.8));

    new JoystickButton(m_driverController, 7).whenPressed(new RunConnection(m_connection,1));

    new JoystickButton(m_driverController, 8).whenPressed(new RunConnection(m_connection,1));
  
}
}

 
  
    
  

