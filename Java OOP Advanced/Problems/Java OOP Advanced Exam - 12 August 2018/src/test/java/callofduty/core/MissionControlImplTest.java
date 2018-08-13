package callofduty.core;

import callofduty.domain.missions.EscortMission;
import callofduty.domain.missions.HuntMission;
import callofduty.domain.missions.SurveillanceMission;
import callofduty.interfaces.Agent;
import callofduty.interfaces.BountyAgent;
import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionControl;
import org.junit.*;
import org.mockito.Mockito;

public class MissionControlImplTest {
    private MissionControl missionControl;
    private Mission resultMission;

    @Before
    public void setUp() {
        this.missionControl = new MissionControlImpl();

    }

    @Test
    public void generateMission() {
        BountyAgent agent = Mockito.mock(BountyAgent.class);
        Mockito.when(agent.getId()).thenReturn("agent");
        Mockito.when(agent.getRating()).thenReturn(15D);
        Mockito.when(agent.getBounty()).thenReturn(100D);

        this.resultMission = this.missionControl.generateMission(agent.getId(), agent.getRating(), agent.getBounty());

        String expectedId = "agent";
        Double expectedRating = 11.25D;
        Double expectedBounty = 125D;

        Assert.assertEquals(resultMission.getId(), expectedId);
        Assert.assertEquals(resultMission.getRating(), expectedRating);
        Assert.assertEquals(resultMission.getBounty(), expectedBounty);
    }

    @Test
    public void testInvalidId() {
        Agent agent = Mockito.mock(Agent.class);
        Mockito.when(agent.getId()).thenReturn("123456789");

        String expected = "12345678";

        this.resultMission =
                this.missionControl.generateMission(agent.getId(), 25.55, 75.0);

        Assert.assertEquals(resultMission.getId(), expected);
    }

    @Test
    public void testNegativeRating() {
        Agent agent = Mockito.mock(Agent.class);
        Mockito.when(agent.getRating()).thenReturn(-1.1);
        Mockito.when(agent.getId()).thenReturn("123456789");

        double expected = 0.0D;

        this.resultMission =
                this.missionControl.generateMission(agent.getId(), agent.getRating(), 75.0);

        Assert.assertEquals(resultMission.getRating(), expected, 0.0);
    }

    @Test
    public void testPositiveRating() {
        Agent agent = Mockito.mock(Agent.class);
        Mockito.when(agent.getRating()).thenReturn(999.9);
        Mockito.when(agent.getId()).thenReturn("123456789");

        Double expected = 75D;

        this.resultMission =
                this.missionControl.generateMission(agent.getId(), agent.getRating(), 75.0);

        Assert.assertEquals(resultMission.getRating(), expected);
    }

    @Test
    public void testNegativeBounty() {
        BountyAgent agent = Mockito.mock(BountyAgent.class);

        Mockito.when(agent.getBounty()).thenReturn(-1.23);
        Mockito.when(agent.getId()).thenReturn("123456789");

        Double expected = 0D;

        this.resultMission =
                this.missionControl.generateMission(agent.getId(), 22.2, agent.getBounty());

        Assert.assertEquals(resultMission.getBounty(), expected);
    }

    @Test
    public void testPositiveBounty() {
        BountyAgent agent = Mockito.mock(BountyAgent.class);

        Mockito.when(agent.getBounty()).thenReturn(200000D);
        Mockito.when(agent.getId()).thenReturn("123456789");

        Double expected = 125000D;

        this.resultMission =
                this.missionControl.generateMission(agent.getId(), 22.2, agent.getBounty());

        Assert.assertEquals(resultMission.getBounty(), expected);
    }

    @Test
    public void testIteratorMissionType() {
        Agent agent = Mockito.mock(Agent.class);
        Mockito.when(agent.getRating()).thenReturn(-1.1);
        Mockito.when(agent.getId()).thenReturn("123456789");

        this.resultMission =
                this.missionControl.generateMission(agent.getId(), agent.getRating(), 75.0);

        Assert.assertTrue(resultMission instanceof EscortMission);

        this.resultMission =
                this.missionControl.generateMission(agent.getId(), agent.getRating(), 75.0);

        Assert.assertTrue(resultMission instanceof HuntMission);

        this.resultMission =
                this.missionControl.generateMission(agent.getId(), agent.getRating(), 75.0);

        Assert.assertTrue(resultMission instanceof SurveillanceMission);
    }
}