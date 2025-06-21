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

        LineraMecanizmeteleop.topclaw.setPosition(0.1);
        sleep(500);
        LineraMecanizmeteleop.toparm1.setPosition(0.7);//moves to hang position
        LineraMecanizmeteleop.toparm2.setPosition(0.06);
        sleep(750);
        driveato.moveforward(-.5, 1200);
        driveato.stopmotor();
        LineraMecanizmeteleop.rightliner.setPower(-.3);
        LineraMecanizmeteleop.leftliner.setPower(.3);
        sleep(900);
        LineraMecanizmeteleop.rightliner.setPower(0);
        LineraMecanizmeteleop.leftliner.setPower(0);
        LineraMecanizmeteleop.topclaw.setPosition(0.6);
        driveato.moveforward(.5, 1100);
        driveato.stopmotor();
        driveato.RightTurn(.5, 1000);
        driveato.stopmotor();
        driveato.moveforward(.5, 2200);
        driveato.stopmotor();
    }

}
