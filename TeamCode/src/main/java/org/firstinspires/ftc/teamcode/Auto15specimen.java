package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "SP 5 specimen", group = "2024-25 SP")
public class Auto15specimen extends LinearOpMode{



    @Override
    public void runOpMode(){


        Pose2d beginPose = new Pose2d(71, 0, -Math.PI / 2);

        //calling hardwareMap
        MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);

        waitForStart();

        if (isStopRequested()) return;
        Actions.runBlocking(
                drive.actionBuilder(beginPose)
                        .lineToX(36)
                        .waitSeconds(2)
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(43, -20, Math.toRadians(45)), // Target pose
                                Math.toRadians(0)                      // Tangent angle
                        )
                        .turn(-Math.toRadians(90))
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(43, -32, Math.toRadians(45)), // Target pose
                                Math.toRadians(270)                      // Tangent angle
                        )
                        .waitSeconds(0.1)
                        .turn(-Math.toRadians(90))
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(43, -40, Math.toRadians(45)), // Target pose
                                Math.toRadians(270)                      // Tangent angle
                        )
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(60, -47, Math.toRadians(270)), // Target pose
                                Math.toRadians(270)                      // Tangent angle
                        )
                        .setReversed(true)
                        .lineToX(74)
                        .strafeTo(new Vector2d(36, -.08))//2
                        .strafeTo(new Vector2d(63, -47))
                        .strafeTo(new Vector2d(36, -1.3))//3
                        .strafeTo(new Vector2d(63, -47))
                        .strafeTo(new Vector2d(36, -1.5))//4
                        .strafeTo(new Vector2d(63, -47))
                        .strafeTo(new Vector2d(36, -1.8))//5

                        .build());

    }
}
