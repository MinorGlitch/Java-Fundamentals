package telephony;

public class Smartphone implements BrowseWeb, CallPhone {

    public Smartphone() {

    }

    @Override
    public String browse(String site) {
        if (!isValidURL(site)) {
            throw new IllegalArgumentException("Invalid URL!");
        }
        return String.format("Browsing: %s!", site);
    }

    private boolean isValidURL(String url) {
        return !url.matches(".*\\d+.*");
    }

    @Override
    public String call(String phone) {
        if (!isValidPhone(phone)) {
            throw new IllegalArgumentException("Invalid number!");
        }

        return String.format("Calling... %s", phone);
    }

    private boolean isValidPhone(String phone) {
        return !phone.matches(".*[^\\d]+.*");
    }
}
