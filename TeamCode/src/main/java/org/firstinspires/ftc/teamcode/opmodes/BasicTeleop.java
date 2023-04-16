package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="Basic: Iterative OpMode", group="Iterative Opmode")
public class BasicTeleop extends OpMode {

    private XDrive m_xDrive;

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        double angularSpeed = -gamepad1.right_stick_x;

        left.setDirection(DcMotorSimple.Direction.REVERSE);
        right.setDirection(DcMotorSimple.Direction.FORWARD);
        front.setDirection(DcMotorSimple.Direction.REVERSE);
        back.setDirection(DcMotorSimple.Direction.FORWARD);
        left.setPower(-gamepad1.left_stick_y +  angularSpeed);
        right.setPower(-gamepad1.left_stick_y - angularSpeed);
        front.setPower( gamepad1.left_stick_x + angularSpeed);
        back.setPower(gamepad1.left_stick_x - angularSpeed);
    }
}
