import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> map = generateMap();

        HashSet<String> finalRegions = new HashSet<>();
        HashSet<String> coveredObjects = new HashSet<>();

        greedAlgorytm(map, coveredObjects, finalRegions);

        System.out.println("Selected regions:");
        for (String region : finalRegions) {
            System.out.println(region);
        }
    }

    private static void greedAlgorytm(HashMap<String, HashSet<String>> map, HashSet<String> coveredObjects, HashSet<String> finalRegions) {
        while (!map.isEmpty()) {
            String bestRegion = null;
            HashSet<String> bestRegionObjects = new HashSet<>();

            for (String region : map.keySet()) {
                HashSet<String> regionObjects = map.get(region);
                HashSet<String> uncoveredObjects = new HashSet<>(regionObjects);
                uncoveredObjects.removeAll(coveredObjects);

                if (uncoveredObjects.size() > bestRegionObjects.size()) {
                    bestRegion = region;
                    bestRegionObjects = uncoveredObjects;
                }
            }

            // Add the best region to the final list and mark its objects as covered
            if (bestRegion != null) {
                finalRegions.add(bestRegion);
                coveredObjects.addAll(map.get(bestRegion));
                map.remove(bestRegion);
            }
            else {
                break;
            }
        }
    }

    private static HashMap<String, HashSet<String>> generateMap() {
        HashSet<String> regions = new HashSet<>();
        regions.addAll(Arrays.asList(
                "First region",
                "Second region",
                "Third region",
                "Fourth region",
                "Fifth region",
                "Sixth region",
                "Seventh region",
                "Eighth region"));

        HashMap<String, HashSet<String>> map = new HashMap<>();

        for (String region : regions) {
            map.put(region, new HashSet<>());
        }

        for (String s : Arrays.asList(
                "Silverstream River",
                "Emerald Bay",
                "Crystal Ridge",
                "Golden Rapids")) {
            map.get("First region").add(s);
        }

        for (String s : Arrays.asList(
                "Whispering Brook",
                "Misty Grove",
                "Twilight Timber",
                "Golden Rapids",
                "Crystal Ridge")) {
            map.get("Second region").add(s);
        }

        for (String s : Arrays.asList(
                "Thunder Mountain",
                "Golden Rapids",
                "Whispering Brook",
                "Crystal Ridge",
                "Enchanted Forest")) {
            map.get("Third region").add(s);
        }

        for (String s : Arrays.asList(
                "Sapphire Lagoon",
                "Crystal Waters",
                "Sunlit Atoll",
                "Whispering Brook",
                "Twilight Timber")) {
            map.get("Fourth region").add(s);
        }

        for (String s : Arrays.asList("Mirror Lake",
                "Silent Summit",
                "Sunset Beach",
                "Golden Rapids",
                "Enchanted Forest")) {
            map.get("Fifth region").add(s);
        }

        for (String s : Arrays.asList("Golden Dunes",
                "Whispering Sands",
                "Serene Pond",
                "Twilight Timber",
                "Crystal Waters")) {
            map.get("Sixth region").add(s);
        }

        for (String s : Arrays.asList("Snowcap Heights",
                "Emerald Woods",
                "Coral Isle",
                "Sapphire Lagoon",
                "Sunlit Atoll")) {
            map.get("Seventh region").add(s);
        }

        for (String s : Arrays.asList("Majestic Peaks",
                "Blue Haven",
                "Verdant Valley",
                "Golden Rapids",
                "Whispering Brook")) {
            map.get("Eighth region").add(s);
        }
        return map;
    }
}
