package com.anderson.andersonsmod.entity.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.entity.projectile.Snowball;

import java.util.EnumSet;

public class FrostEntityAttackGoal extends Goal{


        private final FrostEntity frost;
        private int attackStep;
        private int attackTime;
        private int lastSeen;

        public FrostEntityAttackGoal(FrostEntity frost) {
            this.frost = frost;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }
    public void performRangedAttack(LivingEntity pTarget, float pDistanceFactor) {
        Snowball snowball = new Snowball(this.frost.level, this.frost);
        double d0 = pTarget.getEyeY() - (double)1.1F;
        double d1 = pTarget.getX() - this.frost.getX();
        double d2 = d0 - snowball.getY();
        double d3 = pTarget.getZ() - this.frost.getZ();
        double d4 = Math.sqrt(d1 * d1 + d3 * d3) * (double)0.2F;
        snowball.shoot(d1, d2 + d4, d3, 1.6F, 5.0F);
        this.frost.playSound(SoundEvents.SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (this.frost.getRandom().nextFloat() * 0.4F + 0.8F));
        this.frost.level.addFreshEntity(snowball);
    }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean canUse() {
            LivingEntity livingentity = this.frost.getTarget();
            return livingentity != null && livingentity.isAlive() && this.frost.canAttack(livingentity);
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void start() {
            this.attackStep = 0;
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void stop() {
            this.frost.setCharged(false);
            this.lastSeen = 0;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            --this.attackTime;
            LivingEntity livingentity = this.frost.getTarget();
            if (livingentity != null) {
                boolean flag = this.frost.getSensing().hasLineOfSight(livingentity);
                if (flag) {
                    this.lastSeen = 0;
                } else {
                    ++this.lastSeen;
                }

                double d0 = this.frost.distanceToSqr(livingentity);
                if (d0 < 4.0D) {
                    if (!flag) {
                        return;
                    }

                    if (this.attackTime <= 0) {
                        this.attackTime = 20;
                        this.frost.doHurtTarget(livingentity);
                    }

                    this.frost.getMoveControl().setWantedPosition(livingentity.getX(), livingentity.getY(), livingentity.getZ(), 1.0D);
                } else if (d0 < this.getFollowDistance() * this.getFollowDistance() && flag) {
                    double d1 = livingentity.getX() - this.frost.getX();
                    double d2 = livingentity.getY(0.5D) - this.frost.getY(0.5D);
                    double d3 = livingentity.getZ() - this.frost.getZ();
                    if (this.attackTime <= 0) {
                        ++this.attackStep;
                        if (this.attackStep == 1) {
                            this.attackTime = 60;
                            this.frost.setCharged(true);
                        } else if (this.attackStep <= 4) {
                            this.attackTime = 6;
                        } else {
                            this.attackTime = 100;
                            this.attackStep = 0;
                            this.frost.setCharged(false);
                        }

                        if (this.attackStep > 1) {
                            double d4 = Math.sqrt(Math.sqrt(d0)) * 0.5D;
                            if (!this.frost.isSilent()) {
                                this.frost.level.levelEvent((Player)null, 1018, this.frost.blockPosition(), 0);
                            }

                            for(int i = 0; i < 1; ++i) {
                                performRangedAttack(livingentity,0);

                            }
                        }
                    }

                    this.frost.getLookControl().setLookAt(livingentity, 10.0F, 10.0F);
                } else if (this.lastSeen < 5) {
                    this.frost.getMoveControl().setWantedPosition(livingentity.getX(), livingentity.getY(), livingentity.getZ(), 1.0D);
                }

                super.tick();
            }
        }

        private double getFollowDistance() {
            return this.frost.getAttributeValue(Attributes.FOLLOW_RANGE);
        }

}

