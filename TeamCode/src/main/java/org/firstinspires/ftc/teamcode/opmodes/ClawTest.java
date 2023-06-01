package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.subsystems.XDrive;

@TeleOp(name="ArmClawTest", group="Iterative Opmode")
public class ClawTest extends OpMode {

    private DcMotor shoulder;
    private Servo leftClaw;
    private Servo rightClaw;

    @Override
    public void init() {
        shoulder = hardwareMap.get(DcMotor.class, "bigMotor");
        leftClaw = hardwareMap.get(Servo.class, "leftClaw");
        rightClaw = hardwareMap.get(Servo.class, "rightClaw");

        shoulder.setDirection(DcMotor.Direction.FORWARD);
        leftClaw.setDirection(Servo.Direction.FORWARD);
        rightClaw.setDirection(Servo.Direction.REVERSE);
    }

    @Override
    public void loop() {
        shoulder.setPower(-gamepad1.left_stick_y/2);
        double r = (gamepad1.a ? 0.05 : 0);
        leftClaw.setPosition(leftClaw.getPosition() + r);
        rightClaw.setPosition(rightClaw.getPosition() + r);

        double s = (gamepad1.b ? 0.05 : 0);
        leftClaw.setPosition(leftClaw.getPosition() - s);
        rightClaw.setPosition(rightClaw.getPosition() - s);
    }
}
