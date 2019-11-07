package com.fuzs.letmesleep.helper;

import com.fuzs.letmesleep.LetMeSleep;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.lang.reflect.Method;

public class ReflectionHelper {

    private static final String ENTITYPLAYER_BED_IN_RANGE = "func_190774_a";
    private static final String ENTITYPLAYER_SPAWN_SHOULDER_ENTITIES = "func_192030_dh";
    private static final String ENTITYPLAYER_SET_SIZE = "func_70105_a";
    private static final String ENTITYPLAYER_SET_RENDER_OFFSET_FOR_SLEEP = "func_175139_a";
    private static final String ENTITYPLAYER_SLEEPING = "field_71083_bS";
    private static final String ENTITYPLAYER_SLEEP_TIMER = "field_71076_b";
    private static final String ENTITYLIVINGBASE_ON_FINISHED_POTION_EFFECT = "func_70688_c";
    private static final String WORLDSERVER_WAKE_ALL_PLAYERS = "func_73053_d";

    public static Method getBedInRange() {

        try {

            return ObfuscationReflectionHelper.findMethod(EntityPlayer.class, ENTITYPLAYER_BED_IN_RANGE, boolean.class, BlockPos.class, EnumFacing.class);

        } catch (Exception e) {

            LetMeSleep.LOGGER.error("getBedInRange() failed", e);

        }

        return null;

    }

    public static Method getSpawnShoulderEntities() {

        try {

            return ObfuscationReflectionHelper.findMethod(EntityPlayer.class, ENTITYPLAYER_SPAWN_SHOULDER_ENTITIES, void.class);

        } catch (Exception e) {

            LetMeSleep.LOGGER.error("getSpawnShoulderEntities() failed", e);

        }

        return null;

    }

    public static Method getSetSize() {

        try {

            return ObfuscationReflectionHelper.findMethod(Entity.class, ENTITYPLAYER_SET_SIZE, void.class, float.class, float.class);

        } catch (Exception e) {

            LetMeSleep.LOGGER.error("getSetSize() failed", e);

        }

        return null;

    }

    public static Method getSetRenderOffsetForSleep() {

        try {

            return ObfuscationReflectionHelper.findMethod(EntityPlayer.class, ENTITYPLAYER_SET_RENDER_OFFSET_FOR_SLEEP, void.class, EnumFacing.class);

        } catch (Exception e) {

            LetMeSleep.LOGGER.error("getSetRenderOffsetForSleep() failed", e);

        }

        return null;

    }

    public static void setSleeping(EntityPlayer instance, boolean flag) {

        try {

            ObfuscationReflectionHelper.setPrivateValue(EntityPlayer.class, instance, flag, ENTITYPLAYER_SLEEPING);

        } catch (Exception e) {

            LetMeSleep.LOGGER.error("setSleeping() failed", e);

        }

    }

    public static void setSleepTimer(EntityPlayer instance, int i) {

        try {

            ObfuscationReflectionHelper.setPrivateValue(EntityPlayer.class, instance, i, ENTITYPLAYER_SLEEP_TIMER);

        } catch (Exception e) {

            LetMeSleep.LOGGER.error("resetSleepTimer() failed", e);

        }

    }

    @SuppressWarnings("WeakerAccess")
    public static Method getOnFinishedPotionEffect() {

        try {

            return ObfuscationReflectionHelper.findMethod(EntityLivingBase.class, ENTITYLIVINGBASE_ON_FINISHED_POTION_EFFECT, void.class, PotionEffect.class);

        } catch (Exception e) {

            LetMeSleep.LOGGER.error("getOnFinishedPotionEffect() failed", e);

        }

        return null;

    }

    public static Method getWakeAllPlayers() {

        try {

            return ObfuscationReflectionHelper.findMethod(WorldServer.class, WORLDSERVER_WAKE_ALL_PLAYERS, void.class);

        } catch (Exception e) {

            LetMeSleep.LOGGER.error("getWakeAllPlayers() failed", e);

        }

        return null;

    }

}
