package org.firstinspires.ftc.teamcode;

import static android.os.SystemClock.sleep;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
public class auto_1 extends LinearOpMode {
    armintialization LineraMecanizmeteleop = new armintialization();
    chaseintialization driveato = new chaseintialization();


    @Override
    public void runOpMode() throws InterruptedException {

        LineraMecanizmeteleop.init(hardwareMap);
        driveato.init(hardwareMap);

        waitForStart();

        LineraMecanizmeteleop.topclaw.setPosition(0.15);
        sleep(500);
        LineraMecanizmeteleop.toparm1.setPosition(0.7);//moves to hang position
        LineraMecanizmeteleop.toparm2.setPosition(0.06);
        driveato.moveforward(-1, 1000);
        driveato.stopmotor();
        LineraMecanizmeteleop.rightliner.setPower(-.5);
        LineraMecanizmeteleop.leftliner.setPower(.5);
        sleep(2000);
        LineraMecanizmeteleop.rightliner.setPower(0);
        LineraMecanizmeteleop.leftliner.setPower(0);
        LineraMecanizmeteleop.topclaw.setPosition(0.6);
        driveato.moveforward(1, 500);
        driveato.stopmotor();
        driveato.RightTurn(.5, 750);
        driveato.stopmotor();
        driveato.moveforward(-1, 750);
        driveato.stopmotor();
        driveato.LeftTurn(.5, 750);
        driveato.stopmotor();
        driveato.moveforward(1, 500);

    }

}
