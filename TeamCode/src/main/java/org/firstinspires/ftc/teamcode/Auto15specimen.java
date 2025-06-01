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


        Pose2d beginPose = new Pose2d(-71, 0, 0);

        //calling hardwareMap
        MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);

        waitForStart();

        if (isStopRequested()) return;
        Actions.runBlocking(
                drive.actionBuilder(beginPose)
                        .lineToX(-40)
                        .waitSeconds(1)
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-47, -21, Math.toRadians(155)), // Target pose
                                Math.toRadians(135)                      // Tangent angle
                        )

                        .turn(-Math.toRadians(60))
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-57, -33, Math.toRadians(155)), // Target pose
                                Math.toRadians(135)                      // Tangent angle
                        )
                        .waitSeconds(0.1)
                        .turn(-Math.toRadians(60))
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-60, -34, Math.toRadians(155)), // Target pose
                                Math.toRadians(135)                      // Tangent angle
                        )
                        .waitSeconds(0.3)
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-62, -55, Math.toRadians(0)), // Target pose
                                Math.toRadians(180)                      // Tangent angle
                        )
                        .setReversed(true)
                        .lineToX(-68)
                        .strafeTo(new Vector2d(0, 12))//2
                        .strafeTo(new Vector2d(-47, 63))
                        .strafeTo(new Vector2d(0.8, 12))//3
                        .strafeTo(new Vector2d(-47, 63))
                        .strafeTo(new Vector2d(1.5, 12))//4
                        .strafeTo(new Vector2d(-47, 63))
                        .strafeTo(new Vector2d(1.8, 12))//5

                        .build());

    }
}
