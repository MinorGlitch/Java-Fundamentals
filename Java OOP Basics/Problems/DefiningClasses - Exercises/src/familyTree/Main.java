package familyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, FamilyMember> membersByName = new LinkedHashMap<>();
        Map<String, FamilyMember> membersByBirthDate = new LinkedHashMap<>();

        String toPrint = reader.readLine();

        String line = reader.readLine();

        while (!"End".equals(line)) {
            Matcher nameAndName = Patterns.getNameAndName(line);
            Matcher nameAndDate = Patterns.getNameAndDate(line);
            Matcher dateAndName = Patterns.getDateAndName(line);
            Matcher dateAndDate = Patterns.getDateAndDate(line);
            Matcher nameAndDateNoH = Patterns.getNameAndDateNoHyphens(line);

            if (nameAndName.find()) {
                String parentFirstName = nameAndName.group(1);
                String parentLastName = nameAndName.group(2);
                String memberFirstName = nameAndName.group(3);
                String memberLastName = nameAndName.group(4);

                String fullParentName = parentFirstName + " " + parentLastName;
                String fullMemberName = memberFirstName + " " + memberLastName;

                FamilyMember member = new FamilyMember(memberFirstName, memberLastName, null);

                membersByName.putIfAbsent(member.getFullName(), member);

                if (fullParentName.equals(membersByName.get(fullParentName).getFullName())) {
                    member.addChild(new Child(memberFirstName, memberLastName, null));
                }

            } else if (nameAndDate.find()) {
                String parentFirstName = nameAndDate.group(1);
                String parentLastName = nameAndDate.group(2);
                String memberDate = nameAndDate.group(3);

                String fullParentName = parentFirstName + " " + parentLastName;

                FamilyMember member = new FamilyMember(null, null, memberDate);

                membersByBirthDate.putIfAbsent(memberDate, member);

                member.addParent(new Parent(parentFirstName, parentLastName, null));
            } else if (dateAndName.find()) {

            } else if (dateAndDate.find()) {
                String parentDate = dateAndDate.group(1);
                String memberDate = dateAndDate.group(2);

                FamilyMember member = new FamilyMember(null, null, memberDate);

                membersByBirthDate.putIfAbsent(memberDate, member);

                member.addParent(new Parent(null, null, parentDate));
            } else if (nameAndDateNoH.find()) {

            }


            line = reader.readLine();
        }
    }
}
