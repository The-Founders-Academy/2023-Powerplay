package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.XDrive;

@TeleOp(name="Field Relative Drive", group="Iterative Opmode")
public class FieldRelativeDrive extends OpMode {

    private XDrive m_xDrive;

    @Override
    public void init() {
        m_xDrive = new XDrive("front", "back",  "left", "right", hardwareMap);
    }

    @Override
    public void loop() {
        double velocityAngle = Math.atan2(gamepad1.left_stick_x, -gamepad1.left_stick_y);
        double velocityMagnitude = Math.sqrt(Math.pow(gamepad1.left_stick_x, 2) + Math.pow(gamepad1.left_stick_y, 2));
        double angularVelocity = gamepad1.left_stick_x;
        m_xDrive.fieldRelativeDrive(velocityMagnitude, velocityAngle, angularVelocity);
    }
}
