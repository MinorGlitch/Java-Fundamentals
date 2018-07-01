package militaryElite.leutenantGeneral;

import militaryElite.privateSoldier.IPrivate;
import militaryElite.privateSoldier.Private;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class LieutenantGeneral extends Private implements ILieutenantGeneral {
    private Set<IPrivate> privates;

    public LieutenantGeneral(String id, String firstName, String lastName, double salary, Set<IPrivate> privates) {
        super(id, firstName, lastName, salary);
        this.privates = new LinkedHashSet<>();
        this.privates.addAll(privates);
    }

    @Override
    public Set<IPrivate> getPrivates() {
        return Collections.unmodifiableSet(this.privates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString())
                .append(System.lineSeparator())
                .append("Privates: ");

        if (this.getPrivates().size() != 0) {
            privates.stream()
                    .sorted((a, b) -> Integer.valueOf(b.getId()) - Integer.valueOf(a.getId()))
                    .forEach(p -> sb.append(System.lineSeparator()).append("  ").append(p.toString()));
        }

        return sb.toString();
    }
}
