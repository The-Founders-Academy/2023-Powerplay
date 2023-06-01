package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.XDrive;

@TeleOp(name="Field Relative Drive", group="Iterative Opmode")
public class FieldRelativeDrive extends OpMode {

    private XDrive m_xDrive;
    private Intake m_intake;

    @Override
    public void init() {
        m_xDrive = new XDrive("frontRight", "backLeft",  "frontLeft", "backRight", hardwareMap);
        m_intake = new Intake("intakeMotor", "intakeLeftClaw", "intakeRightClaw", hardwareMap);
    }

    @Override
    public void loop() {
        double velocityAngle = ((Math.toDegrees(Math.atan2(-gamepad1.left_stick_y, gamepad1.left_stick_x)) % 360) + 360) % 360;
        double velocityMagnitude = Math.sqrt(Math.pow(gamepad1.left_stick_x, 2) + Math.pow(gamepad1.left_stick_y, 2));
        double angularVelocity = gamepad1.right_stick_x;

        // In case we need to re-orient the robot at any time
        if(gamepad1.start) {
            m_xDrive.resetAngleToZero();
        }

        // Operator controls
        if(gamepad2.right_trigger != 0 && gamepad2.left_trigger == 0) {
            m_intake.close();
        }
        if(gamepad2.left_trigger != 00 && gamepad2.right_trigger == 0) {
            m_intake.open();
        }


        // XDrive code
        m_xDrive.update();
        m_xDrive.fieldRelativeDrive(velocityMagnitude, velocityAngle, angularVelocity);

        // Update telemetry
        telemetry.addData("robotRotationDegrees", m_xDrive.getRobotPose().getRotation().getAngleDegrees());
        telemetry.addData("velocityAngle", velocityAngle);
        telemetry.addData("leftStickX", gamepad1.left_stick_x);
        telemetry.addData("leftStickYNegative", -gamepad1.left_stick_y);
        telemetry.update();






    }


}
