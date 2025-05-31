package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.rowlandhall.meepmeep.MeepMeep;
import org.rowlandhall.meepmeep.roadrunner.DefaultBotBuilder;
import org.rowlandhall.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(500);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(0, 71, -Math.PI / 2))
                        .forward(35)
                        .waitSeconds(2)
                        .setReversed(true).splineToLinearHeading(
                                new Pose2d(-36, 43, Math.toRadians(45)), // Target pose
                                Math.toRadians(0)                      // Tangent angle
                        )
                        .turn(-Math.toRadians(90))
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-42, 43, Math.toRadians(45)), // Target pose
                                Math.toRadians(270)                      // Tangent angle
                        )
                        .waitSeconds(0.1)
                        .turn(-Math.toRadians(90))
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-48, 43, Math.toRadians(45)), // Target pose
                                Math.toRadians(270)                      // Tangent angle
                        )
                        .setReversed(true)
                        .splineToLinearHeading(
                                new Pose2d(-47, 60, Math.toRadians(270)), // Target pose
                                Math.toRadians(270)                      // Tangent angle
                        )
                        .setReversed(true)
                        .back(3)
                        .strafeTo(new Vector2d(-.08, 36))//2
                        .strafeTo(new Vector2d(-47, 63))
                        .strafeTo(new Vector2d(-1.3, 36))//3
                        .strafeTo(new Vector2d(-47, 63))
                        .strafeTo(new Vector2d(-1.5, 36))//4
                        .strafeTo(new Vector2d(-47, 63))
                        .strafeTo(new Vector2d(-1.8, 36))//5
                       .build());
        myBot.setDimensions(16, 16.5);
        meepMeep.setBackground(MeepMeep.Background.FIELD_INTOTHEDEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}