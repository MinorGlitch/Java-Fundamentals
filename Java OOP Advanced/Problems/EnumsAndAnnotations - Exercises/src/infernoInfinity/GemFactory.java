package infernoInfinity;

public class GemFactory {
    public static Gem createGem(String type) {
        Gem gem  = Enum.valueOf(Gem.class, type);

        switch (gem) {
            case RUBY:
                return Gem.RUBY;
            case EMERALD:
                return Gem.EMERALD;
            case AMETHYST:
                return Gem.AMETHYST;
            default:
                return null;
        }
    }
}
