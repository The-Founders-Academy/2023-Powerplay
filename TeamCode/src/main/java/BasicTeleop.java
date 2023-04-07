import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp(name="Basic: Iterative OpMode", group="Iterative Opmode")
public class BasicTeleop extends OpMode {

    private DcMotor front;
    private DcMotor back;
    private DcMotor left;
    private DcMotor right;

    @Override
    public void init() {
        front = hardwareMap.get(DcMotor.class, "front");
        back = hardwareMap.get(DcMotor.class, "back");
        left = hardwareMap.get(DcMotor.class, "left");
        right = hardwareMap.get(DcMotor.class, "right");
    }
// left = 2
    // front = 0
    // right = 1
    @Override
    public void loop() {
        left.setDirection(DcMotorSimple.Direction.FORWARD);
        left.setDirection(DcMotorSimple.Direction.FORWARD);
        left.setPower(gamepad1.left_stick_y);
        right.setPower(gamepad1.left_stick_y);
    }
}
