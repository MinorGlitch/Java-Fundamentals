package callofduty.core;

import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionControl;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static callofduty.domain.constants.MissionBoundsConstants.*;

public class MissionControlImpl implements MissionControl {


    private Map<String, Class> missionClasses;

    private Iterator<Map.Entry<String, Class>> missionIterator;

    public MissionControlImpl() {
        this.initMissionClasses();
        this.missionIterator = this.missionClasses
                .entrySet()
                .iterator();
    }

    private void initMissionClasses() {
        try {
            this.missionClasses = new LinkedHashMap<>() {{
                put("EscortMission", Class.forName("callofduty.domain.missions.EscortMission"));
                put("HuntMission", Class.forName("callofduty.domain.missions.HuntMission"));
                put("SurveillanceMission", Class.forName("callofduty.domain.missions.SurveillanceMission"));
            }};
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String validateMissionId(String missionId) {
        return missionId.length() > MISSION_ID_MAXIMUM_LENGTH
                ? missionId.substring(0, MISSION_ID_MAXIMUM_LENGTH)
                : missionId;
    }

    private Double validateMissionRating(Double missionRating) {
        return missionRating < MISSION_RATING_MINIMUM_VALUE
                ? MISSION_RATING_MINIMUM_VALUE
                : (missionRating > MISSION_RATING_MAXIMUM_VALUE
                ? MISSION_RATING_MAXIMUM_VALUE
                : missionRating);
    }

    private Double validateMissionBounty(Double missionBounty) {
        return missionBounty < MISSION_BOUNTY_MINIMUM_VALUE
                ? MISSION_BOUNTY_MINIMUM_VALUE
                : (missionBounty > MISSION_BOUNTY_MAXIMUM_VALUE
                ? MISSION_BOUNTY_MAXIMUM_VALUE
                : missionBounty);
    }

    private void restartMissionIterator() {
        this.missionIterator = this
                .missionClasses
                .entrySet()
                .iterator();
    }

    private Class currentMission() {
        if (!this.missionIterator.hasNext()) {
            this.restartMissionIterator();
        }

        return this.missionIterator.next().getValue();
    }

    private Mission instantiateMissionObject(String missionId, Double missionRating, Double missionBounty) {
        Mission missionObject = null;

        try {
            missionObject = (Mission)
                    this.currentMission()
                            .getConstructor(String.class, Double.class, Double.class)
                            .newInstance(missionId, missionRating, missionBounty);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException ignored) {

        }

        return missionObject;
    }

    @Override
    public Mission generateMission(String missionId, Double missionRating, Double missionBounty) {
        missionId = this.validateMissionId(missionId);
        missionRating = this.validateMissionRating(missionRating);
        missionBounty = this.validateMissionBounty(missionBounty);

        return this.instantiateMissionObject(missionId, missionRating, missionBounty);
    }


}