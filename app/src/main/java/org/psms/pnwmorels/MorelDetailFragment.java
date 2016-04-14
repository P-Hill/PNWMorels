package org.psms.pnwmorels;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.psms.pnwmorels.data.MorelDataProvider;
import org.psms.pnwmorels.data.MorelItem;

/**
 * A fragment representing the content of a single Morel detail screen.
 * This fragment is either contained in a {@link MorelListActivity}
 * in two-pane mode (on tablets) or a {@link MorelDetailActivity}
 * on handsets.
 */
public class MorelDetailFragment extends Fragment {
/**
 * The fragment argument representing the item ID that this fragment
 * represents.
 */
public static final String ARG_ITEM_ID = "item_id";

/**
 * The content this fragment is presenting.
 */
private MorelItem item;

/**
 * Mandatory empty constructor for the fragment manager to instantiate the
 * fragment (e.g. upon screen orientation changes).
 */
public MorelDetailFragment() {
}

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (getArguments().containsKey(ARG_ITEM_ID)) {
        // Load the dummy content specified by the fragment
        // arguments. In a real-world scenario, use a Loader
        // to load content from a content provider.
        String key = getArguments().getString(ARG_ITEM_ID);
        item = MorelDataProvider.ITEM_MAP.get(key);

        Activity activity = this.getActivity();
        CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
        if (appBarLayout != null) {
            appBarLayout.setTitle(item.scienceName);
        }
    }
}

/**
 * fills in the individual views in the content of detail view.
 * @param inflater
 * @param container
 * @param savedInstanceState
 * @return the completed root view
 */
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.morel_detail, container, false);

    // Show the content
    if (item != null) {
        ((TextView) rootView.findViewById(R.id.detail_brief)).setText(item.scienceName);
        ((TextView) rootView.findViewById(R.id.detail_long)).setText(item.content);
        if (item.image != null && item.image != "") {
            ImageView image = (ImageView)(rootView.findViewById(R.id.detail_image_main));
            int resID = Integer.valueOf(item.image);
            image.setImageResource(resID);
        }
    }

    return rootView;
}
}
