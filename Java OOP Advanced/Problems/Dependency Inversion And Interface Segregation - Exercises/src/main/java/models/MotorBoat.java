package models;

import Utility.Constants;
import Utility.Validator;
import models.boats.IBoat;
import models.races.IRace;
import models.engines.JetEngine;
import models.engines.SterndriveEngine;

import java.util.List;

public final class MotorBoat {

    public double CalculateRaceSpeed(IRace race) {
        //if (this.getJetEngines().size() + this.getSterndriveEngines().size() == 2) {
        //    var speed = this.JetEngines.Sum(x = > x.Output)+this.SterndriveEngines.Sum(x = > x.Output)
        //    -this.Weight + (race.OceanCurrentSpeed / 5d);
        //    return speed;
        //} else if (this.getJetEngines().size() + this.getSterndriveEngines().size() == 1) {
        //    var speed = this.JetEngines.Sum(x = > x.Output)+this.SterndriveEngines.Sum(x = > x.Output)
        //    -this.Weight - this.CargoWeight + (race.OceanCurrentSpeed / 2d);
        //    return speed;
        //} else if (isSailboat) {
        //    var speed = (race.WindSpeed * (this.SailEfficiency / 100d)) - this.Weight + (race.OceanCurrentSpeed / 2d);
        //    return speed;
        //} else {
        //    var speed = (this.Oars * 100) - this.Weight + race.OceanCurrentSpeed;
        //    return speed;
        //}
        return 0;
    }
}


