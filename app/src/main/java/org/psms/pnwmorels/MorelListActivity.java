package org.psms.pnwmorels;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import org.psms.pnwmorels.data.MorelDataProvider;
import org.psms.pnwmorels.data.MorelItem;

import java.util.List;

/**
 * An activity representing a list of Morels. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link MorelDetailActivity} representing
 * item image. On tablets, the activity presents the list of items and
 * item image side-by-side using two vertical panes.
 */
public class MorelListActivity extends AppCompatActivity {

/**
 * Whether or not the activity is in two-pane mode, i.e. running on a tablet
 * device.
 */
private boolean mTwoPane;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_morel_list);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    toolbar.setTitle(getTitle());

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    });

    View recyclerView = findViewById(R.id.morel_list);
    assert recyclerView != null;
    setupRecyclerView((RecyclerView) recyclerView);

    if (findViewById(R.id.morel_detail_container) != null) {
        // The detail container view will be present only in the
        // large-screen layouts (res/values-w900dp).
        // If this view is present, then the
        // activity should be in two-pane mode.
        mTwoPane = true;
    }
}

private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
    List<MorelItem> items = MorelDataProvider.ITEMS;
    recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(items));
}

public class SimpleItemRecyclerViewAdapter extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

    private final List<MorelItem> morelItems;

    public SimpleItemRecyclerViewAdapter(List<MorelItem> items) {
        morelItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.morel_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.item = morelItems.get(position);
        holder.commonNameView.setText(morelItems.get(position).commonName);
        holder.scienceNameView.setText(morelItems.get(position).scienceName);

        holder.rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(MorelDetailFragment.ARG_ITEM_ID, holder.item.id.toString());
                    MorelDetailFragment fragment = new MorelDetailFragment();
                    fragment.setArguments(arguments);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.morel_detail_container, fragment)
                            .commit();
                } else {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, MorelDetailActivity.class);
                    intent.putExtra(MorelDetailFragment.ARG_ITEM_ID, holder.item.id.toString());

                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return morelItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final View rowView;
        private final TextView commonNameView;
        private final TextView scienceNameView;
        private MorelItem item;

        public ViewHolder(View view) {
            super(view);
            rowView = view;
            commonNameView = (TextView) view.findViewById(R.id.id);
            scienceNameView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + scienceNameView.getText() + "'";
        }
    }
}
}
