package carSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    private static final int WEIGHT_DEFAULT = -1;
    private static final String COLOR_DEFAULT = "n/a";

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = WEIGHT_DEFAULT;
        this.color = COLOR_DEFAULT;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
        this.color = COLOR_DEFAULT;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
        this.weight = WEIGHT_DEFAULT;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        String weight = this.getWeight() == -1 ? "n/a" : String.valueOf(this.getWeight());
        String displacement = this.getEngine().getDisplacement() == -1 ? "n/a" :
                String.valueOf(this.getEngine().getDisplacement());

        sb.append(this.getModel()).append(":").append("\n");
        sb.append(this.getEngine().getModel()).append(":").append("\n");
        sb.append("Power: ").append(this.getEngine().getPower()).append("\n");
        sb.append("Displacement: ").append(displacement).append("\n");
        sb.append("Efficiency: ").append(this.getEngine().getEfficiency()).append("\n");
        sb.append("Weight: ").append(weight).append("\n");
        sb.append("Color: ").append(this.getColor());

        return sb.toString();
    }
}
