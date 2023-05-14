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
        double velocityAngle = ((Math.toDegrees(Math.atan2(-gamepad1.left_stick_y, gamepad1.left_stick_x)) % 360) + 360) % 360;
        double velocityMagnitude = Math.sqrt(Math.pow(gamepad1.left_stick_x, 2) + Math.pow(gamepad1.left_stick_y, 2));
        double angularVelocity = gamepad1.right_stick_x;
        if(gamepad1.a) {
            m_xDrive.resetAngleToZero();
        }
        m_xDrive.update();
        telemetry.addData("robotRotationDegrees", m_xDrive.getRobotPose().getRotation().getAngleDegrees());
        telemetry.addData("velocityAngle", velocityAngle);
        telemetry.addData("leftStickX", gamepad1.left_stick_x);
        telemetry.addData("leftStickYNegative", -gamepad1.left_stick_y);
        telemetry.update();
        m_xDrive.fieldRelativeDrive(velocityMagnitude, velocityAngle, angularVelocity);
    }
}
