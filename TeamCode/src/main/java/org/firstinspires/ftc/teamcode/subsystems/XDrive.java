package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;

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
    }

    public void fieldRelativeDrive(double velocityX, double velocityY, double angularVelocity) {

    }
}
