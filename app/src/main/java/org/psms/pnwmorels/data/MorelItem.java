package org.psms.pnwmorels.data;

/**
 * An item representing the data to be displayed.
 */
public class MorelItem {
    public final Integer id;
    public final String commonName;
    public final String scienceName;
    public final String content;
    public final String photographer;
    public final String image;

    public MorelItem(Integer id, String scienceName, String commonName, String content, String photographer, String
                     image) {
        this.id = id;
        this.commonName = commonName;
        this.scienceName = scienceName;
        this.content = content;
        this.photographer = photographer;
        this.image = image;
    }

    @Override
    public String toString() {
        return id + commonName;
    }
}
