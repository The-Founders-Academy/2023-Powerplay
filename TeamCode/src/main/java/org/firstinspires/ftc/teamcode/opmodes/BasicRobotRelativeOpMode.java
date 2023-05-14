package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.XDrive;
import org.firstinspires.ftc.teamcode.utilities.RobotOdometry;

@TeleOp(name="POWERPLAY Basic Robot Relative", group="Iterative Opmode")
public class BasicRobotRelativeOpMode extends OpMode {
    private XDrive m_xDrive;

    @Override
    public void init() {
        m_xDrive = new XDrive("front", "back", "left", "right", hardwareMap);
    }

    @Override
    public void loop() {
        m_xDrive.robotRelativeDrive(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);
    }
}
