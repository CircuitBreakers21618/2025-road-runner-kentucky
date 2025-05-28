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


        Pose2d beginPose = new Pose2d(0, 71, -Math.PI / 2);

        //calling hardwareMap
        MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);

        waitForStart();

        if (isStopRequested()) return;
        Actions.runBlocking(
                drive.actionBuilder(beginPose)
                        .lineToY(24)
                        .waitSeconds(2)
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-20, 43, Math.toRadians(45)), // Target pose
                                Math.toRadians(0)                      // Tangent angle
                        )
                        .turn(-Math.toRadians(90))
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-32, 43, Math.toRadians(45)), // Target pose
                                Math.toRadians(270)                      // Tangent angle
                        )
                        .waitSeconds(0.1)
                        .turn(-Math.toRadians(90))
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-40, 43, Math.toRadians(45)), // Target pose
                                Math.toRadians(270)                      // Tangent angle
                        )
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-47, 60, Math.toRadians(265)), // Target pose
                                Math.toRadians(270)                      // Tangent angle
                        )
                        .setReversed(true)
                        .lineToY(74)
                        .strafeTo(new Vector2d(-.08, 36))//2
                        .strafeTo(new Vector2d(-47, 63))
                        .strafeTo(new Vector2d(-1.3, 36))//3
                        .strafeTo(new Vector2d(-47, 63))
                        .strafeTo(new Vector2d(-1.5, 36))//4
                        .strafeTo(new Vector2d(-47, 63))
                        .strafeTo(new Vector2d(-1.8, 36))//5

                        .build());

    }
}
