package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "SP 5 specimen", group = "2024-25 SP")
public class Auto15specimen extends LinearOpMode{

    armintialization LineraMecanizmeteleop = new armintialization();


    @Override
    public void runOpMode(){


        LineraMecanizmeteleop.init(hardwareMap);

        Pose2d beginPose = new Pose2d(-71, 0, 0);

        //calling hardwareMap
        MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);

        waitForStart();

        if (isStopRequested()) return;
        Actions.runBlocking(
                drive.actionBuilder(beginPose)
                        .lineToX(-40)
                        .afterTime(2,LineraMecanizmeteleop.hang_specimen())
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-33, -47, Math.toRadians(140)), // Target pose
                                Math.toRadians(135)                      // Tangent angle
                        )
                        .afterTime(1,LineraMecanizmeteleop.push_block())
                        .turn(-Math.toRadians(60))
                        .afterTime(1,LineraMecanizmeteleop.up_claw())
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-33, -54, Math.toRadians(140)), // Target pose
                                Math.toRadians(135)                      // Tangent angle
                        )
                        .waitSeconds(0.1)
                        .afterTime(1,LineraMecanizmeteleop.down_claw())
                        .turn(-Math.toRadians(60))
                        .afterTime(1,LineraMecanizmeteleop.up_claw())
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-33, -60, Math.toRadians(140)), // Target pose
                                Math.toRadians(135)                      // Tangent angle
                        )
                        .waitSeconds(0.3)
                        .afterTime(2.5,LineraMecanizmeteleop.retracked_claw())
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-71, -45, Math.toRadians(0)), // Target pose
                                Math.toRadians(180)                      // Tangent angle
                        )
                        .setReversed(true)
                        .lineToX(-68)
                        .strafeTo(new Vector2d(-40, 0))//2
                        .strafeTo(new Vector2d(-71, -45))
                        .strafeTo(new Vector2d(-40, -.8))//3
                        .strafeTo(new Vector2d(-71, -45))
                        .strafeTo(new Vector2d(-40, -1))//4
                        .strafeTo(new Vector2d(-71, -45))
                        .strafeTo(new Vector2d(-40, -1.8))//5

                        .build());

    }
}
