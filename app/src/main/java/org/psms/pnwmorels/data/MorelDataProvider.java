package org.psms.pnwmorels.data;

import org.psms.pnwmorels.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing Morel content for the user interfaces.
 * Obviously a stub. A larger app would read the data from files.
 * <p>
 */
public class MorelDataProvider {

    private static final String[][] SOURCE = {
        { "1", "Morchella tomentosa",
                "Fuzzy Foot Morel",
                "This is a burn morel. The Cap and stipe (stem) are covered with fine hairs.",
                "Taylor Lockwood",
                "" + R.drawable.lockwood_morchella_tomentosa_01},
        { "2", "Morchella tridentina",
                "Western (Mountain) Blond",
                "A blond morel with the vertical ridges like black morels, " +
                    "but the ridges do not darken with age. Found in forests in mountains. Synonymized names include " +
                        "Morchella " +
                    "frustrata and Morchella elatoides.",
                "Michael Beug",
                "" + R.drawable.morchella_tridentina_michael_beug},
        { "3", "Morchella populiphila",
                "(Western) Half-Free Morel",
                "A Morel found with black cottonwood (Populus trichocarpa) which has a stem that does goes " +
                    "partially up under the cap. It is not the same as  M. punctipes in eastern North America " +
                    "and M. semilibera in Europe both of which are also half-free morels.",
                "Ben Woo",
                "" + R.drawable.morchella_populiphila_ben_woo
                },
        { "4", "Morchella eximia (group)",
                "Black Burn Morel",
                "A dark black (or brown) morel found in burns that includes " +
                    "old names M. anthracophila, M. carbonaria, M. septimelata. Can not be distinguished " +
                    "macroscopically from Morchella sextelata or Morchella exuberans.",
                "Michael Beug",
                "" + R.drawable.morchella_eximia_1_michael_beug},
        { "5", "Morchella importuna",
                "Landscape Morel",
                    "A black morel, found in wood-chip, gardens, and landscapes. " +
                    "Its regular horizontal ridges often give a ladder-like appearance.  It is often narrow and pointed.",
                "Michael Beug",
                "" + R.drawable.morchella_importuna_2_michael_beug},
        { "6", "Morchella brunnea",
                "Black Hardwood Morel",
                "A natural black morel. Always has dark edges even when young. It grows in forests with hardwoods.",
                "Michael Beug",
                "" + R.drawable.morchella_brunnea_michael_beug},
        { "7", "Morchella Americana", "Common North American Blond Morel",
                "The most common morel in Eastern North America, but limited in Western NA.  Found with hardwoods and " +
                "fruit trees. M. esculentoides and M. californica are synonyms.",
                "Michael Beug",
                "" + R.drawable.morchella_americana_1_michael_beug},
        { "8", "Morchella prava",
                "Dark-Pitted Blond Morel",
                "This morel is light on the edges and has dark interior in the pits or grooves.",
                "Michael Beug",
                "" + R.drawable.morchella_prava_michael_beug },
        { "9", "Morchella rufobrunnea",
                "Blushing Morel",
                "This morel has is found in M. in disturbed soil or in " +
                    "woodchips used in landscaping. It has pale rides and darker pits. When touched it can bruise " +
                    "brownish orange to pinkish. According to DNA analysis it is neither a black nor a blond morel.",
                "Steve Trudell",
                "" + R.drawable.morchella_rufobrunnea_steve_trudell }

    };

/**
 * An array of items.
 */
public static final List<MorelItem> ITEMS = new ArrayList<MorelItem>();

/**
 * A map of sample items, by ID.
 */
public static final Map<String, MorelItem> ITEM_MAP = new HashMap<String, MorelItem>();

static {
    // initialize the sample items.
    for (int i = 0; i < SOURCE.length; i++) {
        addItem(createMorelItem(i));
    }
}

private static void addItem(MorelItem item) {
    ITEMS.add(item);
    ITEM_MAP.put(item.id +"", item);
}

private static MorelItem createMorelItem(int position) {
    String[] fields = SOURCE[position];
    return new MorelItem(position, fields[1], fields[2], fields[3], fields[4], fields[5]);
}

}
