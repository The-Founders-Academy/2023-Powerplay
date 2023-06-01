package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {
    private DcMotor shoulderMotor;
    private Servo leftClaw;
    private Servo rightClaw;

    public Intake(String mainMotorName, String leftClawName, String rightClawName, HardwareMap hardwareMap) {
        shoulderMotor = hardwareMap.get(DcMotor.class, mainMotorName);
        shoulderMotor.setDirection(DcMotorSimple.Direction.FORWARD); // TO-DO: test this!!! Forward or backward?? (+) power should go forward, (-) power should go backward!
        leftClaw = hardwareMap.get(Servo.class, leftClawName);
        rightClaw = hardwareMap.get(Servo.class, rightClawName);
    }

    // TO-DO: test these position values.
    public void close() {
        leftClaw.setPosition(0.25);
        rightClaw.setPosition(0.75);
    }

    public void open() {
        leftClaw.setPosition(0);
        rightClaw.setPosition(1.00);
    }

    public void rotateInwards(double power) {
        shoulderMotor.setPower(-power);
    }

    public void rotateOutwards(double power) {
        shoulderMotor.setPower(power);
    }



}
