package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class XDrive {
    private DcMotor front;
    private DcMotor back;
    private DcMotor left;
    private DcMotor right;

    public XDrive(String frontName, String backName, String leftName, String rightName) {
        front = hardwareMap.get(DcMotor.class, frontName);
        back = hardwareMap.get(DcMotor.class, backName);
        left = hardwareMap.get(DcMotor.class, leftName);
        right = hardwareMap.get(DcMotor.class, rightName);

        // The wheel directions should exist such that applying equal power to opposite wheels moves the robot in one direction.
        left.setDirection(DcMotorSimple.Direction.REVERSE);
        right.setDirection(DcMotorSimple.Direction.FORWARD);
        front.setDirection(DcMotorSimple.Direction.REVERSE);
        back.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void fieldRelativeDrive(double velocityX, double velocityY, double angularSpeed) {

    }

    public void driveToPosition(double x, double y, double angleRadians) {

    }

    public void resetOdometry() {

    }
}
