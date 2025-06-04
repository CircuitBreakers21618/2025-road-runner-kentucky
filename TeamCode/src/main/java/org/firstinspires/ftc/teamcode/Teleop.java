package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name ="teleop", group = "2024-25 SP")
//naming it
public class Teleop extends OpMode {
    chaseintialization driveteleop = new chaseintialization();
    armintialization LineraMecanizmeteleop = new armintialization();

    @Override
    public void init() {

        //calling hardwareMap
        driveteleop.init(hardwareMap);
        LineraMecanizmeteleop.init(hardwareMap);



    }

    @Override
    public void loop() {

        //seting powers
        driveteleop.leftFront.setPower(gamepad1.right_stick_y + -gamepad1.left_stick_x * 1.1 + -gamepad1.right_stick_x);
        driveteleop.leftBack.setPower(-gamepad1.right_stick_y + -gamepad1.left_stick_x * 1.1+ gamepad1.right_stick_x);
        driveteleop.rightFront.setPower(gamepad1.right_stick_y + gamepad1.left_stick_x * 1.2 +gamepad1.right_stick_x);
        driveteleop.rightBack.setPower(-gamepad1.right_stick_y + -gamepad1.left_stick_x * 1.1 + -gamepad1.right_stick_x);
        LineraMecanizmeteleop.leftliner.setPower(-gamepad2.right_stick_y);
        LineraMecanizmeteleop.rightliner.setPower(gamepad2.right_stick_y);
        LineraMecanizmeteleop.forwardliner.setPower(gamepad2.left_stick_y);


        if (gamepad2.y){
            LineraMecanizmeteleop.toparm1.setPosition(1);

        }

        if (gamepad2.y){
            LineraMecanizmeteleop.toparm2.setPosition(-1);

        }
        if (gamepad2.a){
            LineraMecanizmeteleop.toparm1.setPosition(1);

        }

        if (gamepad2.a){
            LineraMecanizmeteleop.toparm2.setPosition(-1);

        }
        if (gamepad2.b){
            LineraMecanizmeteleop.topclaw.setPosition(1);

        }

        if (gamepad2.x){
            LineraMecanizmeteleop.topclaw.setPosition(0);

        }



    }
}